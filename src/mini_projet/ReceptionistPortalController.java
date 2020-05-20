import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mini_projet.AdminPortalController;
import mini_projet.DBConnector;
import mini_projet.TablePatient;

public class ReceptionistPortalController implements Initializable {

    
    @FXML
    private Pane paneManagePatient;
    @FXML
    private Pane paneManageAppointement;
    @FXML
    private Pane paneMessageDoctor;
    @FXML
    private Button btnMsgD;
    @FXML
    private TextField appID;
    @FXML
    private TextField PatieID;
    @FXML
    private TextField AppNum;
    @FXML
    private DatePicker appDate;
    @FXML
    private TextField AppTime;
    @FXML
    private TextField PatieInfo;
    @FXML
    private TableColumn<?, ?> numApp;
    @FXML
    private TableColumn<?, ?> patientInfo;
    @FXML
    private TableColumn<?, ?> AppDate;
    @FXML
    private TableColumn<?, ?> AppTime2;
    @FXML
    private TableColumn<?, ?> AppCom;
    @FXML
    private Button UpdateApp;
    @FXML
    private Button DelApp;
    @FXML
    private Button AddApp;
    @FXML
    private TextField DentNom;
    @FXML
    private TextField DentAdress;
    @FXML
    private TextField DentPhone;
    @FXML
    private DatePicker DentDate;
    @FXML
    private TextField DentPre;
    @FXML
    private TextField DentCivil;
    @FXML
    private TextField DentGen;
    @FXML
    private TextField dentID;
    @FXML
    private TableColumn<?, ?> IDcolo;
    @FXML
    private TableColumn<?, ?> CNIcolo;
    @FXML
    private TableColumn<?, ?> nomColo;
    @FXML
    private TableColumn<?, ?> prenomColo;
    @FXML
    private TableColumn<?, ?> GenColo;
    @FXML
    private TableColumn<?, ?> phoneColo;
    @FXML
    private TableColumn<?, ?> AddressColo;
    @FXML
    private Button UpdateDent;
    @FXML
    private Button AddDent;
    @FXML
    private Button DelDent;
    @FXML
    private TableView<TablePatient> tablePatient;
    @FXML
    private TableColumn<TablePatient, String> cId_patient;
    @FXML
    private TableColumn<TablePatient, String> cNom_patient;
    @FXML
    private TableColumn<TablePatient, String> cPrenom_patient;
    @FXML
    private TableColumn<TablePatient, String> cNee_patient;
    @FXML
    private TableColumn<TablePatient, String> sexe_patient;
    @FXML
    private TableColumn<TablePatient, String> cPhone_patient;
    @FXML
    private TableColumn<TablePatient, String> cAdress_patient;
    
    ObservableList<TablePatient> oblist1 = FXCollections.observableArrayList();
    
    @FXML
    private TextField textFieldNom_patient;
    @FXML
    private TextField textFieldPrenom_patient;
    @FXML
    private TextField textFieldPhone_patient;
    @FXML
    private Button UpdatePat;
    @FXML
    private Button DelPat;
    @FXML
    private TextField textFieldAdress_patient;
    @FXML
    private DatePicker datePicker_patient;
    @FXML
    private TextField textFieldCivilStatus_patient;
    @FXML
    private TextField textFieldID_patient;
    @FXML
    private RadioButton radioButtonMal_patient;
    @FXML
    private RadioButton radioButtonFem_patient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTblesPatient();
    }
    
    /*
    * Remplir les deux table Patient
    * 
    */
    void remplirTblesPatient(){         

        try(Connection conn = DBConnector.getConnection();) {
            //if(conn != null)
            //    System.out.println("connection BDD Admin controller done !");
            
            ResultSet rs = conn.createStatement().executeQuery("select * from patient");
            
            while(rs.next()){
                oblist1.add(new TablePatient(rs.getInt("id_pat"),rs.getString("nom_pat"),rs.getString("prenom_pat"),rs.getString("sexe"),rs.getString("date_nes_pat"),rs.getString("etat_civil"),rs.getString("adress_pat"),rs.getString("num_tel_pat")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            cId_patient.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
            cNom_patient.setCellValueFactory(new PropertyValueFactory<>("nom_pat"));
            cPrenom_patient.setCellValueFactory(new PropertyValueFactory<>("prenom_pat"));
            cNee_patient.setCellValueFactory(new PropertyValueFactory<>("date_nes_pat"));
            sexe_patient.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            cPhone_patient.setCellValueFactory(new PropertyValueFactory<>("num_tel_pat"));
            cAdress_patient.setCellValueFactory(new PropertyValueFactory<>("adress_pat"));
            tablePatient.setItems(oblist1);      //remplir 1er table Patient         

    }
    
    
    
    
    @FXML
    private void exitR(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("/mini_projet/LoginReceptionist.fxml"));//kayan problème de path normalement en utilise directement LoginReceptionist.fxml
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
    
    @FXML
    private void addPatient() throws SQLException, ClassNotFoundException{
        newPatient();
    }
    
    /*
    * fonction recuperer et insertion les données de patient    
    * de formulaire vers la BDD
    */ 
    private void newPatient() throws SQLException, ClassNotFoundException{        
        String nom_pat, prenom_pat, date_nes_pat, etat_civil, adress_pat, num_tel_pat, sexe = null;
        nom_pat = textFieldNom_patient.getText();
        prenom_pat = textFieldPrenom_patient.getText();
        date_nes_pat = datePicker_patient.getValue().format(DateTimeFormatter.ISO_DATE);//getPromptText();
        etat_civil = textFieldCivilStatus_patient.getText();
        adress_pat = textFieldAdress_patient.getText();
        if(radioButtonMal_patient.isSelected())
            sexe = "M";
        if(radioButtonFem_patient.isSelected())
            sexe = "F";
        num_tel_pat = textFieldPhone_patient.getText();
        int id = TablePatient.insertPatient(nom_pat, prenom_pat, sexe, date_nes_pat, etat_civil, adress_pat, num_tel_pat);
        System.out.println("inserting nom :: "+nom_pat+" Id ::"+id);
        afficherNewPatient(id);
    }
    
    /*
    * fonction pour la affiche le nouveau patient dans le table
    */
    void afficherNewPatient(int id) throws SQLException, ClassNotFoundException{         
        try(Connection conn = DBConnector.getConnection();) {
            //if(conn != null)
            //    System.out.println("connection BDD Receptioniste controller done !");
            
            ResultSet rs = conn.createStatement().executeQuery("select * from patient where id_pat = "+id);
            
            while(rs.next()){
                oblist1.add(new TablePatient(rs.getInt("id_pat"),rs.getString("nom_pat"),rs.getString("prenom_pat"),rs.getString("sexe"),rs.getString("date_nes_pat"),rs.getString("etat_civil"),rs.getString("adress_pat"),rs.getString("num_tel_pat")));
            }
            cId_patient.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
            cNom_patient.setCellValueFactory(new PropertyValueFactory<>("nom_pat"));
            cPrenom_patient.setCellValueFactory(new PropertyValueFactory<>("prenom_pat"));
            cNee_patient.setCellValueFactory(new PropertyValueFactory<>("date_nes_pat"));
            sexe_patient.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            cPhone_patient.setCellValueFactory(new PropertyValueFactory<>("num_tel_pat"));
            cAdress_patient.setCellValueFactory(new PropertyValueFactory<>("adress_pat"));
            tablePatient.setItems(oblist1);      //remplir 1er table Patient   
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    * recuper id selectioné et supprimi de la bdd Patient
    * 
    */
    @FXML
    private void removeSelectPatient() throws SQLException, ClassNotFoundException{
        if(tablePatient.getSelectionModel().getSelectedItem() != null){
            TablePatient selectReceptioniste = tablePatient.getSelectionModel().getSelectedItem();
            TablePatient.deletePatient(selectReceptioniste.getId_pat());
            tablePatient.getItems().removeAll(tablePatient.getSelectionModel().getSelectedItem());
        }
    }
    
    /*
    * recuper id selectioné et meter a jour ! Patient
    */
    @FXML
    private void updateSelectPatient() throws SQLException, ClassNotFoundException{
        
        String nom_pat, prenom_pat, date_nes_pat, etat_civil, adress_pat, num_tel_pat, sexe = null;
        nom_pat = textFieldNom_patient.getText();
        prenom_pat = textFieldPrenom_patient.getText();
        date_nes_pat = datePicker_patient.getValue().format(DateTimeFormatter.ISO_DATE);//getPromptText();
        etat_civil = textFieldCivilStatus_patient.getText();
        adress_pat = textFieldAdress_patient.getText();
        if(radioButtonMal_patient.isSelected())
            sexe = "M";
        if(radioButtonFem_patient.isSelected())
            sexe = "F";
        num_tel_pat = textFieldPhone_patient.getText();
        
        if(tablePatient.getSelectionModel().getSelectedItem() != null){
            TablePatient selectReceptioniste = tablePatient.getSelectionModel().getSelectedItem();
            System.out.println("mini_projet.AdminPortalController.updateReceptioniste() :ID :: " +selectReceptioniste.getId_pat());
            TablePatient.updatePatient(selectReceptioniste.getId_pat(),nom_pat, prenom_pat, sexe, date_nes_pat, etat_civil, adress_pat, num_tel_pat);
            tablePatient.getItems().removeAll(tablePatient.getSelectionModel().getSelectedItem());
            afficherNewPatient(selectReceptioniste.getId_pat());
        }
    }
    
    
}
