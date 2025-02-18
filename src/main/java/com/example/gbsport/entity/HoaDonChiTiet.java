package com.example.gbsport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hoa_don_chi_tiet;
    private Integer id_chi_tiet_san_pham;
    private Integer so_luong;
    private double don_gia;
    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;
}
