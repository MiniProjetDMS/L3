/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

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
    
    

}