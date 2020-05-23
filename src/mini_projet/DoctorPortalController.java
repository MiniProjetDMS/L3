
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private Pane paneAppointementList;
    @FXML
    private Label lab_ID;
    @FXML
    private Button profEdit;
    @FXML
    private Pane paneProfilManage;
    @FXML
    private TextField docNom;
    @FXML
    private TextField docPrenom;
    @FXML
    private TextField docAddress;
    @FXML
    private TextField DocLog;
    @FXML
    private DatePicker docDate;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private PasswordField DocPWD;
    @FXML
    private TextField docID;
    @FXML
    private TextField docPhone;
    @FXML
    private TableColumn<?, ?> numRdv;
    @FXML
    private TableColumn<?, ?> patInfo;
    @FXML
    private TableColumn<?, ?> RdvDate;
    @FXML
    private TableColumn<?, ?> RdvTime;
    @FXML
    private TableColumn<?, ?> RdvCom;
    @FXML
    private Button rdvEdit;
    @FXML
    private Button rdvAdd;
    @FXML
    private Button rdvDel;
    @FXML
    private TextField PatID;
    @FXML
    private DatePicker consult;
    @FXML
    private ImageView schema;
    @FXML
    private Tab treatList;
    @FXML
    private Button ordnc;
    @FXML
    private Label labID;
    @FXML
    private Label labFamilyName;
    @FXML
    private Label labFirstName;
    @FXML
    private Label labBirthDate;
    @FXML
    private Label labAddress;
    @FXML
    private Label labPhoneNum;
    @FXML
    private Label labPseudo;
    @FXML
    private Label labSexe;

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
    private void exitD(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("/mini_projet/LoginDoctor.fxml"));
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
        paneAppointementList.toFront();
    }
    
    public void setID(int id){
        lab_ID.setText(""+id);
    }
    
    private TableDoctor doctor = null; 
    public void setDoctor(TableDoctor doctor){
        this.doctor = doctor;
        setProfil();
    }
    
    private void setProfil(){
    labID.setText(""+doctor.getId_med());
    labFamilyName.setText(doctor.getNom_med());
    labFirstName.setText(doctor.getPrenom_med());
    labBirthDate.setText(doctor.getDate_nes_med());
    labAddress.setText(doctor.getAdress_med());
    labPhoneNum.setText(doctor.getNum_tel_med());
    labPseudo.setText(doctor.getPseudo_med());
    labSexe.setText(doctor.getSexe());
    }
    
}
