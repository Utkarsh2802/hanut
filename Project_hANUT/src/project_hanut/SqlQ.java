package project_hanut;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SqlQ {

    public static ResultSet retrive(String query) {
        ResultSet rs = null;
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hanut", "root", "khator");
            Statement stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public static void updateq(String query) {
        try {
            Class.forName("java.sql.DriverManager");

            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hanut", "root", "khator");

            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
