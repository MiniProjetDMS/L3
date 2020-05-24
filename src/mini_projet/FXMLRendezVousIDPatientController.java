/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLRendezVousIDPatientController implements Initializable {

    @FXML
    private TextField textFIdPatient;
    @FXML
    private Label labErreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void nextStep(MouseEvent event, int id) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRendezVousPane.fxml"));
        Parent root = loader.load();
        FXMLRendezVousPaneController rdv = loader.getController();
        rdv.setId(id);
        Scene homeScene = new Scene(root);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();  
    }
    
    /*
    * test si ID patient existe dans BDD 
    * si oui envoi ID patient a pane ajouter rendez vous
    */
    @FXML
    public void validationID(MouseEvent event) throws IOException, SQLException, ClassNotFoundException{
          if(TablePatient.idPatientexiste(Integer.parseInt(textFIdPatient.getText()))){
              nextStep(event,Integer.parseInt(textFIdPatient.getText()));
          }else{
              labErreur.setText("The patient does not exist in the database, \n" +"register the patient and Please try again !");
          }
    }
    
    
}
