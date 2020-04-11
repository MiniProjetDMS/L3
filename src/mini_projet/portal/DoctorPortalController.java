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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DoctorPortalController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private Pane paneProfil;
    @FXML
    private Pane paneMedicalFile;
    @FXML
    private Pane paneStatistique;
    @FXML
    private Pane paneAppointement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void exitD(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("../LoginDoctor.fxml"));
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();
    }

    @FXML
    private void toFrontProfil(MouseEvent event) {
        paneProfil.toFront();
    }

    @FXML
    private void toFrontMedicalFile(MouseEvent event) {
        paneMedicalFile.toFront();
    }

    @FXML
    private void toFrontStatistique(MouseEvent event) {
        paneStatistique.toFront();
    }

    @FXML
    private void toFrontAppointement(MouseEvent event) {
        paneAppointement.toFront();
    }
    
}
