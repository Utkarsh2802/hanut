/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hanut;
import java.sql.*;
/**
 *
 * @author MAHE
 */
public class Project_hANUT {

    /**
     * @param args the command line arguments
     */
    public static Connection getConnection()
    {
        Statement mystmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanut","root","khator");
            if(conn!=null)
                System.out.print("connected");
           
        }
        catch(Exception e)
        {
            System.out.print("not connected");
        }
        return conn;
}
    public static void main(String[] args) {
        // TODO code application logic here
        new LoginPage().setVisible(true);
    }
    
}
