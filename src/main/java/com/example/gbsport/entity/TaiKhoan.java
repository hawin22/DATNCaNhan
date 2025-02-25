package com.example.gbsport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tai_khoan;
//    @NotBlank(message = "Không được để trống mã tài khoản")
    private String ma_tai_khoan;
//    @NotBlank(message = "Không được để trống tên đăng nhập")
    private String ten_dang_nhap;
//    @NotBlank(message = "Không được để trống mật khẩu")
    private String mat_khau;
}
