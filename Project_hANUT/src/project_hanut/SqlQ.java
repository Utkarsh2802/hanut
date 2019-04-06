package project_hanut;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
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
//    public static double sol(String query){
//        double bal=0;
//        try{
//            Class.forName("java.sql.DriverManager");
//            Connection con = (Connection)
//            DriverManager.getConnection
//            ("jdbc:mysql://localhost:3306/hanut",
//            "root", "khator");
//            Statement stmt = (Statement) con.createStatement();
//            ResultSet rs=stmt.executeQuery(query);
//            if(rs.next()){
//                bal=rs.getDouble("balance");
//            }
//            
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//    return bal;
//}
    public static void updateq(String query){
        try{
            Class.forName("java.sql.DriverManager");
            Connection con = (Connection)
            DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/hanut",
            "root", "khator");
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(query);
                        
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
