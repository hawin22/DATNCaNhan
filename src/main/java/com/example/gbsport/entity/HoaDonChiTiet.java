//package com.example.gbsport.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "hoa_don_chi_tiet")
//public class HoaDonChiTiet {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_hoa_don_chi_tiet;
//    private Integer so_luong;
//    private double don_gia;
//    @ManyToOne
//    @JoinColumn(name = "id_hoa_don")
//    private HoaDon hoaDon;
//    @ManyToOne
//    @JoinColumn(name = "id_chi_tiet_san_pham")
//    private ChiTietSanPham chiTietSanPham;
//}
