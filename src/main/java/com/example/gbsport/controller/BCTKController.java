package com.example.gbsport.controller;

import com.example.gbsport.entity.NhanVien;
import com.example.gbsport.entity.NhanVienRequest;
import com.example.gbsport.entity.NhanVienResponse;
import com.example.gbsport.entity.Roles;
import com.example.gbsport.repository.NhanVienRepo;
import com.example.gbsport.repository.RolesRepo;
import com.example.gbsport.repository.TaiKhoanRepo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class BCTKController {
    @Autowired
    private NhanVienRepo nhanVienRepo;
    @Autowired
    private RolesRepo rolesRepo;
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;


    @GetMapping("/quan-ly-nhan-viens")
    public String getNhanViens(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "5") int size,
                               Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<NhanVienResponse> list = nhanVienRepo.listPT(pageable);

        model.addAttribute("nhanViens", list.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalPages", list.getTotalPages());

        return "NhanVien"; // Trả về trang nhanvien.jsp
    }
    @GetMapping("/quan-ly-nhan-viens/addNV")
    public String showAddForm(Model model) {
        model.addAttribute("listRoles",rolesRepo.findAll());
        return "ThemNhanVien"; // Trả về trang JSP
    }
    @PostMapping("/quan-ly-nhan-viens/addNV")
    public String add(@Valid @ModelAttribute("nhanVien") NhanVienRequest nhanVienRequest,
                      BindingResult result) {
        if (result.hasErrors()){
            return "ThemNhanVien";
        }
        else {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(nhanVienRequest, nhanVien);
        nhanVienRepo.save(nhanVien);
        }
        return "redirect:/quan-ly-nhan-vien";
    }

}
