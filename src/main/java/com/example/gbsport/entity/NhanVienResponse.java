package com.example.gbsport.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public interface NhanVienResponse {
    Integer getIdNhanVien();
    String getMaNhanVien();
    String getTenNhanVien();
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date getNgaySinh();
    String getEmail();
    String getDiaChiLienHe();
    boolean getGioiTinh();
    String getSoDienThoai();
    String getTrangThai();
}
