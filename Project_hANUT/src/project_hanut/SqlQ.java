package project_hanut;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raghav
 */
public class SqlQ {
    public static ResultSet retrive(String query){
        ResultSet rs=null;
        try{
            Class.forName("java.sql.DriverManager");
            Connection con = (Connection)
            DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/hanut","root", "student123");
            
            Statement stmt = (Statement) con.createStatement();
            rs=stmt.executeQuery(query);
               
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
}
    public static void updateq(String query){
        try{
            Class.forName("java.sql.DriverManager");
            Connection con = (Connection)
            DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/hanut","root", "student123");
            
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(query);
                        
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
