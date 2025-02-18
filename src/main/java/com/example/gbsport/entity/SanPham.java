package com.example.gbsport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_san_pham;
    private String ma_san_pham;
    private String ten_san_pham;
    private String mo_ta;
    private String trang_thai;
    private Boolean gioi_tinh;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    com.example.gbsports.entity.DanhMuc danhMuc;
    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu")
    com.example.gbsports.entity.ThuongHieu thuongHieu;
    @ManyToOne
    @JoinColumn(name = "id_chat_lieu")
    ChatLieu chatLieu;
}
