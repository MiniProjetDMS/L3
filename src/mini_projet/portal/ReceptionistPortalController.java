package mini_projet.portal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ReceptionistPortalController implements Initializable {

    
    @FXML
    private Pane paneManagePatient;
    @FXML
    private Pane paneManageAppointement;
    @FXML
    private Pane paneMessageDoctor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void exitR(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("/mini_projet/LoginReceptionist.fxml"));
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();
    }    


    @FXML
    private void toFrontManagePatient(MouseEvent event) {
        paneManagePatient.toFront();
    }

    @FXML
    private void toFrontManageAppointement(MouseEvent event) {
        paneManageAppointement.toFront();
    }

    @FXML
    private void toFrontMessageDoctor(MouseEvent event) {
        paneMessageDoctor.toFront();
    }
    
}
