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
    private Integer id_nhan_vien;
    @NotBlank(message = "Không được để trống mã")
    private String ma_nhan_vien;
    @NotBlank(message = "Không được để trống tên")
    private String ten_nhan_vien;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được để trống ngày sinh")
    private Date ngay_sinh;
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Không được để trống địa chỉ liên hệ")
    private String dia_chi_lien_he;
    @NotNull(message = "Chưa chọn giới tính")
    private Boolean gioi_tinh;
    @NotBlank(message = "Không được để trống số điện thoại")
    private String so_dien_thoai;
    @NotBlank(message = "Không được để trống trạng thái")
    private String trang_thai;

    private Roles roles;

    private TaiKhoan taiKhoan;

}
