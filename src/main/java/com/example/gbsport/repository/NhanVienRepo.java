package com.example.gbsport.repository;

import com.example.gbsport.entity.NhanVien;
import com.example.gbsport.entity.NhanVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
//    @Query(nativeQuery = true, value = "select id_nhan_vien, ma_nhan_vien,ten_nhan_vien, ngay_sinh, email, dia_chi_lien_he, gioi_tinh, so_dien_thoai, trang_thai, r.ten_roles as ten_roles, tk.ten_dang_nhap as ten_dang_nhap from nhan_vien nv\n" +
//            "join tai_khoan tk on nv.id_tai_khoan = tk.id_tai_khoan\n" +
//            "join roles r on nv.id_roles = r.id_roles")
//    List<NhanVienResponse> getAll();
//
//    @Query(nativeQuery = true, value = "select id_nhan_vien, ma_nhan_vien,ten_nhan_vien, ngay_sinh, email, dia_chi_lien_he, gioi_tinh, so_dien_thoai, trang_thai, r.ten_roles as ten_roles, tk.ten_dang_nhap as ten_dang_nhap from nhan_vien nv\n" +
//            "join tai_khoan tk on nv.id_tai_khoan = tk.id_tai_khoan\n" +
//            "join roles r on nv.id_roles = r.id_roles")
//    Page<NhanVienResponse> listPT(Pageable pageable);
//
//    @Query(nativeQuery = true, value = "select id_nhan_vien, ma_nhan_vien,ten_nhan_vien, ngay_sinh, email, dia_chi_lien_he, gioi_tinh, so_dien_thoai, trang_thai, r.ten_roles as ten_roles, tk.ten_dang_nhap as ten_dang_nhap from nhan_vien nv\n" +
//            "join tai_khoan tk on nv.id_tai_khoan = tk.id_tai_khoan\n" +
//            "join roles r on nv.id_roles = r.id_roles WHERE \n" +
//            "(email like %:keyword% OR \n" +
//            "LOWER(ten_nhan_vien) LIKE LOWER(CONCAT('%', :keyword, '%')) OR \n" +
//            "so_dien_thoai like %:keyword%)")
//    List<NhanVienResponse> timNhanVien(@Param("keyword") String keyword);
//
//    @Query(value = "select id_nhan_vien, ma_nhan_vien,ten_nhan_vien, ngay_sinh, email, dia_chi_lien_he, gioi_tinh, so_dien_thoai, trang_thai, r.ten_roles as ten_roles, tk.ten_dang_nhap as ten_dang_nhap from nhan_vien nv\n" +
//            "join tai_khoan tk on nv.id_tai_khoan = tk.id_tai_khoan\n" +
//            "join roles r on nv.id_roles = r.id_roles WHERE (trang_thai = :trangThai)", nativeQuery = true)
//    List<NhanVienResponse> locNhanVienTheoTrangThai(@Param("trangThai") String trangThai);

    @Query(nativeQuery = true, value = """
        SELECT id_nhan_vien AS idNhanVien, ma_nhan_vien AS maNhanVien, ten_nhan_vien AS tenNhanVien, 
               ngay_sinh AS ngaySinh, email, dia_chi_lien_he AS diaChiLienHe, gioi_tinh AS gioiTinh, 
               so_dien_thoai AS soDienThoai, trang_thai AS trangThai, 
               r.ten_roles AS tenRoles, tk.ten_dang_nhap AS tenDangNhap
        FROM nhan_vien nv
        JOIN tai_khoan tk ON nv.id_tai_khoan = tk.id_tai_khoan
        JOIN roles r ON nv.id_roles = r.id_roles
    """)
    List<NhanVienResponse> getAll();

    @Query(nativeQuery = true, value = """
        SELECT id_nhan_vien AS idNhanVien, ma_nhan_vien AS maNhanVien, ten_nhan_vien AS tenNhanVien, 
               ngay_sinh AS ngaySinh, email, dia_chi_lien_he AS diaChiLienHe, gioi_tinh AS gioiTinh, 
               so_dien_thoai AS soDienThoai, trang_thai AS trangThai, 
               r.ten_roles AS tenRoles, tk.ten_dang_nhap AS tenDangNhap
        FROM nhan_vien nv
        JOIN tai_khoan tk ON nv.id_tai_khoan = tk.id_tai_khoan
        JOIN roles r ON nv.id_roles = r.id_roles
    """)
    Page<NhanVienResponse> listPT(Pageable pageable);

    @Query(nativeQuery = true, value = """
        SELECT id_nhan_vien AS idNhanVien, ma_nhan_vien AS maNhanVien, ten_nhan_vien AS tenNhanVien, 
               ngay_sinh AS ngaySinh, email, dia_chi_lien_he AS diaChiLienHe, gioi_tinh AS gioiTinh, 
               so_dien_thoai AS soDienThoai, trang_thai AS trangThai, 
               r.ten_roles AS tenRoles, tk.ten_dang_nhap AS tenDangNhap
        FROM nhan_vien nv
        JOIN tai_khoan tk ON nv.id_tai_khoan = tk.id_tai_khoan
        JOIN roles r ON nv.id_roles = r.id_roles
        WHERE email LIKE %:keyword% 
        OR LOWER(ten_nhan_vien) LIKE LOWER(CONCAT('%', :keyword, '%')) 
        OR so_dien_thoai LIKE %:keyword%
    """)
    List<NhanVienResponse> timNhanVien(@Param("keyword") String keyword);

    @Query(nativeQuery = true, value = """
        SELECT id_nhan_vien AS idNhanVien, ma_nhan_vien AS maNhanVien, ten_nhan_vien AS tenNhanVien, 
               ngay_sinh AS ngaySinh, email, dia_chi_lien_he AS diaChiLienHe, gioi_tinh AS gioiTinh, 
               so_dien_thoai AS soDienThoai, trang_thai AS trangThai, 
               r.ten_roles AS tenRoles, tk.ten_dang_nhap AS tenDangNhap
        FROM nhan_vien nv
        JOIN tai_khoan tk ON nv.id_tai_khoan = tk.id_tai_khoan
        JOIN roles r ON nv.id_roles = r.id_roles
        WHERE trang_thai = :trangThai
    """)
    List<NhanVienResponse> locNhanVienTheoTrangThai(@Param("trangThai") String trangThai);
    boolean existsByMaNhanVien(String maNhanVien);
    boolean existsByEmail(String email);
    boolean existsBySoDienThoai(String soDienThoai);
//    @Query(nativeQuery = true, value = "SELECT * FROM nhan_vien WHERE \n" +
//            "(email like %:keyword% OR \n" +
//            "LOWER(ten_nhan_vien) LIKE LOWER(CONCAT('%', :keyword, '%')) OR \n" +
//            "so_dien_thoai like %:keyword%)")
//    Page<NhanVienResponse> timNhanVien(@Param("keyword") String keyword, Pageable pageable);

}
