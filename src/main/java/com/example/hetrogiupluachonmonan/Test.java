package com.example.hetrogiupluachonmonan;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ParseException {
        List<MonAn> monAns = new ArrayList<>();
        monAns = MonAnDAO.getMonAn();

        System.out.print(monAns);
//        SQLConnect.getConnection();
    }
}
