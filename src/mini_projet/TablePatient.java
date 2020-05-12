
package mini_projet;

import java.sql.Connection;
import java.sql.Date;
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
    
}
