package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDoctor {
    
    String id_med;
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

    public TableDoctor(String id_med, String nom_med, String prenom_med, String sexe, String date_nes_med, String adress_med, String num_tel_med, String pseudo_med, String mdp_medc, String email_medc) {
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
    public TableDoctor(String id_med, String nom_med, String prenom_med, String date_nes_med, String adress_med, String num_tel_med) {
        this.id_med = id_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.date_nes_med = date_nes_med;
        this.adress_med = adress_med;
        this.num_tel_med = num_tel_med;
    }

    public String getId_med() {
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

    public void setId_med(String id_med) {
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
    
    void insertingDoctor() throws SQLException{

       //Inserting values to a table
        String query = "INSERT INTO medcin(`id_med`, `nom_med`, `prenom_med`, `sexe`, `date_nes_med`, `adress_med`, `num_tel_med`, `pseudo_med`, `mdp_medc`, `email_medc`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);//
                       
        pstmt.setString(1, id_med); 
        pstmt.setString(2, nom_med);
        pstmt.setString(3, prenom_med);
        pstmt.setString(4, sexe); 
        pstmt.setString(5, date_nes_med);
        pstmt.setString(6, adress_med);
        pstmt.setString(7, num_tel_med); 
        pstmt.setString(8, pseudo_med);
        pstmt.setString(9, mdp_medc); 
        pstmt.setString(10, email_medc);
        pstmt.execute();// recuperer les  saisis par user, w tzifet l bdd
        
        System.out.println("Successfully inserted :: "+nom_med);

    } 
}
