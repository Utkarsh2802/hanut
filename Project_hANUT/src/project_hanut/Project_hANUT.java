package project_hanut;
import java.sql.*;
public class Project_hANUT {
   public static Connection getConnection() {
        Statement mystmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanut","root","student123");
            if(conn!=null)
                System.out.print("connected");
        }
        catch(Exception e) {
            System.out.print("not connected");
        }
        return conn;
}
    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
    
}
