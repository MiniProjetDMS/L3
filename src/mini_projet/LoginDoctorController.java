package mini_projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginDoctorController implements Initializable {

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
    
    @FXML
    private void login(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("portal/DoctorPortal.fxml"));
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(true);
        app_stage.show();
    }
    
}
