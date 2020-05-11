package mini_projet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Random;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML 
     private TableView<TablePatient> tablePat; //***  table patient
    
    @FXML
    private TableColumn<TablePatient, String> cNom_pat;
    @FXML
    private TableColumn<TablePatient, String> cPrenom_pat;
    @FXML
    private TableColumn<TablePatient, String> cDate_pat;
    @FXML
    private TableColumn<TablePatient, String> cID_pat;
    @FXML
    private TableColumn<TablePatient, String> cAdress_pat;
    @FXML
    private TableColumn<TablePatient, String> cTel_pat;
    @FXML
    private TableColumn<TablePatient, String> cGender_pat;
    
    ObservableList<TablePatient> oblist1 = FXCollections.observableArrayList();
    
    @FXML
    private TextField textID_pat;
    @FXML
    private TextField textPhonePat;
    @FXML
    private TextField textAddressPat; 
    @FXML
    private TextField textFieldNom_Pat;
    @FXML
    private TextField textFieldPrenom_pat;
    @FXML
    private DatePicker datePicker_pat;
    @FXML
    private TextField textFieldGender_pat;
    @FXML
    private TextField textFieldEtat_pat;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cnx_bdd();
    }
    
    void cnx_bdd(){
        // ##### connection BDD
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            if(conn != null)
                System.out.println("connection BDD Receptionist controller done !");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ReceptionistPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ##### 
        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from patient");
            
            
            while(rs.next()){
                oblist1.add(new TablePatient(rs.getString("id_pat"),rs.getString("nom_pat"),rs.getString("prenom_pat"),rs.getString("date_nes_pat"),rs.getString("adress_pat"),rs.getString("sexe"),rs.getString("num_tel_pat")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionistPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cID_pat.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
        cNom_pat.setCellValueFactory(new PropertyValueFactory<>("nom_pat"));
        cPrenom_pat.setCellValueFactory(new PropertyValueFactory<>("prenom_pat"));
        cDate_pat.setCellValueFactory(new PropertyValueFactory<>("date_nes_pat"));
        cAdress_pat.setCellValueFactory(new PropertyValueFactory<>("adress_pat"));
        cGender_pat.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        cTel_pat.setCellValueFactory(new PropertyValueFactory<>("num_tel_pat"));
        tablePat.setItems(oblist1);      //remplir 1er table   
        
        
    }
    @FXML
    private void PatientFor() throws SQLException{
        String nomP,prenomP,dateP,phoneP,adressP,sexeP,etatP;
        //String  ID_r= null ;
        //String emailR = null;//-------------
        
        nomP = textFieldNom_Pat.getText();
        prenomP = textFieldPrenom_pat.getText();
        dateP = datePicker_pat.getValue().format(DateTimeFormatter.ISO_DATE);//getPromptText();
        phoneP = textPhonePat.getText();
        adressP = textAddressPat.getText();
        sexeP = textFieldGender_pat.getText();
        etatP = textFieldEtat_pat.getText();
        
        Random rand = new Random();
        char c = (char)(rand.nextInt(26) + 97);
        String ID_p = new String();
        ID_p = c+"";
        //emailR = "test2@mail.dz"; 
        
        TablePatient patient = new TablePatient(ID_p,nomP,prenomP, sexeP, dateP,adressP, phoneP,etatP);
        patient.insertingPatient();
       cnx_bdd();
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
    private void printPat(MouseEvent event) throws SQLException {// button add :: Fonction test Patient
        PatientFor();
    }
}
