package com.example.hetrogiupluachonmonan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

public class ViewController {
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
    private TextField danhGiaSearch;
    @FXML
    private TextField dinhDuongSearch;
    @FXML
    private TextField giaThanhStart;
    @FXML
    private TextField giaThanhEnd;
    @FXML
    private TextField nguyenLieuSearch;

    @FXML
    private TableColumn<?, ?> col_diemPhuHop;

    @FXML
    private TableColumn<?, ?> col_phuhopdanhgia;

    @FXML
    private TableColumn<?, ?> col_phuhopdinhduong;

    @FXML
    private TableColumn<?, ?> col_phuhopgiathanh;

    @FXML
    private TableColumn<DiemMonAn, Double> col_phuhopnguyenlieu;

    @FXML
    private TableColumn<?, ?> col_tenmonan;
    private List<MonAn> allMonAns;
    @FXML
    private TableView<DiemMonAn> tbl_GoiY;

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
    }

    public static ObservableList<MonAn> list = FXCollections.observableArrayList();
    @FXML
    void resetToanBo(ActionEvent event) {
        tbl_GoiY.getItems().clear();
        dinhDuongSearch.clear();
        giaThanhStart.clear();
        giaThanhEnd.clear();
        nguyenLieuSearch.clear();
        danhGiaSearch.clear();


    }
    @FXML
    void goiYChonMon(ActionEvent event) {
            ObservableList<DiemMonAn> listDiemMonAn = FXCollections.observableArrayList();
            ObservableList<DiemMonAn> listChuanHoa = FXCollections.observableArrayList();
                float  inputDinhDuong = Float.parseFloat(dinhDuongSearch.getText());
//                System.out.println(inputDinhDuong)
                int inputGiaThanhThapNhat = Integer.parseInt(giaThanhStart.getText());

                int inputGiaThanhCaoNhat = Integer.parseInt((giaThanhEnd.getText()));

                String inputNguyenLieu = nguyenLieuSearch.getText();
//                System.out.println(inputNguyenLieu);

                float inputDanhGia = Float.parseFloat(danhGiaSearch.getText());
//                float doPhuHopTest = tinhDoPhuHopVeNguyenLieu("Cá ngừ","Cá ngừ,Phô Mai");
//                System.out.println(doPhuHopTest);
                for (MonAn monAn : this.allMonAns) {
                float diemPhuHopDinhDuong = tinhdophuhopdinhduong(inputDinhDuong, Float.parseFloat(monAn.getGiaTriDinhDuong().replace("kcal","").trim()));

                float diemPhuHopGiaThanh = tinhDoPhuHopVeGiaThanh(inputGiaThanhThapNhat, inputGiaThanhCaoNhat, monAn.getGiaThanh());

                double diemPhuHopNguyenLieu = tinhDoPhuHopVeNguyenLieu(inputNguyenLieu, monAn.getTenNguyenLieu());

                float diemPhuHopDanhGia = tinhdophuhopdanhgia(inputDanhGia, monAn.getDanhGia());

                DiemMonAn diemMonAn = new DiemMonAn(monAn.getTenMonAn(),diemPhuHopDinhDuong,diemPhuHopNguyenLieu,diemPhuHopGiaThanh,diemPhuHopDanhGia);
                listDiemMonAn.add(diemMonAn);
//                System.out.println(monAn.getTenNguyenLieu());
                listChuanHoa = topSis(listDiemMonAn);
//                System.out.println(listChuanHoa);
                //Test thử
//                for (DiemMonAn dma : listChuanHoa){
//                    System.out.println("Tên món ăn"+ dma.getTenMonAn());
//                    System.out.println("Điểm phù hợp dinh dưỡng: " + dma.getGiaTriDinhDuong());
//                    System.out.println("Điểm phù hợp Nguyên liệu: " + dma.getNguyenlieu());
//                    System.out.println("Điểm phù hợp Giá Thành: " + dma.getGiaThanh());
//                    System.out.println("Điểm phù hợp đánh giá: " + dma.getDanhGia());
//                    System.out.println("Điểm phù hợp: " + dma.getDiemPhuHop());
//                    System.out.println("--------------------------------------");
//
//                }
                col_tenmonan.setCellValueFactory(new PropertyValueFactory<>("tenMonAn"));
                col_phuhopdinhduong.setCellValueFactory(new PropertyValueFactory<>("giaTriDinhDuong"));
                col_phuhopnguyenlieu.setCellValueFactory(new PropertyValueFactory<>("NguyenLieu1"));
                col_phuhopgiathanh.setCellValueFactory(new PropertyValueFactory<>("giaThanh"));
                col_phuhopdanhgia.setCellValueFactory(new PropertyValueFactory<>("danhGia"));
                col_diemPhuHop.setCellValueFactory(new PropertyValueFactory<>("diemPhuHop"));
                tbl_GoiY.setItems(listChuanHoa);

            }
        }

    public float tinhdophuhopdanhgia(float danhGiaYeuCau, float danhGiaTrongLichsu) {
        float dophuhopdanhgia = 0;
        float chenhlechdanhgia = danhGiaYeuCau - danhGiaTrongLichsu;
        if (chenhlechdanhgia == 0) {
            dophuhopdanhgia = 10;
        }
        //danh gia trong lich su cao hon so voi yeu cau
        else if (chenhlechdanhgia < 0) {
            dophuhopdanhgia = chenhlechdanhgia + 4;
        } else dophuhopdanhgia = chenhlechdanhgia + 2;
        return dophuhopdanhgia;
    }

    public float tinhdophuhopdinhduong(float luongcaloyeucau, float luongcalocuamon) {
        float dophuhopdinhduong = 0;
        float chenhlechdinhduong = ((luongcaloyeucau - luongcalocuamon) / 100.0f);
        if (chenhlechdinhduong == 0) {
            dophuhopdinhduong = 10;
        } else if (chenhlechdinhduong > 0) {
            dophuhopdinhduong = Math.abs(chenhlechdinhduong) + 4;
        } else dophuhopdinhduong = Math.abs(chenhlechdinhduong) + 2;
        return dophuhopdinhduong;
    }

    public float tinhDoPhuHopVeGiaThanh(float giaThanhStart, float giaThanhEnd,float giaThanhGoc){
        float dophuhopgiathanh = 0;
        if(giaThanhEnd > giaThanhGoc && giaThanhGoc> giaThanhStart) {
            float chenhlechgiathanhStart = (giaThanhGoc - giaThanhStart)/100.0f;
            float chenhlechgiathanhEnd = (giaThanhEnd - giaThanhGoc)/100.0f;
            if (chenhlechgiathanhStart == chenhlechgiathanhEnd) {
                dophuhopgiathanh = 10;
            } else if (chenhlechgiathanhStart < chenhlechgiathanhEnd) {
                dophuhopgiathanh = chenhlechgiathanhStart + 2;
            } else dophuhopgiathanh = chenhlechgiathanhStart + 4;
            return dophuhopgiathanh;
        }return dophuhopgiathanh + 1;
    }

    public double tinhDoPhuHopVeNguyenLieu(String nguyenLieuYeuCau, String nguyenLieuTrongMon){
        double dophuhopnguyenlieu = 0;
        String [] listNguyenLieuKhachHang= nguyenLieuYeuCau.split(",");
        String [] listNguyenLieuCoTrongMon= nguyenLieuTrongMon.split(",");
        for(String nguyenLieuKhachHang : listNguyenLieuKhachHang){
            for(String nguyenLieuCoTrongMon : listNguyenLieuCoTrongMon){
                if(nguyenLieuKhachHang.toLowerCase().trim().equalsIgnoreCase(nguyenLieuCoTrongMon.toLowerCase().trim())){
                    dophuhopnguyenlieu = dophuhopnguyenlieu+2;
                    break;
                }
            }
        }
        return dophuhopnguyenlieu;
    }
    public ObservableList<DiemMonAn> topSis(ObservableList<DiemMonAn> listDiemMonAn){
        ObservableList<DiemMonAn> listDiemChuanHoa = FXCollections.observableArrayList();
        double sumDinhDuong=0;
        double sumNguyenLieu=0;
        double sumGiaThanh=0;
        double sumDanhGia=0;
        for (DiemMonAn diemMonAn : listDiemMonAn) {
            sumDinhDuong+= Math.pow(diemMonAn.getGiaTriDinhDuong(), 2);
            sumNguyenLieu+= Math.pow(diemMonAn.getNguyenLieu1(), 2);
            sumGiaThanh+= Math.pow(diemMonAn.getGiaThanh(), 2);
            sumDanhGia+= Math.pow(diemMonAn.getDanhGia(), 2);

        }
        // tinh chuan hoa va nhan trong so (phần mẫu để chia)
        sumDinhDuong= Math.sqrt(sumDinhDuong);
        sumNguyenLieu= Math.sqrt(sumNguyenLieu);
        sumGiaThanh= Math.sqrt(sumGiaThanh);
        sumDanhGia= Math.sqrt(sumDanhGia);


        // tinh A*
        double maxDiemDinhDuong=0;
        double maxDiemNguyenLieu=0;
        double maxDiemGiaThanh=0;
        double maxDiemDanhGia=0;

        //
        for (DiemMonAn diemMonAn : listDiemMonAn) {
            double diemDinhDuong = Math.round((diemMonAn.getGiaTriDinhDuong()/sumDinhDuong)*0.1* 10000) / 10000.0;
            double diemNguyenLieu = Math.round((diemMonAn.getNguyenLieu1()/sumNguyenLieu)*0.4* 10000) / 10000.0;
            double diemGiaThanh = Math.round((diemMonAn.getGiaThanh()/sumGiaThanh)*0.25* 10000) / 10000.0;
            double diemDanhGia = Math.round((diemMonAn.getDanhGia()/sumDanhGia)*0.25* 10000) / 10000.0;

            if(diemDinhDuong>maxDiemDinhDuong){
                maxDiemDinhDuong=diemDinhDuong;
            }
            if(diemNguyenLieu>maxDiemNguyenLieu){
                maxDiemNguyenLieu=diemNguyenLieu;
            }
            if(diemGiaThanh>maxDiemGiaThanh){
                maxDiemGiaThanh=diemGiaThanh;
            }
            if(diemDanhGia>maxDiemDanhGia){
                maxDiemDanhGia=diemDanhGia;
            }

            DiemMonAn diemMon = new DiemMonAn(diemMonAn.getTenMonAn(),diemDinhDuong,diemNguyenLieu,
                    diemGiaThanh,diemDanhGia);
            listDiemChuanHoa.add(diemMon);

        }
        for (DiemMonAn diemMonAn : listDiemChuanHoa){
            double sumPhuHop = 0;
            sumPhuHop +=Math.pow((diemMonAn.getGiaTriDinhDuong()-maxDiemDinhDuong),2);
            sumPhuHop +=Math.pow((diemMonAn.getNguyenLieu1()-maxDiemNguyenLieu),2);
            sumPhuHop +=Math.pow((diemMonAn.getGiaThanh()-maxDiemGiaThanh),2);
            sumPhuHop +=Math.pow((diemMonAn.getDanhGia()-maxDiemDanhGia),2);
            sumPhuHop = Math.round(Math.sqrt(sumPhuHop)*1000) / 1000.0;
//            System.out.println(sumPhuHop);

            diemMonAn.setDiemPhuHop(sumPhuHop);

        }

        return listDiemChuanHoa;
    }

}
