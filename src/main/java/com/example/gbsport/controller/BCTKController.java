//package com.example.gbsport.controller;
//
//import com.example.gbsport.entity.NhanVien;
//import com.example.gbsport.entity.NhanVienRequest;
//import com.example.gbsport.entity.NhanVienResponse;
//import com.example.gbsport.repository.NhanVienRepo;
//import com.example.gbsport.repository.RolesRepo;
//import com.example.gbsport.repository.TaiKhoanRepo;
//import jakarta.validation.Valid;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Validated
//@Controller
//public class BCTKController {
//    @Autowired
//    private NhanVienRepo nhanVienRepo;
//    @Autowired
//    private RolesRepo rolesRepo;
//    @Autowired
//    private TaiKhoanRepo taiKhoanRepo;
//
//
//    @GetMapping("/quan-ly-nhan-viens")
//    public String getNhanViens(@RequestParam(value = "page", defaultValue = "0") int page,
//                               @RequestParam(value = "size", defaultValue = "5") int size,
//                               Model model) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<NhanVienResponse> list = nhanVienRepo.listPT(pageable);
//
//        model.addAttribute("nhanViens", list.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("pageSize", size);
//        model.addAttribute("totalPages", list.getTotalPages());
//
//        return "NhanVien"; // Trả về trang nhanvien.jsp
//    }
//    @GetMapping("/quan-ly-nhan-viens/addNV")
//    public String showAddForm(Model model) {
//        model.addAttribute("listRoles",rolesRepo.findAll());
//        model.addAttribute("listTK",taiKhoanRepo.findAll());
////        for (Roles role: rolesRepo.findAll()) {
////            role.toString();
////        }
//        return "ThemNhanVien"; // Trả về trang JSP
//    }
//    @PostMapping("/quan-ly-nhan-viens/addNV")
//    public String add(@Valid @ModelAttribute("nhanVien") NhanVienRequest nhanVienRequest,
//                      BindingResult result) {
//        if (result.hasErrors()){
//            return "ThemNhanVien";
//        }
//        else {
//        NhanVien nhanVien = new NhanVien();
//        BeanUtils.copyProperties(nhanVienRequest, nhanVien);
//        nhanVienRepo.save(nhanVien);
//        }
//        return "redirect:/quan-ly-nhan-viens";
//    }
//    @GetMapping("/quan-ly-nhan-viens/detailNV/{id}")
//    public String detail(Model model, @PathVariable Integer id){
//        model.addAttribute("detailNV", nhanVienRepo.findById(id).get());
//        model.addAttribute("listRoles", rolesRepo.findAll());
//        model.addAttribute("listTK", taiKhoanRepo.findAll());
//        return "SuaNhanVien";
//    }
//@PostMapping("/quan-ly-nhan-viens/suaNV/{id}")
//    public String update(@PathVariable Integer id,@Valid @ModelAttribute("nhanVien") NhanVienRequest nhanVienRequest,
//                         BindingResult result){
//    if (result.hasErrors()){
//        return "SuaNhanVien";
//    }
//    else {
//        NhanVien nhanVien = new NhanVien();
//        BeanUtils.copyProperties(nhanVienRequest, nhanVien);
//        nhanVien.setId_nhan_vien(id);
//        nhanVienRepo.save(nhanVien);
//    }
//    return "redirect:/quan-ly-nhan-viens";
//}
//    @GetMapping("/quan-ly-nhan-viens/changeStatus/{id}")
//    public String changeStatus(@PathVariable Integer id) {
//        NhanVien nhanVien = nhanVienRepo.findById(id).get();
//        if (nhanVien.getTrang_thai().equals("Đang hoạt động")) {
//            nhanVien.setTrang_thai("Đã nghỉ việc");
//            nhanVienRepo.save(nhanVien);
//        } else {
//            nhanVien.setTrang_thai("Đang hoạt động");
//            nhanVienRepo.save(nhanVien);
//        }
//        return "redirect:/quan-ly-nhan-viens";
//    }
//    @GetMapping("/quan-ly-nhan-viens/searchNV")
//    public String timNhanVien(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
//        model.addAttribute("nhanViens",nhanVienRepo.timNhanVien(keyword));
//        return "NhanVien";
//    }
//
////    @GetMapping("/quan-ly-nhan-viens/searchNV")
////    public String timNhanVien(@RequestParam(value = "page", defaultValue = "0") int page,
////                              @RequestParam(value = "size", defaultValue = "5") int size,
////                              @RequestParam(name = "keyword", required = false) String keyword,
////                              Model model) {
////        Pageable pageable = PageRequest.of(page, size);
////        model.addAttribute("nhanViens", nhanVienRepo.timNhanVien(keyword,pageable).getContent());
////        model.addAttribute("currentPage", page);
////        model.addAttribute("pageSize", size);
////        model.addAttribute("totalPages", nhanVienRepo.timNhanVien(keyword,pageable).getTotalPages());
////        return "NhanVien";
////    }
//@GetMapping("/quan-ly-nhan-viens/locTrangThaiNV")
//public String locNhanVien(Model model, @RequestParam(name = "trangThai", required = false) String trangThai) {
//    if ("all".equals(trangThai) || trangThai == null || trangThai.isEmpty()) {
//        return "redirect:/quan-ly-nhan-viens";
//    }
//        model.addAttribute("nhanViens",nhanVienRepo.locNhanVienTheoTrangThai(trangThai));
//    model.addAttribute("selectedTrangThai", trangThai);
//    return "NhanVien";
//}
//}
