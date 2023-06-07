package com.example.hetrogiupluachonmonan;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws SQLException, ParseException {
        ArrayList<MonAn> MonAn = new ArrayList<>();
        MonAn = MonAnDAO.getMonAn();
        System.out.print(MonAn);
//        SQLConnect.getConnection();
    }
}
