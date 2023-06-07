package com.example.hetrogiupluachonmonan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class MonAnDAO {
    public static ArrayList<MonAn> getMonAn() throws SQLException, ParseException {
        Connection connection = SQLConnect.getConnection();
        String select = "select TenDanhMuc, TenMonAn, GiaThanh, ThoiGianChuanBi, TenNguyenLieu, GiaTriDinhDuong from monan" +
                " join danhmuc on danhmuc.MaDanhMuc = monan.MaDanhMuc" +
                " join thanhphan ON thanhphan.MaMonAn = monan.MaMonAn" +
                " join nguyenlieu ON nguyenlieu.MaNguyenLieu = thanhphan.MaNguyenLieu" +
                " where TenMonAn like 'Cơm sốt trứng'";
        PreparedStatement pe = connection.prepareStatement(select);

        ArrayList<MonAn> list = new ArrayList<>();

        ResultSet re = pe.executeQuery();
        while (re.next()){
            String tenDanhMuc = re.getString("TenDanhMuc");
            String tenMonAn = re.getString("TenMonAn");
            float giaThanh = re.getFloat("GiaThanh");
            String thoiGianChuanBi = re.getString("ThoiGianChuanBi");
            String tenNguyenLieu = re.getString("TenNguyenLieu");
            String giaTriDinhDuong = re.getString("GiaTriDinhDuong");
            MonAn monAn = new MonAn(tenMonAn, giaThanh, thoiGianChuanBi, tenDanhMuc, tenNguyenLieu, giaTriDinhDuong);

            list.add(monAn);
        }
        connection.close();
        return list;
    }

}
