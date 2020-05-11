package mini_projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/clinique_dentaire";
            String user      = "root";
            String password  = "";
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // ####
            //if(conn != null)
            //    System.out.println(String.format("successfully, "+ "Connected to database %s ", conn.getCatalog()));
            return conn;            	
            } catch(SQLException e) {
               System.out.println("dommage erreur ::"+e.getMessage());
               return null;
            }           
    }
}
