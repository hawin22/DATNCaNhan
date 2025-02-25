package com.example.gbsport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hoa_don;
    private String ma_hoa_don;
    private Integer id_nhan_vien;
    private Integer id_khach_hang;
    private Date ngay_tao;
    private Date ngay_sua;
    private String trang_thai;
    private Integer id_voucher;
    private String sdt_nguoi_nhan;
    private String dia_chi;
    private String email;
    private double tong_tien_truoc_giam;
    private double phi_van_chuyen;
    private String ho_ten;
    private double tong_tien_sau_giam;
    private String hinh_thuc_thanh_toan;
    private String phuong_thuc_nhan_hang;

}
