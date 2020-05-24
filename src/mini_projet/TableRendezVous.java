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
public class TableRendezVous {

    int id_rdv;
    String date;
    String time_rdv; 
    int num_rdv;
    String info_pat;
    String nom_pat,prenom_pat,num_tel_pat;
    String activate;

    public TableRendezVous(int id_rdv, String date, String time_rdv, int num_rdv, String info_pat, String nom_pat, String prenom_pat, String num_tel_pat, String activate) {
        this.id_rdv = id_rdv;
        this.date = date;
        this.time_rdv = time_rdv;
        this.num_rdv = num_rdv;
        this.info_pat = info_pat;
        this.nom_pat = nom_pat;
        this.prenom_pat = prenom_pat;
        this.num_tel_pat = num_tel_pat;
        this.activate = activate;
    }
    public TableRendezVous(int num_rdv, String nom_pat, String prenom_pat, String num_tel_pat, String info_pat, String date, String time_rdv, String activate) {
        this.date = date;
        this.time_rdv = time_rdv;
        this.num_rdv = num_rdv;
        this.info_pat = info_pat;
        this.nom_pat = nom_pat;
        this.prenom_pat = prenom_pat;
        this.num_tel_pat = num_tel_pat;
        this.activate = activate;
    }

    public int getId_rdv() {
        return id_rdv;
    }

    public String getDate() {
        return date;
    }

    public String getTime_rdv() {
        return time_rdv;
    }

    public int getNum_rdv() {
        return num_rdv;
    }


    public String getInfo_pat() {
        return info_pat;
    }

    public String getNom_pat() {
        return nom_pat;
    }

    public String getPrenom_pat() {
        return prenom_pat;
    }

    public String getNum_tel_pat() {
        return num_tel_pat;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime_rdv(String time_rdv) {
        this.time_rdv = time_rdv;
    }

    public void setNum_rdv(int num_rdv) {
        this.num_rdv = num_rdv;
    }

    public void setInfo_pat(String info_pat) {
        this.info_pat = info_pat;
    }

    public void setNom_pat(String nom_pat) {
        this.nom_pat = nom_pat;
    }

    public void setPrenom_pat(String prenom_pat) {
        this.prenom_pat = prenom_pat;
    }

    public void setNum_tel_pat(String num_tel_pat) {
        this.num_tel_pat = num_tel_pat;
    }

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }
     
    
    
    static int insertNewRDV(int id, String date, String heur, String info) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        int rendezVous = 0;
        
        String sql = "INSERT INTO rdvs(id_patRDV, date, time_rdv, info_pat, num_rdv) "
                   + "VALUES(?,?,?,?,?)";        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setInt(1, id);
            pstmt.setString(2, date);
            pstmt.setString(3, heur);
            pstmt.setString(4, info);
            pstmt.setInt(5,10);
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1){
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    rendezVous = rs.getInt(1);
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
        return rendezVous;
    }
    
    public static void cancelRDV(int id) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        String sql = "DELETE FROM rdvs WHERE id_rdv  = " + id;        
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {            
            pstmt.execute();
            System.out.println("Record ID :"+id+" deleted successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    static void upDateRDV(int id, String date, String heur, String info) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE rdvs SET date = ?, time_rdv = ?, info_pat = ?, num_rdv = ?"+" WHERE id_rdv = ?";
            
        try (Connection conn = DBConnector.getConnection();
           PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {                
              pstmt.setString(1, date);
              pstmt.setString(2, heur);
              pstmt.setString(3, info);
              pstmt.setInt(4,10);
              pstmt.setInt(5, id);
              int i = pstmt.executeUpdate();
              System.out.println("Record ID :"+id+" Name :"+i+" update successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
        
    static TablePatient patientWhereIDrdv(int id) throws ClassNotFoundException, SQLException{
        boolean status = false;
        TablePatient patient = null;
        int idPat = 0;
        try(Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT id_patRDV FROM rdvs WHERE id_rdv  = ?");) {
            pstmt.setInt(1, id);
            System.out.println("PreparedStatement :: "+pstmt);
            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
            idPat = rs.getInt("id_patRDV");
            System.out.println("resulta :: "+rs.getString(2));            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        patient = TablePatient.patientWhereID(idPat);
        return patient;
    }
    
    static void upDateActiv(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE rdvs SET activateRDV = ?"+" WHERE id_rdv = ?";
            
        try (Connection conn = DBConnector.getConnection();
           PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {                
              pstmt.setString(1, "Yes");
              pstmt.setInt(2, id);
              int i = pstmt.executeUpdate();
              System.out.println("Record ID :"+id+" Name :"+i+" update status successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
   
}
