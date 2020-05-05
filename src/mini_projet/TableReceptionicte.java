package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TableReceptionicte {
    String id_recep;
    String nom_recep, prenom_recep, sexe;
    String date_nes_recep;
    String adress_recep, num_tel_recep, pseudo_recep;
    String mdp_recep, email_recep;

        // ##### connection BDD
    Connection conn = null;

        // ##### 
    
    public TableReceptionicte(String id_recep, String nom_recep, String prenom_recep, String sexe, String date_nes_recep, String adress_recep, String num_tel_recep, String pseudo_recep, String mdp_recep, String email_recep) {
        this.id_recep = id_recep;
        this.nom_recep = nom_recep;
        this.prenom_recep = prenom_recep;
        this.sexe = sexe;
        this.date_nes_recep = date_nes_recep;
        this.adress_recep = adress_recep;
        this.num_tel_recep = num_tel_recep;
        this.pseudo_recep = pseudo_recep;
        this.mdp_recep = mdp_recep;
        this.email_recep = email_recep;
        
        try {
            conn = DBConnector.getConnection();
            if(conn != null)
                System.out.println("connection BDD Admin controller done !");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TableReceptionicte(String id_recep, String nom_recep, String prenom_recep, String date_nes_recep, String adress_recep, String num_tel_recep) {
        this.id_recep = id_recep;
        this.nom_recep = nom_recep;
        this.prenom_recep = prenom_recep;
        this.date_nes_recep = date_nes_recep;
        this.adress_recep = adress_recep;
        this.num_tel_recep = num_tel_recep;
    }
    
    public void setId_recep(String id_recep) {
        this.id_recep = id_recep;
    }

    public void setNom_recep(String nom_recep) {
        this.nom_recep = nom_recep;
    }

    public void setPrenom_recep(String prenom_recep) {
        this.prenom_recep = prenom_recep;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDate_nes_recep(String date_nes_recep) {
        this.date_nes_recep = date_nes_recep;
    }

    public void setAdress_recep(String adress_recep) {
        this.adress_recep = adress_recep;
    }

    public void setNum_tel_recep(String num_tel_recep) {
        this.num_tel_recep = num_tel_recep;
    }

    public void setPseudo_recep(String pseudo_recep) {
        this.pseudo_recep = pseudo_recep;
    }

    public void setMdp_recep(String mdp_recep) {
        this.mdp_recep = mdp_recep;
    }

    public void setEmail_recep(String email_recep) {
        this.email_recep = email_recep;
    }

    
    
    public String getId_recep() {
        return id_recep;
    }

    public String getNom_recep() {
        return nom_recep;
    }

    public String getPrenom_recep() {
        return prenom_recep;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDate_nes_recep() {
        return date_nes_recep;
    }

    public String getAdress_recep() {
        return adress_recep;
    }

    public String getNum_tel_recep() {
        return num_tel_recep;
    }

    public String getPseudo_recep() {
        return pseudo_recep;
    }

    public String getMdp_recep() {
        return mdp_recep;
    }

    public String getEmail_recep() {
        return email_recep;
    }
    
    void insertingReceptioniste() throws SQLException{

       //Inserting values to a table
        String query = "INSERT INTO receptionicte(`id_recep`, `nom_recep`, `prenom_recep`, `sexe`, `date_nes_recep`, `adress_recep`, `num_tel_recep`, `pseudo_recep`, `mdp_recep`, `email_recep`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
                       
        pstmt.setString(1, id_recep); 
        pstmt.setString(2, nom_recep);
        pstmt.setString(3, prenom_recep);
        pstmt.setString(4, sexe); 
        pstmt.setString(5, date_nes_recep);
        pstmt.setString(6, adress_recep);
        pstmt.setString(7, num_tel_recep); 
        pstmt.setString(8, pseudo_recep);
        pstmt.setString(9, mdp_recep); 
        pstmt.setString(10, email_recep);
        pstmt.execute();
        
        System.out.println("Successfully inserted :: "+nom_recep);

    }    
    
}
