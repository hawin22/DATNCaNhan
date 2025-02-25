package com.example.gbsport.controller;

import com.example.gbsport.entity.NhanVien;
import com.example.gbsport.entity.NhanVienRequest;
import com.example.gbsport.entity.NhanVienResponse;
import com.example.gbsport.repository.NhanVienRepo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/quan-ly-nhan-vien/add")
    public String add(@RequestBody NhanVienRequest nhanVienRequest) {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(nhanVienRequest, nhanVien);
//        if (nhanVien.getMa_nhan_vien() == null
//                || nhanVien.getTen_nhan_vien() == null
//                || nhanVien.getNgay_sinh() == null
//                || nhanVien.getSo_dien_thoai() == null
//                || nhanVien.getEmail() == null
//                || nhanVien.getDia_chi_lien_he() == null
//                || nhanVien.getGioi_tinh() == null
//                || nhanVien.getTrang_thai() == null
//        ) {
//            return "Không được để trống";
//        } else {
        nhanVienRepo.save(nhanVien);
        return "Thêm thành công";
//        }
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
        if (nhanVienRequest.getTrang_thai().equals("Đang hoạt động")) {
            nhanVienRequest.setTrang_thai("Đã nghỉ việc");
            NhanVien nhanVien = new NhanVien();
            BeanUtils.copyProperties(nhanVienRequest, nhanVien);
            nhanVienRepo.save(nhanVien);
        } else {
            nhanVienRequest.setTrang_thai("Đang hoạt động");
            NhanVien nhanVien = new NhanVien();
            BeanUtils.copyProperties(nhanVienRequest, nhanVien);
            nhanVienRepo.save(nhanVien);
        }
        return "Chuyển trạng thái thành công";
    }

    @GetMapping("/quan-ly-nhan-vien/search")
    public List<NhanVienResponse> timNhanVien(@RequestParam(name = "keyword", required = false) String keyword) {
        return nhanVienRepo.timNhanVien(keyword);
    }

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
