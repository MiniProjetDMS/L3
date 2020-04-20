
                
         /* try{
              //conn=null;
              conn=Connexion.getConnection(); 
              //st=conn.createStatement();
              rst=conn.createStatement().executeQuery("SELECT * FROM Receptionist");
              
              while(rst.next()){
                 System.out.print(rst.getInt("id_recep")+"\t");
                  System.out.print(rst.getString("nom_recep")+"\t");
                 
                  System.out.println();
              }
          }catch(Exception ex){
             ex.printStackTrace();
          } */
     
  package mini_projet; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;

public class Connexion {
 static Connection conn;
 static Statement st;
 static ResultSet rst;
 public static void main(String[] args) {
       
        
                
          try{
              conn=ConnecterDB(); 
              st=conn.createStatement();
              rst=st.executeQuery("SELECT * FROM receptionicte");
              
              while(rst.next()){
                  System.out.print(rst.getInt("id_recep")+"\t");
                  System.out.print(rst.getString("nom_recep")+"\t");
                 
                  System.out.println();
              }
          }catch(Exception ex){
              ex.printStackTrace();
              System.out.println("erreur :: " + ex.getMessage());
          } 
     
    }
 //static Connection conn=null;
public static Connection ConnecterDB()
{
 try{
    Class.forName("com.mysql.jdbc.Driver") ;
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/clinique_dentaire", "root","");
return conn;
}
catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Erreur :: "+e.getMessage());
            return null;
        }
}

}

