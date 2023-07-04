package com.example.hetrogiupluachonmonan;

public class MonAn {
    public String maMonAn;
    public String tenMonAn;
    public float giaThanh;
    public String thoiGianChuanBi;
    public String tenDanhMuc;
    public String tenNguyenLieu;
    public String giaTriDinhDuong;
    public float danhGia;

    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public float getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(float giaThanh) {
        this.giaThanh = giaThanh;
    }

    public String getThoiGianChuanBi() {
        return thoiGianChuanBi;
    }

    public void setThoiGianChuanBi(String thoiGianChuanBi) {
        this.thoiGianChuanBi = thoiGianChuanBi;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public String getGiaTriDinhDuong() {
        return giaTriDinhDuong;
    }

    public void setGiaTriDinhDuong(String giaTriDinhDuong) {
        this.giaTriDinhDuong = giaTriDinhDuong;
    }

    public Float getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(Float danhGia) {
        this.danhGia = danhGia;
    }

    public MonAn(String tenMonAn, float giaThanh, String thoiGianChuanBi, String tenDanhMuc) {
        this.tenMonAn = tenMonAn;
        this.giaThanh = giaThanh;
        this.thoiGianChuanBi = thoiGianChuanBi;
        this.tenDanhMuc = tenDanhMuc;
    }

    public MonAn(String tenMonAn, float giaThanh, String thoiGianChuanBi, String tenDanhMuc, String tenNguyenLieu, String giaTriDinhDuong) {
        this.tenMonAn = tenMonAn;
        this.giaThanh = giaThanh;
        this.thoiGianChuanBi = thoiGianChuanBi;
        this.tenDanhMuc = tenDanhMuc;
        this.tenNguyenLieu = tenNguyenLieu;
        this.giaTriDinhDuong = giaTriDinhDuong;
    }

    public MonAn(String tenMonAn, float giaThanh, String thoiGianChuanBi, String tenDanhMuc, String tenNguyenLieu, String giaTriDinhDuong, Float danhGia) {
        this.tenMonAn = tenMonAn;
        this.giaThanh = giaThanh;
        this.thoiGianChuanBi = thoiGianChuanBi;
        this.tenDanhMuc = tenDanhMuc;
        this.tenNguyenLieu = tenNguyenLieu;
        this.giaTriDinhDuong = giaTriDinhDuong;
        this.danhGia = danhGia;
    }

    @Override
    public String toString() {
        return "MonAn{" +
                "maMonAn='" + maMonAn + '\'' +
                ", tenMonAn='" + tenMonAn + '\'' +
                ", giaThanh=" + giaThanh +
                ", thoiGianChuanBi='" + thoiGianChuanBi + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", tenNguyenLieu='" + tenNguyenLieu + '\'' +
                ", giaTriDinhDuong='" + giaTriDinhDuong + '\'' +
                '}';
    }
}
