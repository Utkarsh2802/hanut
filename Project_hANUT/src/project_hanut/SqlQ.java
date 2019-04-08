package project_hanut;
<<<<<<< HEAD


import java.sql.*;
=======
import java.sql.*;/*
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;*/
>>>>>>> 3f2f343b6da0a2f74e9ee8d8336f3caea378315c
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SqlQ {
    public static ResultSet retrive(String query){
        ResultSet rs=null;
        try {
            Class.forName("java.sql.DriverManager");
<<<<<<< HEAD
            Connection con = (Connection)
            DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/hanut","root", "student123");
            
=======
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hanut","root","dastan");
>>>>>>> 3f2f343b6da0a2f74e9ee8d8336f3caea378315c
            Statement stmt = (Statement) con.createStatement();
            rs=stmt.executeQuery(query);            
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public static void updateq(String query) {
        try {
            Class.forName("java.sql.DriverManager");
<<<<<<< HEAD
            Connection con = (Connection)
            DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/hanut","root", "student123");
            
=======
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hanut","root","dastan");
>>>>>>> 3f2f343b6da0a2f74e9ee8d8336f3caea378315c
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(query);                       
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}