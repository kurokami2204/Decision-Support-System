package com.example.hetrogiupluachonmonan;

public class DiemMonAn {
    public String tenMonAn;
    public double giaTriDinhDuong;
    public double giaThanh;
    public double danhGia;
    public double NguyenLieu1;
    public double diemPhuHop;

    public double getDiemPhuHop() {
        return diemPhuHop;
    }

    public void setDiemPhuHop(double diemPhuHop) {
        this.diemPhuHop = diemPhuHop;
    }

    public DiemMonAn(String tenMonAn, double giaTriDinhDuong, double Nguyenlieu1, double giaThanh, double danhGia) {
        this.tenMonAn = tenMonAn;
        this.giaTriDinhDuong = giaTriDinhDuong;
        this.NguyenLieu1 = Nguyenlieu1;
        this.giaThanh = giaThanh;
        this.danhGia = danhGia;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn= tenMonAn;
    }


    public double getGiaTriDinhDuong() {
        return giaTriDinhDuong;
    }

    public void setGiaTriDinhDuong(float giaTriDinhDuong) {
        this.giaTriDinhDuong = giaTriDinhDuong;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(float giaThanh) {
        this.giaThanh = giaThanh;
    }

    public double getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(float danhGia) {
        this.danhGia = danhGia;
    }

    public double getNguyenLieu1() {
        return NguyenLieu1;
    }

    public void setNguyenLieu1(double NguyenLieu) {
        this.NguyenLieu1 = NguyenLieu;
    }
}

