/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.util.logging.Logger;

/**
 *
 * @author Nadir
 */
public class HistoriqueOrdonnances {
        String date;
        String medicament1;
        String medicament2;
        String medicament3;
        String medicament4;
        String medicament5;
        String medicament6;

    public HistoriqueOrdonnances(String date, String medicament1, String medicament2, String medicament3, String medicament4, String medicament5, String medicament6) {
        this.date = date;
        this.medicament1 = medicament1;
        this.medicament2 = medicament2;
        this.medicament3 = medicament3;
        this.medicament4 = medicament4;
        this.medicament5 = medicament5;
        this.medicament6 = medicament6;
    }

    public String getDate() {
        return date;
    }

    public String getMedicament1() {
        return medicament1;
    }

    public String getMedicament2() {
        return medicament2;
    }

    public String getMedicament3() {
        return medicament3;
    }

    public String getMedicament4() {
        return medicament4;
    }

    public String getMedicament5() {
        return medicament5;
    }

    public String getMedicament6() {
        return medicament6;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMedicament1(String medicament1) {
        this.medicament1 = medicament1;
    }

    public void setMedicament2(String medicament2) {
        this.medicament2 = medicament2;
    }

    public void setMedicament3(String medicament3) {
        this.medicament3 = medicament3;
    }

    public void setMedicament4(String medicament4) {
        this.medicament4 = medicament4;
    }

    public void setMedicament5(String medicament5) {
        this.medicament5 = medicament5;
    }

    public void setMedicament6(String medicament6) {
        this.medicament6 = medicament6;
    }

    
        
}
