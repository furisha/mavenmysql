package com.furman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataToMySQL {

    public static void main(String[] args) throws Exception {

        Connection con = null;
        String dburl = "jdbc:mysql://localhost:3306/automationtesting?useSSL=true";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(dburl, userName, password);

        System.out.println("Connection Successfully");

        PreparedStatement ps = con.prepareStatement("INSERT into credentials(" +
                "UserName, " +
                "Password, " +
                "DateCreated, " +
                "NoOfAttempts," +
                " Result)" +
                "VALUES('OtherUser', 'p@ssword123', '2020-6-7', '12', 'FAIL' )");
        ps.executeUpdate();
        con.close();
    }

}
