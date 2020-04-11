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
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminPortalController implements Initializable {

    @FXML
    private Pane paneStatistique;
    @FXML
    private Pane paneManageDoctor;
    @FXML
    private Pane paneManageReceptionist;
    @FXML
    private Button button;
    @FXML
    private RadioButton test;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }      

    @FXML
    private void toFrontMR(MouseEvent event) {
        paneManageReceptionist.toFront();
    }

    @FXML
    private void toFrontMD(MouseEvent event) {
        paneManageDoctor.toFront();
    }

    @FXML
    private void toFrontStatistique(MouseEvent event) {
        paneStatistique.toFront();
    }

    @FXML
    private void exitA(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));//hna mazal makmalt :'(
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();
    }
    
}
