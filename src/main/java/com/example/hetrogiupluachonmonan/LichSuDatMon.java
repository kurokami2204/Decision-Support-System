package com.example.hetrogiupluachonmonan;

public class LichSuDatMon {
    public String maDonHang;
    public String maMonAn;
    public String ngayDatHang;
    public String danhGia;
    public String trangthai;

    public LichSuDatMon(String maDonHang, String maMonAn, String ngayDatHang, String danhGia, String trangthai) {
        this.maDonHang = maDonHang;
        this.maMonAn = maMonAn;
        this.ngayDatHang = ngayDatHang;
        this.danhGia = danhGia;
        this.trangthai = trangthai;
    }

    public LichSuDatMon(String maMonAn, String danhGia) {
        this.maMonAn = maMonAn;
        this.danhGia = danhGia;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "LichSuDatMon{" +
                "maDonHang='" + maDonHang + '\'' +
                ", maMonAn='" + maMonAn + '\'' +
                ", ngayDatHang='" + ngayDatHang + '\'' +
                ", danhGia='" + danhGia + '\'' +
                ", trangthai='" + trangthai + '\'' +
                '}';
    }
}
