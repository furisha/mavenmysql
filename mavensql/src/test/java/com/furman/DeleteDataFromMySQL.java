package com.furman;

import java.sql.*;

public class DeleteDataFromMySQL {

    public static void main(String[] args) throws Exception {

        String dburl = "jdbc:mysql://localhost:3306/automationtesting?useSSL=true";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        Connection myConn = null;
        Statement myStmt = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(dburl, userName, password);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            String sql = "delete from credentials where UserName='OtherUser'";

            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Delete complete.");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}

