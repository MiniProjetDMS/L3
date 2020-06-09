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
public class HistoriqueAnamnese {
    int num_dent;
    String acte;
    String date;
    String observation;

    public HistoriqueAnamnese(int num_dent, String acte, String date, String observation) {
        this.num_dent = num_dent;
        this.acte = acte;
        this.date = date;
        this.observation = observation;
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

    public String getObservation() {
        return observation;
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

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
}
