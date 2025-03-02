<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhân Viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-3">Thêm Nhân Viên</h2>

    <!-- Hiển thị thông báo lỗi -->
<%--    <c:if test="${not empty error}">--%>
<%--        <div class="alert alert-danger">${error}</div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${not empty success}">--%>
<%--        <div class="alert alert-success">${success}</div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${not empty errors}">--%>
<%--        <div class="alert alert-danger">--%>
<%--            <ul>--%>
<%--                <c:forEach var="error" items="${errors}">--%>
<%--                    <li>${error.defaultMessage}</li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </c:if>--%>
    <form:form action="/quan-ly-nhan-viens/suaNV/${detailNV.id_nhan_vien}" method="post" modelAttribute="nhanVien">
        <div class="mb-3">
            <label class="form-label">Mã Nhân Viên</label>
            <input type="text" class="form-control" name="ma_nhan_vien" value="${detailNV.ma_nhan_vien}" disabled>
            <form:errors path="ma_nhan_vien" cssClass="text-danger"></form:errors>
        </div>

        <div class="mb-3">
            <label class="form-label">Tên nhân viên</label>
            <input type="text" class="form-control" name="ten_nhan_vien" value="${detailNV.ten_nhan_vien}" required>
<%--            <form:errors path="ten_nhan_vien" cssClass="text-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="true" name="gioi_tinh" ${detailNV.gioi_tinh?"checked":""} >
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="false" name="gioi_tinh" ${!detailNV.gioi_tinh?"checked":""}>
                <label class="form-check-label">
                    Nữ
                </label>
            </div>
<%--            <form:errors path="gioi_tinh" cssClass="text-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" name="ngay_sinh" required value="${detailNV.ngay_sinh}">
<%--            <form:errors path="ngay_sinh" cssClass="text-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label">Số Điện Thoại</label>
            <input type="text" class="form-control" name="so_dien_thoai" required value="${detailNV.so_dien_thoai}">
<%--            <form:errors path="so_dien_thoai" cssClass="text-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control"  name="dia_chi_lien_he" required value="${detailNV.dia_chi_lien_he}">
<%--            <form:errors path="dia_chi_lien_he" cssClass="text-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control"  name="email" required value="${detailNV.email}">
<%--            <form:errors path="email" cssClass="text-danger"></form:errors>--%>
        </div>

<%--        <div class="mb-3">--%>
<%--            <label class="form-label">Trạng Thái</label>--%>
<%--            <div class="form-check">--%>
<%--                <input class="form-check-input" type="radio" value="Đang hoạt động" name="trang_thai" ${detailNV.trang_thai=="Đang hoạt động"?"checked":""} >--%>
<%--                <label class="form-check-label">--%>
<%--                    Đang hoạt động--%>
<%--                </label>--%>
<%--            </div>--%>
<%--            <div class="form-check">--%>
<%--                <input class="form-check-input" type="radio" value="Đã nghỉ việc" name="trang_thai" ${detailNV.trang_thai=="Đã nghỉ việc"?"checked":""}>--%>
<%--                <label class="form-check-label">--%>
<%--                   Đã nghỉ việc--%>
<%--                </label>--%>
<%--            </div>--%>
<%--&lt;%&ndash;            <form:errors path="trang_thai" cssClass="text-danger"></form:errors>&ndash;%&gt;--%>
<%--        </div>--%>

        <div class="mb-3">
            <label class="form-label">Chức vụ</label>
            <select class="form-control" name="roles">
                <c:forEach items="${listRoles}" var="lstR">
                    <option value="${lstR.id_roles}" ${lstR.id_roles==detailNV.roles.id_roles?"selected":""}>${lstR.ten_roles}</option>
                </c:forEach>
            </select>
<%--            <form:errors path="roles" cssClass="text-danger"></form:errors>--%>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên tài khoản</label>
            <select class="form-control" name="taiKhoan">
                <c:forEach items="${listTK}" var="listTK">
                    <option value="${listTK.id_tai_khoan}"${listTK.id_tai_khoan==detailNV.taiKhoan.id_tai_khoan?"selected":""}>${listTK.ten_dang_nhap}</option>
                </c:forEach>
            </select>
                <%--            <form:errors path="roles" cssClass="text-danger"></form:errors>--%>
        </div>

        <button type="submit" formaction="/quan-ly-nhan-viens/suaNV/${detailNV.id_nhan_vien}" class="btn btn-primary" onclick="return confirm('Bạn có muốn sửa không')">Sửa nhân viên</button>
        <a href="/quan-ly-nhan-viens" class="btn btn-secondary">Quay lại</a>
    </form:form>
</div>
</body>
</html>
