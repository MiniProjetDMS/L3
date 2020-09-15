/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

/**
 *
 * @author DELL
 */
public class Ordonnance {
    String medicament, dosage, quentite,postage;
    int numero = 0;
    public Ordonnance(String medicament, String dosage, String quentite, String postage) {
        this.numero++;
        this.medicament = medicament;
        this.dosage = dosage;
        this.quentite = quentite;
        this.postage = postage;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getMedicament() {
        return medicament;
    }

    public String getDosage() {
        return dosage;
    }

    public String getQuentite() {
        return quentite;
    }

    public String getPostage() {
        return postage;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setQuentite(String quentite) {
        this.quentite = quentite;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }
    
    
}
