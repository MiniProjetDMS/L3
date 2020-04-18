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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
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
    private TextField textF;
    private Label labMessage;// hado homa li zednahom w fhado homa les id li dernahom ok? fhamt senna nwerik haja
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;
    @FXML
    private DatePicker dat;
    @FXML
    private Label labMsg;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> cNom;
    @FXML
    private TableColumn<?, ?> cPrenom;
    @FXML
    private TableColumn<?, ?> cNee;//jamais khedamt b had tableau rani 3ada nt3alam hhhhhhhhh sema matnkhela3eche ga.3 net3almou.. are yo aalive wah cnx
    
// fache kherabt bache mawlatche tkhedam hadik ? shahia li matekhdemsh? awlogin nothing at allllllllllllll
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
        home = FXMLLoader.load(getClass().getResource("/mini_projet/LoginAdmin.fxml"));//hna mazal makmalt :'(
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();
    }

    private void fonctionMessage(MouseEvent event) {
        labMessage.setText(textF.getText());// cnx mchat w jat ok aaaa hadik bach ya3etik les suggestion ta3e les méthodes dir ctrl+espace ok N?a3rafha zidha fi rohak
    }// la ghi nza3a9 ok zedtha f raci w 7asit raci smant hhhhhhhhhhhhh hh

    @FXML
    private void Add(MouseEvent event) {
        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String date = dat.getValue().toString(); // hadi rani nasiha 
        String msg = "nom :"+nom + " prenom :"+ prenom + " Née :"+ date; 
        labMsg.setText(msg);// ta7ssab ni nshouf f  tuto.. dertlak pause
        
        cNom.setText(nom);
        cPrenom.setText(prenom);
        cNee.setText(date);//ya rabi ya rabi ya rabi hhhhhhhhhhhhhhh 
        
        
    }

    @FXML
    private void Del(MouseEvent event) {
           labMsg.setText("...");
    }
    
}
