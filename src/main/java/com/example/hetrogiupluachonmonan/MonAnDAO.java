package com.example.hetrogiupluachonmonan;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import java.text.ParseException;
import java.util.*;

public class MonAnDAO {
    public static List<MonAn> getMonAn() {
        Connection connection = SQLConnect.getConnection();
        String select = """
                SELECT danhmuc.TenDanhMuc, monan.TenMonAn , GROUP_CONCAT(DISTINCT(nguyenlieu.TenNguyenLieu)) as TenNguyenLieu,\s
                     SUM(nguyenlieu.GiaTriDinhDuong)/count(DISTINCT lichsudatmon.MaDonHang) as GiaTriDinhDuong,
                     monan.ThoiGianChuanBi, monan.GiaThanh,\s
                     ROUND(AVG(lichsudatmon.DanhGia),1) AS DanhGia
                     from thanhphan
                     JOIN nguyenlieu on thanhphan.MaNguyenLieu=nguyenlieu.MaNguyenLieu\s
                     JOIN monan on monan.MaMonAn = thanhphan.MaMonAn
                     JOIN danhmuc on monan.MaDanhMuc= danhmuc.MaDanhMuc
                     JOIN lichsudatmon on monan.MaMonAn= lichsudatmon.MaMonAn
                     GROUP BY thanhphan.MaMonAn;
                """;
        PreparedStatement pe = null;
        try {
            pe = connection.prepareStatement(select);
            ArrayList<MonAn> list = new ArrayList<>();

            ResultSet re = pe.executeQuery();
            while (re.next()){
                String tenDanhMuc = re.getString("TenDanhMuc");
                String tenMonAn = re.getString("TenMonAn");
                float giaThanh = re.getFloat("GiaThanh");
                String thoiGianChuanBi = re.getString("ThoiGianChuanBi");
                String tenNguyenLieu = re.getString("TenNguyenLieu");
                String giaTriDinhDuong = re.getString("GiaTriDinhDuong");
                Float danhGia = re.getFloat("DanhGia");
                MonAn monAn = new MonAn(tenMonAn, giaThanh, thoiGianChuanBi, tenDanhMuc, tenNguyenLieu, giaTriDinhDuong, danhGia);

                list.add(monAn);
            }
            connection.close();

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
