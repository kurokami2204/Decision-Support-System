package com.example.hetrogiupluachonmonan;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class ViewController {

    @FXML
    private Button btn_reset;
    @FXML
    private TableView<MonAn> tbl_monan;
    @FXML
    private TableColumn<MonAn, String> danh_muc_column;
    @FXML
    private TableColumn<MonAn, String> ten_mon_an_column;
    @FXML
    private TableColumn<MonAn, String> nguyen_lieu_column;
    @FXML
    private TableColumn<MonAn, Double> dinh_duong_column;
    @FXML
    private TableColumn<MonAn, String> time_cbi_column;
    @FXML
    private TableColumn<MonAn, Float> gia_thanh_column;
    @FXML
    private TableColumn<MonAn, Double> danh_gia_column;
    @FXML
    private TextField danhMucSearch;
    @FXML
    private TextField giaThanhStart;
    @FXML
    private TextField giaThanhEnd;
    @FXML
    private TextField nguyenLieuSearch;
    @FXML
    private ComboBox ThoiGianChuanBi;
    @FXML
    private ComboBox DanhGia;
    private List<MonAn> allMonAns;

    public void initialize() {
        this.allMonAns = MonAnDAO.getMonAn();
        danh_muc_column.setCellValueFactory(new PropertyValueFactory<>("tenDanhMuc"));
        ten_mon_an_column.setCellValueFactory(new PropertyValueFactory<>("tenMonAn"));
        nguyen_lieu_column.setCellValueFactory(new PropertyValueFactory<>("tenNguyenLieu"));
        dinh_duong_column.setCellValueFactory(new PropertyValueFactory<>("giaTriDinhDuong"));
        time_cbi_column.setCellValueFactory(new PropertyValueFactory<>("thoiGianChuanBi"));
        gia_thanh_column.setCellValueFactory(new PropertyValueFactory<>("giaThanh"));
        danh_gia_column.setCellValueFactory(new PropertyValueFactory<>("danhGia"));
        tbl_monan.getItems().setAll(allMonAns);

        DanhGia.setValue("Tất cả");
        ThoiGianChuanBi.setValue("Tất cả");
    }

    public void handleFilter() {
        List<MonAn> monAns = new ArrayList<>(allMonAns);

        // SEARCH: DANH MUC CAN TIM
        //----------------------------------------------
        String danhMucCanTim = danhMucSearch.getText();
        if (!danhMucCanTim.isBlank()) {
            monAns.removeIf(ma -> !ma.tenDanhMuc.contains(danhMucCanTim));
        }
        //        System.out.println(danhMucCanTim);
        //----------------------------------------------

        // SEARCH: NGUYEN LIEU CAN TIM
        //----------------------------------------------
        String nguyenLieuCanTim = nguyenLieuSearch.getText();
        if (!nguyenLieuCanTim.isBlank()) {
            monAns.removeIf(ma -> !ma.tenNguyenLieu.contains(nguyenLieuCanTim));
        }
        //----------------------------------------------
        
        // SEARCH: GIA MON AN
        //----------------------------------------------
        String giaMin = giaThanhStart.getText();
        String giaMax = giaThanhEnd.getText();

        if (!giaMin.isBlank())
        {
            monAns.removeIf(ma -> (ma.giaThanh <  Float.valueOf(giaMin)));
        }

        if (!giaMax.isBlank())
        {
            monAns.removeIf(ma -> (ma.giaThanh >  Float.valueOf(giaMax)));
        }
        //----------------------------------------------

        // SEARCH: THOI GIAN CHUAN BI
        //----------------------------------------------

        //CACH 1
        String ValueTgian = (String) ThoiGianChuanBi.getValue();
        if(!ValueTgian.isBlank())
        {
            ValueTgian = (String) ThoiGianChuanBi.getValue();
            if (ValueTgian.equals("5-10 phút") )
            {

                monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) <  5));
                monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) > 10));
            }

            if(ValueTgian.equals("10-15 phút"))
            {
                monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) <  10));
                monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) > 15));
            }

            if(ValueTgian.equals("trên 15 phút"))
            {
                monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) < 15));
            }
            if(ValueTgian.equals("Tất cả"))
            {
                monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) < 0));
            }
        }
        else {
            monAns.removeIf(ma -> (Integer.valueOf(ma.thoiGianChuanBi.substring(0, ma.thoiGianChuanBi.length() - 5)) < 0));
        }
        //----------------------------------------------


        // SEARCH: DANH GIA SAO
        //----------------------------------------------
        String ValueDanhGia = (String) DanhGia.getValue();

        if (!ValueDanhGia.isBlank())
        {
            ValueDanhGia = (String) DanhGia.getValue();
            if (ValueDanhGia.equals("0-1 sao"))
            {
                monAns.removeIf(ma -> (ma.danhGia > 1));
            }
            if (ValueDanhGia.equals("1-2 sao"))
            {
                monAns.removeIf(ma -> (ma.danhGia < 1 || ma.danhGia > 2));
            }
            if (ValueDanhGia.equals("2-3 sao"))
            {
                monAns.removeIf(ma -> (ma.danhGia < 2 || ma.danhGia > 3));
            }
            if (ValueDanhGia.equals("3-4 sao"))
            {
                monAns.removeIf(ma -> (ma.danhGia < 3 || ma.danhGia > 4));
            }
            if (ValueDanhGia.equals("4-5 sao"))
            {
                monAns.removeIf(ma -> (ma.danhGia < 4));
            }
            if (ValueDanhGia.equals("Tất cả"))
            {
                monAns.removeIf(ma -> (ma.danhGia > 6));
            }
        }
        else {
            monAns.removeIf(ma -> (ma.danhGia > 6));
        }
        //----------------------------------------------


        //----------------------------------------------
        monAns.sort(Comparator.comparing(o -> /* ham tinh diem cho 1 mon an*/ o.tenDanhMuc.length()));
        tbl_monan.getItems().setAll(monAns);
        //----------------------------------------------

    }
}
