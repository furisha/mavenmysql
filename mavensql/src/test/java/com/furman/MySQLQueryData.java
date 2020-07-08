package com.furman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLQueryData {

    public static void main(String[] args) throws Exception {

        Connection con = null;
        String dburl = "jdbc:mysql://localhost:3306/automationtesting?useSSL=true";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(dburl, userName, password);

        System.out.println("Connection Successfully");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from credentials");

        while (rs.next()){
            System.out.println(
                    rs.getString("UserName")+
                            "--"+rs.getString("Password")+
                            "--"+rs.getString("DateCreated")+
                            "--"+rs.getString("NoOfAttempts")+
                            "--"+rs.getString("Result"));
        }
        rs.close();

    }

}
