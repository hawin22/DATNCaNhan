<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div class="container mt-4 ">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <form class="d-flex justify-content-start flex-grow-1 me-3" action="/quan-ly-nhan-viens/searchNV" method="get">
            <div class="input-group" style="max-width: 60%;">
                <input type="text" class="form-control form-control-lg" placeholder="Bạn đang muốn tìm ai?"
                       name="keyword">
                <button class="btn btn-light border" type="submit">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="gray" class="bi bi-search"
                         viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.099zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg>
                </button>
            </div>
        </form>
        <a href="/quan-ly-nhan-viens/addNV">
            <button type="submit" class="btn btn-primary">Tạo tài khoản</button>
        </a>
    </div>


    <!-- Bộ lọc trạng thái -->
    <div class="mb-4">
        <label>Trạng thái:</label>
        <form action="/quan-ly-nhan-viens/locTrangThaiNV" method="get">
            <input type="radio" name="trangThai" value="Đang hoạt động" onchange="this.form.submit()"
            ${selectedTrangThai == 'Đang hoạt động' ? 'checked' : ''}> Đang hoạt động
            <input type="radio" name="trangThai" value="Đã nghỉ việc" onchange="this.form.submit()"
            ${selectedTrangThai == 'Đã nghỉ việc' ? 'checked' : ''}> Đã nghỉ việc
            <input type="radio" name="trangThai" onchange="this.form.submit()"
            value="all"> Tất cả
        </form>
    </div>
    <h2>Danh sách nhân viên</h2>
    <!-- Bảng danh sách nhân viên -->
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã nhân viên</th>
            <th>Tên nhân viên</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Email</th>
            <th>Trạng thái</th>
            <th>Chức vụ</th>
            <th>Tên tài khoản</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nv" items="${nhanViens}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${nv.ma_nhan_vien}</td>
                <td>${nv.ten_nhan_vien}</td>
                <td>${nv.gioi_tinh?"Nam":"Nữ"}</td>
                <td>${nv.ngay_sinh}</td>
                <td>${nv.so_dien_thoai}</td>
                <td>${nv.dia_chi_lien_he}</td>
                <td>${nv.email}</td>
                <td>${nv.trang_thai}</td>
                <td>${nv.ten_roles}</td>
                <td>${nv.ten_dang_nhap}</td>
                <td>
                    <a href="/quan-ly-nhan-viens/detailNV/${nv.id_nhan_vien}" class="btn btn-sm btn-warning">✏️</a>
                    <a href="/quan-ly-nhan-viens/changeStatus/${nv.id_nhan_vien}"
                       onclick="return confirm('Bạn có muốn chuyển trạng thái không??')" class="btn btn-sm btn-danger">🗑️</a>
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