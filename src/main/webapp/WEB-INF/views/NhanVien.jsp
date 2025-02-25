<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div class="container mt-4">
    <h2>Danh sách nhân viên</h2>

    <!-- Bộ lọc trạng thái -->
    <div>
        <label>Trạng thái:</label>
        <input type="radio" name="status" value="active" > Đang hoạt động
        <input type="radio" name="status" value="inactive"> Đã nghỉ việc
        <input type="radio" name="status" value="inactive"> Tất cả
    </div>
    <a href="/quan-ly-nhan-viens/addNV">
        <button type="submit" class="btn btn-primary">Tạo tài khoản</button></a>
    <!-- Bảng danh sách nhân viên -->
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã nhân viên</th>
            <th>Họ và tên</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Email</th>
            <th>Trạng thái</th>
            <th>Chức vụ</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nv" items="${nhanViens}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${nv.ma_nhan_vien}</td>
                <td>${nv.ten_nhan_vien}</td>
                <td>${nv.gioi_tinh}</td>
                <td>${nv.ngay_sinh}</td>
                <td>${nv.so_dien_thoai}</td>
                <td>${nv.dia_chi_lien_he}</td>
                <td>${nv.email}</td>
                <td>${nv.trang_thai}</td>
                <td>${nv.ten_roles}</td>
                <td>
                    <a href="sua-nhan-vien?id=${nv.ma_nhan_vien}" class="btn btn-sm btn-warning">✏️</a>
                    <a href="xoa-nhan-vien?id=${nv.ma_nhan_vien}" class="btn btn-sm btn-danger">🗑️</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Phân trang -->
    <nav>
        <ul class="pagination">
            <c:if test="${currentPage > 0}">
                <li class="page-item">
                    <a class="page-link" href="quan-ly-nhan-viens?page=${currentPage - 1}&size=${pageSize}">Trước</a>
                </li>
            </c:if>
            <li class="page-item">
                <span class="page-link">${currentPage + 1}</span>
            </li>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="quan-ly-nhan-viens?page=${currentPage + 1}&size=${pageSize}">Tiếp</a>
                </li>
            </c:if>
        </ul>
    </nav>

</div>
</body>
</html>