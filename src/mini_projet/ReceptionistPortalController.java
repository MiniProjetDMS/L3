/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
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
    @FXML
    private ToggleGroup sexe;
    @FXML
    private Label lab_ID;
    @FXML
    private TableColumn<TableRendezVous, String> col_NRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_FamilyNameRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_FirstNameRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_PhoneRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_NameDoctor;
    @FXML
    private TableColumn<TableRendezVous, String> col_DateRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_TimeRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_InfoRDV;
    @FXML
    private TableColumn<TableRendezVous, String> col_ActivateRDV;
    @FXML
    private TableView<TableRendezVous> tableRDV;
    ObservableList<TableRendezVous> oblistRDV = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTblesPatient();
        remplirTblesRDV();
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
    private void addPatient() throws SQLException, ClassNotFoundException{
        newPatient();
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
    * Remplir la table Patient
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
    
     /*
    * fonction recuperer et insertion les données de patient    
    * de formulaire vers la BDD
    * id_medecinTraitant par Default 0  f bdd !! 
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
        public void setID(int id){
        lab_ID.setText("ID :: "+id);
    }
    private TableReceptionicte receptioniste = null; 
    public void setReceptioniste(TableReceptionicte receptioniste){
        this.receptioniste = receptioniste;
        lab_ID.setText("Mmd :: "+this.receptioniste.getNom_recep());
    }
    
    /*
    * Ajoute un RDV
    * 
    */
    @FXML
    public void addRDV() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRendezVousIDPatient.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Add appointment patient");
        stage.resizableProperty().set(false);
        stage.show();
    }
    
    /*
    * Remplir la table Rendez vous
    * 
    */
    void remplirTblesRDV(){         

        try(Connection conn = DBConnector.getConnection();) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_rdv,num_rdv,nom_pat,prenom_pat,id_medecinTraitant,num_tel_pat,date,time_rdv,info_pat,activateRDV FROM rdvs FULL JOIN patient ON id_patRDV = patient.id_pat");
            while(rs.next()){
                oblistRDV.add(new TableRendezVous(rs.getInt("id_rdv"), rs.getString("date"), rs.getString("time_rdv"), rs.getInt("num_rdv"), rs.getString("info_pat"), rs.getString("nom_pat"), rs.getString("prenom_pat"), rs.getInt("id_medecinTraitant"), rs.getString("num_tel_pat"),rs.getString("activateRDV")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }        
            col_NRDV.setCellValueFactory(new PropertyValueFactory<>("id_rdv"));
            col_FamilyNameRDV.setCellValueFactory(new PropertyValueFactory<>("nom_pat"));
            col_FirstNameRDV.setCellValueFactory(new PropertyValueFactory<>("prenom_pat"));
            col_PhoneRDV.setCellValueFactory(new PropertyValueFactory<>("num_tel_pat"));//TableDoctor.doctorWhereID
            col_NameDoctor.setCellValueFactory(new PropertyValueFactory<>("nomMed"));
            col_DateRDV.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_TimeRDV.setCellValueFactory(new PropertyValueFactory<>("time_rdv"));
            col_InfoRDV.setCellValueFactory(new PropertyValueFactory<>("info_pat"));
            col_ActivateRDV.setCellValueFactory(new PropertyValueFactory<>("activate"));
            tableRDV.setItems(oblistRDV);      //remplir 1er table RDV       
    }
    
    /*
    * recuper id selectioné et supprimi de la bdd rendez vous
    * 
    */
    @FXML
    private void cancelSelectRDV() throws SQLException, ClassNotFoundException{
        if(tableRDV.getSelectionModel().getSelectedItem() != null){
            TableRendezVous selectReceptioniste = tableRDV.getSelectionModel().getSelectedItem();
            TableRendezVous.cancelRDV(selectReceptioniste.getId_rdv());
            tableRDV.getItems().removeAll(tableRDV.getSelectionModel().getSelectedItem());
        }
    }
    
    /*
    * recuper id selectioné et modiffier le rendez vous dans la BDD
    */
    @FXML
    private void modiffierRDV() throws SQLException, IOException, ClassNotFoundException{
        if(tableRDV.getSelectionModel().getSelectedItem() != null){
            TableRendezVous selectReceptioniste = tableRDV.getSelectionModel().getSelectedItem();
            updateRDV(selectReceptioniste.getId_rdv());
            System.out.println("ID :: "+selectReceptioniste.getId_rdv());
        }
    }
    
    /*
    * Modiffier un RDV dans la BDD
    * 
    */
    public void updateRDV(int id) throws IOException, SQLException, ClassNotFoundException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLModifyAppointment.fxml"));
        Parent root = loader.load();
        FXMLModifyAppointmentController mrdv = loader.getController();
        mrdv.setId(id);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Add appointment patient");
        stage.resizableProperty().set(false);
        stage.show();
    }
    
    /*
    * activer rendez vous
    * 
    */
    @FXML
    private void activRDV() throws SQLException, ClassNotFoundException{
        if(tableRDV.getSelectionModel().getSelectedItem() != null){
            TableRendezVous.upDateActiv(tableRDV.getSelectionModel().getSelectedItem().getId_rdv());            
        }
    }
    @FXML
    public void refreshRDVtable(){
        oblistRDV.clear();
        remplirTblesRDV();
    }

}
