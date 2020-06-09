
package mini_projet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private ListView<String> listePatien;
    @FXML
    private TextField textFieldRecherchePatient;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listePatient();
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
    /*
    * Afficher profil medecin
    */
    private void setProfil(){
    labID.setText(""+doctor.getId_med());
    labFamilyName.setText(doctor.getNom_med());
    labFirstName.setText(doctor.getPrenom_med());
    labBirthDate.setText(doctor.getDate_nes_med());
    labAddress.setText(doctor.getAdress_med());
    labPhoneNum.setText(doctor.getNum_tel_med());
    labPseudo.setText(doctor.getPseudo_med());
    }
    //SELECT id_rdv,nom_pat,prenom_pat,time_rdv,info_pat FROM rdvs FULL JOIN patient ON id_patRDV = patient.id_pat AND activateRDV = 'yes';
    ObservableList<String> liste = FXCollections.observableArrayList();
    private void listePatient(){
        try(Connection conn = DBConnector.getConnection();) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_rdv,nom_pat,prenom_pat,time_rdv,info_pat FROM rdvs FULL JOIN patient ON id_patRDV = patient.id_pat AND activateRDV = 'yes'");
            while(rs.next()){
                String patient = ""+rs.getInt("id_rdv")+" "+rs.getString("nom_pat")+" "+rs.getString("nom_pat")+" "+rs.getString("time_rdv")+" "+rs.getString("info_pat");
                liste.add(patient);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listePatien.setItems(liste);
        
    }
    
    @FXML
    public void newConsultation() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNewConsultation.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("New Consultation");
        stage.resizableProperty().set(false);
        stage.show();
    }
    
    @FXML
    public void patientRecord() throws IOException, SQLException, ClassNotFoundException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPatientRecord.fxml"));
        Parent root = loader.load();
        FXMLPatientRecordController record = loader.getController();
        record.setId(1);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Patient Record");
        stage.resizableProperty().set(false);
        stage.show();
    }
    
    @FXML
    public void viewPayments() throws IOException, SQLException, ClassNotFoundException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLViewPayments.fxml"));
        Parent root = loader.load();
        FXMLViewPaymentsController facture = loader.getController();
        facture.setId(1);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("View Payments");
        stage.resizableProperty().set(false);
        stage.show();
    }
}
