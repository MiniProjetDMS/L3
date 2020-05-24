/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLRendezVousPaneController implements Initializable {

    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelDateNaissance;
    @FXML
    private Label labelPhone;
    @FXML
    private Spinner<Integer> spinnerH;
    @FXML
    private Spinner<Integer> spinnerM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> gradesValueFactoryH = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23, 9);
        spinnerH.setValueFactory(gradesValueFactoryH);
        SpinnerValueFactory<Integer> gradesValueFactoryM = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59, 00);
        spinnerM.setValueFactory(gradesValueFactoryM);
    }    
    private int id;
    public void setId(int id) throws SQLException, ClassNotFoundException{
        this.id = id;
        remplirInfoPatient(id);
    }
    private void remplirInfoPatient(int id) throws SQLException, ClassNotFoundException{
        TablePatient patient = TablePatient.patientWhereID(id);
        labelNom.setText(patient.getNom_pat());
        labelPrenom.setText(patient.getPrenom_pat());
        labelDateNaissance.setText(patient.getDate_nes_pat());
        labelPhone.setText(patient.getNum_tel_pat());
    }
    
}
