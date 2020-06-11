/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nadir
 */
public class TableFacture {
    private int num_facture;
    private int num_dent;
    private String acte;
    private String date;
    private int montant;
    private int versement;
    private int reste;

    public TableFacture(int num_facture, int num_dent, String acte, String date, int montant, int versement, int reste) {
        this.num_facture = num_facture;
        this.num_dent = num_dent;
        this.acte = acte;
        this.date = date;
        this.montant = montant;
        this.versement = versement;
        this.reste = reste;
    }

        public TableFacture(int montant, int versement, int reste) {
        this.montant = montant;
        this.versement = versement;
        this.reste = reste;
    }
    
    public int getNum_facture() {
        return num_facture;
    }

    public int getNum_dent() {
        return num_dent;
    }

    public String getActe() {
        return acte;
    }

    public String getDate() {
        return date;
    }

    public int getMontant() {
        return montant;
    }

    public int getVersement() {
        return versement;
    }

    public int getReste() {
        return reste;
    }

    public void setNum_facture(int num_facture) {
        this.num_facture = num_facture;
    }

    public void setNum_dent(int num_dent) {
        this.num_dent = num_dent;
    }

    public void setActe(String acte) {
        this.acte = acte;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setVersement(int versement) {
        this.versement = versement;
    }

    public void setReste(int reste) {
        this.reste = reste;
    }
 
    /*
    * recuper de bdd table Anamnese Montant, Versement et le Reste
    * WHERE ID Medecin et ID Patient
    * calculer le nouveau reste 
    * UPDATE le reste dans la BDD
    */
    public static int setVersement(int id_med, int id_pat, int versement) throws SQLException, ClassNotFoundException{
        int id = 0;
        boolean status = false;
        try(Connection conn = DBConnector.getConnection();
              PreparedStatement pstmt = conn.prepareStatement("SELECT id_anamnese,montant,versement,reste FROM anamnese WHERE id_med = ? AND id_pat = ?");){
            pstmt.setInt(1, id_med);
            pstmt.setInt(2, id_pat);
            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
            id = rs.getInt("id_anamnese");
            int mont = rs.getInt("montant");
            int ver = rs.getInt("versement");
            int reste = rs.getInt("reste");
            System.out.println("mont : "+mont+" ver :"+ver+" reste :"+reste);
            ver = ver + versement;
            reste = mont - ver;     
            System.out.println("mont : "+mont+" ver :"+ver+" nouveau reste :"+reste);
            PreparedStatement pstmtU = conn.prepareStatement("UPDATE anamnese SET versement = ?, reste = ? WHERE anamnese.id_med = ? AND anamnese.id_pat = ?");   
            pstmtU.setInt(1, ver);
            pstmtU.setInt(2, reste);
            pstmtU.setInt(3, id_med);
            pstmtU.setInt(4, id_pat);
            pstmtU.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("mini_projet.TableFacture.setVersement() ::: id setV :"+id);
        return id;
    }

    
}