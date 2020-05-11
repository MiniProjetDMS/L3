package mini_projet;

//import java.util.Date;
import java.sql.Date;
import java.util.logging.Logger;


/**
 *
 * @author Nadir
 */
public class TableRendezVous {
    
    int id_rdv;
    Date date;
    String heure; 
    String num_rdv;
    String id_pat;

    public TableRendezVous(int id_rdv, Date date, String heure, String num_rdv, String id_pat) {
        this.id_rdv = id_rdv;
        this.date = date;
        this.heure = heure;
        this.num_rdv = num_rdv;
        this.id_pat = id_pat;
    }

    public int getId_rdv() {
        return id_rdv;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getNum_rdv() {
        return num_rdv;
    }

    public String getId_pat() {
        return id_pat;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setNum_rdv(String num_rdv) {
        this.num_rdv = num_rdv;
    }

    public void setId_pat(String id_pat) {
        this.id_pat = id_pat;
    }
    
    
    
}
