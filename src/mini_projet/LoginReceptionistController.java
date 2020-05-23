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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class LoginReceptionistController implements Initializable {

    @FXML
    private TextField textFpseudo;
    @FXML
    private PasswordField textFPassword;
    @FXML
    private Button btnBk1;
    @FXML
    private Label labMsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private Button btnBk;
    @FXML
    private void retoure(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("LoginAs.fxml"));
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.show();
    } 
    
    /*
    * charger la page de receptioniste
    */
    
    private void loginReceptioniste(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("ReceptionistPortal.fxml"));
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(true);
        app_stage.show();
    }
    
    /*
    * si le pseudonyme correcte laisse le entrer
    * 
    */
    @FXML
    private void loginR(MouseEvent event) throws SQLException, ClassNotFoundException, IOException{
        String pseudo = textFpseudo.getText();
        String password = textFPassword.getText();
        if(TableReceptionicte.receptionisteExiste(pseudo, password)){
            labMsg.setText("successfully");
            loginReceptioniste(event);
        }else{
            labMsg.setText("Vérifier votre pseudonym ou mot de passe !!");
        }
        
    }
    @FXML
    public void loginRece(MouseEvent event) throws SQLException, ClassNotFoundException, IOException{
        String pseudo = textFpseudo.getText();
        String password = textFPassword.getText();
        if(TableReceptionicte.receptionisteExiste(pseudo, password)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReceptionistPortal.fxml"));
            Parent root =  loader.load();            
            ReceptionistPortalController receptionisteID = loader.getController();
            receptionisteID.setID(556684);
            receptionisteID.setReceptioniste(TableReceptionicte._receptionisteExiste(pseudo, password));            
            Scene homeScene = new Scene(root);
            Stage app_stage;
            app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homeScene);
            app_stage.resizableProperty().set(true);
            app_stage.show();
        }else{
            labMsg.setText("Vérifier votre pseudonym ou mot de passe !!");
        }
    }

    
}
