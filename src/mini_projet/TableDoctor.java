package mini_projet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDoctor {
    
    int id_med;
    String nom_med;
    String prenom_med;
    String sexe;
    String date_nes_med;
    String adress_med;
    String num_tel_med;
    String pseudo_med;
    String mdp_medc;
    String email_medc;
  
    // ##### connection BDD
    Connection conn = null;

        // ##### 

    public TableDoctor(int id_med, String nom_med, String prenom_med, String sexe, String date_nes_med, String adress_med, String num_tel_med, String pseudo_med, String mdp_medc, String email_medc) {
        this.id_med = id_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.sexe = sexe;
        this.date_nes_med = date_nes_med;
        this.adress_med = adress_med;
        this.num_tel_med = num_tel_med;
        this.pseudo_med = pseudo_med;
        this.mdp_medc = mdp_medc;
        this.email_medc = email_medc;
    
    try {
            conn = DBConnector.getConnection();
            if(conn != null)
                System.out.println("connection BDD Admin controller done !");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
    public TableDoctor(int id_med, String nom_med, String prenom_med, String date_nes_med, String adress_med, String num_tel_med) {
        this.id_med = id_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.date_nes_med = date_nes_med;
        this.adress_med = adress_med;
        this.num_tel_med = num_tel_med;
    }

    public int getId_med() {
        return id_med;
    }

    public String getNom_med() {
        return nom_med;
    }

    public String getPrenom_med() {
        return prenom_med;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDate_nes_med() {
        return date_nes_med;
    }

    public String getAdress_med() {
        return adress_med;
    }

    public String getNum_tel_med() {
        return num_tel_med;
    }

    public String getPseudo_med() {
        return pseudo_med;
    }

    public String getMdp_medc() {
        return mdp_medc;
    }

    public String getEmail_medc() {
        return email_medc;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    public void setNom_med(String nom_med) {
        this.nom_med = nom_med;
    }

    public void setPrenom_med(String prenom_med) {
        this.prenom_med = prenom_med;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDate_nes_med(String date_nes_med) {
        this.date_nes_med = date_nes_med;
    }

    public void setAdress_med(String adress_med) {
        this.adress_med = adress_med;
    }

    public void setNum_tel_med(String num_tel_med) {
        this.num_tel_med = num_tel_med;
    }

    public void setPseudo_med(String pseudo_med) {
        this.pseudo_med = pseudo_med;
    }

    public void setMdp_medc(String mdp_medc) {
        this.mdp_medc = mdp_medc;
    }

    public void setEmail_medc(String email_medc) {
        this.email_medc = email_medc;
    }
    
    public static int insertDoctor (String nom_med, String prenom_med, String sexe, String date_nes_med, String adress_med, String num_tel_med, String pseudo_med, String mdp_medc, String email_medc) throws SQLException, ClassNotFoundException {

        ResultSet rs = null;
        int doctorId = 0;
        
        String sql = "INSERT INTO medcin(`nom_med`, `prenom_med`, `sexe`, `date_nes_med`, `adress_med`, `num_tel_med`, `pseudo_med`, `mdp_medc`, `email_medc`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
 
                    pstmt.setString(1, nom_med);
                    pstmt.setString(2, prenom_med);
                    pstmt.setString(3, sexe); 
                    pstmt.setString(4, date_nes_med);
                    pstmt.setString(5, adress_med);
                    pstmt.setString(6, num_tel_med); 
                    pstmt.setString(7, pseudo_med);
                    pstmt.setString(8, mdp_medc); 
                    pstmt.setString(9, email_medc);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    doctorId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return doctorId;
    }
    
    /*
    * Delete Doctor where ID in parameter
    *
    */
    public static void deleteDoctor (int id) throws SQLException, ClassNotFoundException {

        ResultSet rs = null;
        String sql = "DELETE FROM medcin WHERE id_med = " + id;        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {            
            pstmt.execute();
            System.out.println("Record ID :"+id+" deleted successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    /*
    * Update Doctor
    */
    public static void updateDoctor(int id,String nom_med, String prenom_med, String sexe, String date_nes_med, String adress_med, String num_tel_med, String pseudo_med, String mdp_medc, String email_medc) throws SQLException, ClassNotFoundException{
               
        String sql = "UPDATE medcin SET `nom_med` = ?, `prenom_med` = ?, `sexe` = ?, `date_nes_med` = ?, `adress_med` = ?, `num_tel_med` = ?, `pseudo_med` = ?, `mdp_medc` = ?, `email_medc` = ?"+" WHERE `id_med` = ?";
                
        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, nom_med);
            pstmt.setString(2, prenom_med);
            pstmt.setString(3, sexe); 
            pstmt.setString(4, date_nes_med);
            pstmt.setString(5, adress_med);
            pstmt.setString(6, num_tel_med); 
            pstmt.setString(7, pseudo_med);
            pstmt.setString(8, mdp_medc); 
            pstmt.setString(9, email_medc);
            pstmt.setInt(10, id);
            
            int i = pstmt.executeUpdate();
            System.out.println("Record ID :"+id+" Name :"+i+" update successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }       
    
    }
    
    /*
    * Test si pseudonym et le mot de passe existe dans la BDD
    * si oui resulta vrais sinon fausse
    */
    public static boolean receptionisteExiste(String pseudonym, String password) throws SQLException, ClassNotFoundException{        
        boolean status = false;
        try(Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM medcin WHERE pseudo_med = ? AND mdp_medc = ?");) {
            pstmt.setString(1, pseudonym);
            pstmt.setString(2, password);
            System.out.println("PreparedStatement :: "+pstmt);
            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
            System.out.println("resulta :: "+rs.getString(2));            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
         return status;
    }

}
