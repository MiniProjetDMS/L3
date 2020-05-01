package mini_projet.portal;


public class TableReceptionicte {
    String id_recep;
    String nom_recep, prenom_recep, sexe;
    String date_nes_recep;
    String adress_recep, num_tel_recep, pseudo_recep;
    String mdp_recep, email_recep;

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
    
    
}
