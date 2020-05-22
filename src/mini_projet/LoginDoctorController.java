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

public class LoginDoctorController implements Initializable {

    @FXML
    private TextField textFpseudo;
    @FXML
    private PasswordField textFPassword;
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
    
    private void loginDoctor(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("DoctorPortal.fxml"));
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
    private void loginD(MouseEvent event) throws SQLException, ClassNotFoundException, IOException{
        String pseudo = textFpseudo.getText();
        String password = textFPassword.getText();
        if(TableReceptionicte.receptionisteExiste(pseudo, password)){
            labMsg.setText("successfully");
            loginDoctor(event);
        }else{
            labMsg.setText("Vérifier votre pseudonym ou mot de passe !!");
        }
        
    }
}