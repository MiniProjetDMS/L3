
package packages;

import java.util.Date;

public class Patient  extends Personne{
    
    public Patient(String nom, String prenom, int id_personne, String sexe, Date date_nes, String address, int num_tel, String email, String pseudo, String mdp) {
        super(nom, prenom, id_personne, sexe, date_nes, address, num_tel, email, pseudo, mdp);
    }
    
}
