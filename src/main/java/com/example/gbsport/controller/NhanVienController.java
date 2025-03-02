package com.example.gbsport.controller;

import com.example.gbsport.entity.NhanVien;
import com.example.gbsport.entity.NhanVienRequest;
import com.example.gbsport.entity.NhanVienResponse;
import com.example.gbsport.repository.NhanVienRepo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class NhanVienController {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @GetMapping("/quan-ly-nhan-vien/findAll")
    public List<NhanVien> findAll() {
        return nhanVienRepo.findAll();
    }


    //    @GetMapping("/quan-ly-nhan-vien")
//    public List<NhanVienResponse> getAll(){
//        return nhanVienRepo.getAll();
//    }
    @GetMapping("/quan-ly-nhan-vien")
    public List<NhanVienResponse> phanTrang(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<NhanVienResponse> list = nhanVienRepo.listPT(pageable);
        return list.getContent();
    }
    ArrayList<String> mangLoi = new ArrayList<>();
    private ArrayList<String> validateNhanVien(NhanVienRequest nhanVienRequest) {

        // Kiểm tra trống
        if (nhanVienRequest.getMaNhanVien() == null || nhanVienRequest.getMaNhanVien().trim().isEmpty()) {
            mangLoi.add("Mã nhân viên không được để trống") ;
        }
        if (nhanVienRequest.getTenNhanVien() == null || nhanVienRequest.getTenNhanVien().trim().isEmpty()) {
            mangLoi.add("Tên nhân viên không được để trống") ;
        }
        if (nhanVienRequest.getEmail() == null || nhanVienRequest.getEmail().trim().isEmpty()) {
            mangLoi.add("Email không được để trống") ;
        }
        if (nhanVienRequest.getSoDienThoai() == null || nhanVienRequest.getSoDienThoai().trim().isEmpty()) {
            mangLoi.add("Số điện thoại không được để trống") ;
        }

//        // Kiểm tra trùng mã, email, số điện thoại
//        if (nhanVienRepo.existsByMaNhanVien(nhanVienRequest.getMaNhanVien())) {
//            return "Mã nhân viên đã tồn tại";
//        }
//        if (nhanVienRepo.existsByEmail(nhanVienRequest.getEmail())) {
//            return "Email đã tồn tại";
//        }
//        if (nhanVienRepo.existsBySoDienThoai(nhanVienRequest.getSoDienThoai())) {
//            return "Số điện thoại đã tồn tại";
//        }

        return mangLoi; // Không có lỗi
    }
//    private void validateNhanVien(NhanVienRequest nhanVienRequest) {
//        if (nhanVienRequest.getMaNhanVien() == null || nhanVienRequest.getMaNhanVien().trim().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mã nhân viên không được để trống.");
//        }
//        if (nhanVienRepo.existsByMaNhanVien(nhanVienRequest.getMaNhanVien())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mã nhân viên đã tồn tại.");
//        }
//        if (nhanVienRequest.getTenNhanVien() == null || nhanVienRequest.getTenNhanVien().trim().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tên nhân viên không được để trống.");
//        }
//        if (nhanVienRequest.getNgaySinh() == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ngày sinh không được để trống.");
//        }
//        if (nhanVienRequest.getEmail() == null || nhanVienRequest.getEmail().trim().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email không được để trống.");
//        }
//        if (nhanVienRepo.existsByEmail(nhanVienRequest.getEmail())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email đã tồn tại.");
//        }
//        if (nhanVienRequest.getSoDienThoai() == null || nhanVienRequest.getSoDienThoai().trim().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Số điện thoại không được để trống.");
//        }
//        if (nhanVienRepo.existsBySoDienThoai(nhanVienRequest.getSoDienThoai())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Số điện thoại đã tồn tại.");
//        }

        // Kiểm tra tuổi (18 - 60)
//        if (nhanVienRequest.getNgaySinh() != null) {
//            int age = Period.between(nhanVienRequest.getNgaySinh(), LocalDate.now()).getYears();
//            if (age < 18 || age > 60) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nhân viên phải từ 18 đến 60 tuổi.");
//            }
//        }
//    }

    @PostMapping("/quan-ly-nhan-vien/add")
    public String add(@RequestBody NhanVienRequest nhanVienRequest) {
        if (validateNhanVien(nhanVienRequest).isEmpty()){
            NhanVien nhanVien = new NhanVien();
            BeanUtils.copyProperties(nhanVienRequest, nhanVien);
            nhanVienRepo.save(nhanVien);
            return "Thêm thành công";
        }else {
            return mangLoi.toString()+"\n"+"Thêm tặc bại";
        }

    }

    @PostMapping("/quan-ly-nhan-vien/update")
    public String update(@RequestBody NhanVienRequest nhanVienRequest) {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(nhanVienRequest, nhanVien);
        nhanVienRepo.save(nhanVien);
        return "Sửa thành công";
    }

    @PostMapping("/quan-ly-nhan-vien/changeStatus")
    public String changeStatus(@RequestBody NhanVienRequest nhanVienRequest) {
        if (nhanVienRequest.getTrangThai().equals("Đang hoạt động")) {
            nhanVienRequest.setTrangThai("Đã nghỉ việc");
            NhanVien nhanVien = new NhanVien();
            BeanUtils.copyProperties(nhanVienRequest, nhanVien);
            nhanVienRepo.save(nhanVien);
        } else {
            nhanVienRequest.setTrangThai("Đang hoạt động");
            NhanVien nhanVien = new NhanVien();
            BeanUtils.copyProperties(nhanVienRequest, nhanVien);
            nhanVienRepo.save(nhanVien);
        }
        return "Chuyển trạng thái thành công";
    }
//Search NV API

//    @GetMapping("/quan-ly-nhan-vien/search")
//    public List<NhanVienResponse> timNhanVien(@RequestParam(name = "keyword", required = false) String keyword) {
//        return nhanVienRepo.timNhanVien(keyword);
//    }

    @GetMapping("/quan-ly-nhan-vien/locTrangThai")
    public List<NhanVienResponse> locNhanVien(@RequestParam(name = "trangThai", required = false) String trangThai) {
        return nhanVienRepo.locNhanVienTheoTrangThai(trangThai);
    }

    @PostMapping("addNhanVien")
    public ResponseEntity<?> saveNhanVien(@Valid @RequestBody NhanVienRequest nhanVienRequest, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        } else {
            NhanVien nv = new NhanVien();
            BeanUtils.copyProperties(nhanVienRequest, nv);
            nhanVienRepo.save(nv);
            return ResponseEntity.ok("Lưu thành công");

        }
    }

}
