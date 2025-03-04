package com.example.gbsport.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class NhanVienRequest {
    private Integer idNhanVien;
//
////    @NotBlank(message = "Không được để trống mã")
//    private String maNhanVien;
//
////    @NotBlank(message = "Không được để trống tên")
//    private String tenNhanVien;
//
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
////    @NotNull(message = "Không được để trống ngày sinh")
//    private Date ngaySinh;
//
////    @NotBlank(message = "Không được để trống email")
////    @Email(message = "Email không hợp lệ")
//    private String email;
//
////    @NotBlank(message = "Không được để trống địa chỉ liên hệ")
//    private String diaChiLienHe;
//
////    @NotNull(message = "Chưa chọn giới tính")
//    private Boolean gioiTinh;
//
////    @NotBlank(message = "Không được để trống số điện thoại")
//    private String soDienThoai;
//
////    @NotBlank(message = "Không được để trống trạng thái")
//    private String trangThai;
@JsonProperty("ma_nhan_vien")
private String maNhanVien;

    @JsonProperty("ten_nhan_vien")
    private String tenNhanVien;

    @JsonProperty("ngay_sinh")
    private Date ngaySinh;

    private String email;

    @JsonProperty("dia_chi_lien_he")
    private String diaChiLienHe;

    @JsonProperty("gioi_tinh")
    private Boolean gioiTinh;

    @JsonProperty("so_dien_thoai")
    private String soDienThoai;

    @JsonProperty("trang_thai")
    private String trangThai;

    private Roles roles;
    private TaiKhoan taiKhoan;

}
