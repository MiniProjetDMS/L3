package mini_projet;


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

    public TableRendezVous(int id_rdv, String date, String time_rdv, int num_rdv, String info_pat, String nom_pat, String prenom_pat, String num_tel_pat) {
        this.id_rdv = id_rdv;
        this.date = date;
        this.time_rdv = time_rdv;
        this.num_rdv = num_rdv;
        this.info_pat = info_pat;
        this.nom_pat = nom_pat;
        this.prenom_pat = prenom_pat;
        this.num_tel_pat = num_tel_pat;
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
    
    
    
    
}
