
package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nadir
 */
public class TablePatient {
    
    int id_pat;
    int id_medecinTraitant;
    String nom_pat;
    String prenom_pat;
    String sexe;
    String date_nes_pat;
    String etat_civil;
    String adress_pat;
    String num_tel_pat;

    public TablePatient(int id_pat, String nom_pat, String prenom_pat, String sexe, String date_nes_pat, String etat_civil, String adress_pat, String num_tel_pat) {
        this.id_pat = id_pat;
        this.nom_pat = nom_pat;
        this.prenom_pat = prenom_pat;
        this.sexe = sexe;
        this.date_nes_pat = date_nes_pat;
        this.etat_civil = etat_civil;
        this.adress_pat = adress_pat;
        this.num_tel_pat = num_tel_pat;
    }

    public TablePatient(int id_pat, int id_medecinTraitant,String nom_pat, String prenom_pat, String sexe, String date_nes_pat, String etat_civil, String adress_pat, String num_tel_pat) {
        this.id_pat = id_pat;
        this.id_medecinTraitant = id_medecinTraitant;
        this.nom_pat = nom_pat;
        this.prenom_pat = prenom_pat;
        this.sexe = sexe;
        this.date_nes_pat = date_nes_pat;
        this.etat_civil = etat_civil;
        this.adress_pat = adress_pat;
        this.num_tel_pat = num_tel_pat;
    }
    
    public int getId_pat() {
        return id_pat;
    }

    public String getNom_pat() {
        return nom_pat;
    }

    public String getPrenom_pat() {
        return prenom_pat;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDate_nes_pat() {
        return date_nes_pat;
    }

    public String getEtat_civil() {
        return etat_civil;
    }

    public String getAdress_pat() {
        return adress_pat;
    }

    public String getNum_tel_pat() {
        return num_tel_pat;
    }

    public int getId_medecinTraitant() {
        return id_medecinTraitant;
    }
    
    public void setId_pat(int id_pat) {
        this.id_pat = id_pat;
    }

    public void setNom_pat(String nom_pat) {
        this.nom_pat = nom_pat;
    }

    public void setPrenom_pat(String prenom_pat) {
        this.prenom_pat = prenom_pat;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDate_nes_pat(String date_nes_pat) {
        this.date_nes_pat = date_nes_pat;
    }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public void setAdress_pat(String adress_pat) {
        this.adress_pat = adress_pat;
    }

    public void setNum_tel_pat(String num_tel_pat) {
        this.num_tel_pat = num_tel_pat;
    }

    public void setId_medecinTraitant(int id_medecinTraitant) {
        this.id_medecinTraitant = id_medecinTraitant;
    }
    
    
    public static int insertPatient (String nom_pat, String prenom_pat, String sexe, String date_nes_pat, String etat_civil, String adress_pat, String num_tel_pat) throws SQLException, ClassNotFoundException {

        ResultSet rs = null;
        int PatientId = 0;
        
        String sql = "INSERT INTO patient(nom_pat, prenom_pat, sexe, date_nes_pat, etat_civil, adress_pat, num_tel_pat) "
                   + "VALUES(?,?,?,?,?,?,?)";
        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, nom_pat);
            pstmt.setString(2, prenom_pat);
            pstmt.setString(3, sexe);
            pstmt.setString(4, date_nes_pat);
            pstmt.setString(5, etat_civil);
            pstmt.setString(6, adress_pat);
            pstmt.setString(7, num_tel_pat);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    PatientId = rs.getInt(1);
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
        return PatientId;
    }
    
    public static void deletePatient(int id) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        String sql = "DELETE FROM patient WHERE id_pat = " + id;        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {            
            pstmt.execute();
            System.out.println("Record ID :"+id+" deleted successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updatePatient(int id, String nom_pat, String prenom_pat, String sexe, String date_nes_pat, String etat_civil, String adress_pat, String num_tel_pat) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE patient SET `nom_pat` = ?, `prenom_pat` = ?, `sexe` = ?, `date_nes_pat` = ?, `etat_civil` = ?, `adress_pat` = ?, `num_tel_pat` = ?"+" WHERE `id_pat` = ?";
        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, nom_pat);
            pstmt.setString(2, prenom_pat);
            pstmt.setString(3, sexe);
            pstmt.setString(4, date_nes_pat);
            pstmt.setString(5, etat_civil);
            pstmt.setString(6, adress_pat);
            pstmt.setString(7, num_tel_pat);
            pstmt.setInt(8, id);
            
            int i = pstmt.executeUpdate();
            System.out.println("Record ID :"+id+" Name :"+i+" update successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    * test si ID patient existe dans BDD
    * 
    */
    public static boolean idPatientexiste(int id) throws SQLException, ClassNotFoundException{
        boolean status = false;
        try(Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient WHERE id_pat  = ?");) {
            pstmt.setInt(1, id);
            System.out.println("PreparedStatement :: "+pstmt);
            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
            System.out.println("resulta :: "+rs.getString(2));            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return status;
    }
    
    /*
    * test si ID patient existe dans BDD
    * 
    */
    public static TablePatient patientWhereID(int id) throws SQLException, ClassNotFoundException{
        boolean status = false;
        TablePatient patient = null;
        try(Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient WHERE id_pat  = ?");) {
            pstmt.setInt(1, id);
            System.out.println("PreparedStatement :: "+pstmt);
            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
            patient = new TablePatient(rs.getInt("id_pat"),rs.getString("nom_pat"),rs.getString("prenom_pat"),rs.getString("sexe"),rs.getString("date_nes_pat"),rs.getString("etat_civil"),rs.getString("adress_pat"),rs.getString("num_tel_pat"));
            System.out.println("resulta :: "+rs.getString(2));            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return patient;
    }
    
     public static TablePatient patientDWhereID(int id) throws SQLException, ClassNotFoundException{
        boolean status = false;
        TablePatient patient = null;
        try(Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient WHERE id_pat  = ?");) {
            pstmt.setInt(1, id);
            System.out.println("PreparedStatement :: "+pstmt);
            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
            patient = new TablePatient(rs.getInt("id_pat"),rs.getInt("id_medecinTraitant"),rs.getString("nom_pat"),rs.getString("prenom_pat"),rs.getString("sexe"),rs.getString("date_nes_pat"),rs.getString("etat_civil"),rs.getString("adress_pat"),rs.getString("num_tel_pat"));
            System.out.println("resulta :: "+rs.getString(2));            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return patient;
    }
     
    public static void updateIdPatient(int idPat, int idMed) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE patient SET `id_medecinTraitant` = ?"+" WHERE `id_pat` = ?";
        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setInt(1, idMed);
            pstmt.setInt(2, idPat);
            
            int i = pstmt.executeUpdate();
            System.out.println("Record ID Patient :"+idPat+" ID Med :"+idMed+" "+i+"update successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
/*

*/
