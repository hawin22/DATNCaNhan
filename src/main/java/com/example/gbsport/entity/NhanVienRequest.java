package com.example.gbsport.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class NhanVienRequest {
    private Integer idNhanVien;

//    @NotBlank(message = "Không được để trống mã")
    private String maNhanVien;

//    @NotBlank(message = "Không được để trống tên")
    private String tenNhanVien;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "Không được để trống ngày sinh")
    private Date ngaySinh;

//    @NotBlank(message = "Không được để trống email")
//    @Email(message = "Email không hợp lệ")
    private String email;

//    @NotBlank(message = "Không được để trống địa chỉ liên hệ")
    private String diaChiLienHe;

//    @NotNull(message = "Chưa chọn giới tính")
    private Boolean gioiTinh;

//    @NotBlank(message = "Không được để trống số điện thoại")
    private String soDienThoai;

//    @NotBlank(message = "Không được để trống trạng thái")
    private String trangThai;

    private Roles roles;
    private TaiKhoan taiKhoan;

}
