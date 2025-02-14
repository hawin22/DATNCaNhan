package com.example.gbsport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tai_khoan;
    private String ma_tai_khoan;
    private String ten_dang_nhap;
    private String mat_khau;
}
