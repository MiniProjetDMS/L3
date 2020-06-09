/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLPatientRecordController implements Initializable {

    @FXML
    private TableView<HistoriqueAnamnese> tableHistoriqueAnamnese;
    @FXML
    private TableColumn<HistoriqueAnamnese, String> col_numDent;
    @FXML
    private TableColumn<HistoriqueAnamnese, String> col_Acte;
    @FXML
    private TableColumn<HistoriqueAnamnese, String> col_Date;
    @FXML
    private TableColumn<HistoriqueAnamnese, String> col_Observation;
    @FXML
    private TableView<HistoriqueOrdonnances> tableHistoriqueOrdonance;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_DateOrdonnance;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_medicament1;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_medicament2;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_medicament3;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_medicament4;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_medicament5;
    @FXML
    private TableColumn<HistoriqueOrdonnances, String> col_medicament6;
    @FXML
    private Label labDateN;
    @FXML
    private Label labNom;
    @FXML
    private Label labPrenom;
    @FXML
    private Label labAdresse;
    @FXML
    private Label LabNumTele;
    @FXML
    private Label labAntecedent;
    @FXML
    private Label labObservation;
    
    ObservableList<HistoriqueAnamnese> oblistAnam = FXCollections.observableArrayList();
    ObservableList<HistoriqueOrdonnances> oblistOrdonn = FXCollections.observableArrayList();

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) throws SQLException, ClassNotFoundException {
        this.id = id;
        ficheTechniquePatient(id);
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTblesHistoriqueAnamnese();
        remplirTblesHistoriqueOrdonnance();
        
    }       
    
    /*
    * Remplir la table Historique Anamnèse
    * 
    */
    void remplirTblesHistoriqueAnamnese(){         

        try(Connection conn = DBConnector.getConnection();) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT date_consultation,num_dent,acte,observation FROM anamnese");
            while(rs.next()){
                oblistAnam.add(new HistoriqueAnamnese(rs.getInt("num_dent"),rs.getString("acte"),rs.getString("date_consultation"),rs.getString("observation")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // col_numDent col_Acte col_Date col_Observation
            col_numDent.setCellValueFactory(new PropertyValueFactory<>("num_dent"));
            col_Acte.setCellValueFactory(new PropertyValueFactory<>("acte"));
            col_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_Observation.setCellValueFactory(new PropertyValueFactory<>("observation"));
            tableHistoriqueAnamnese.setItems(oblistAnam);      //remplir 1er table Historique Anamnese         
    }
    
    /*
    * Remplir la table Historique Ordonnance
    * 
    */
    void remplirTblesHistoriqueOrdonnance(){         

        try(Connection conn = DBConnector.getConnection();) {            
            ResultSet rs = conn.createStatement().executeQuery("select * from ordonnance");            
            while(rs.next()){
                oblistOrdonn.add(new HistoriqueOrdonnances(rs.getString("date_ordonnace"),rs.getString("medicament1"),rs.getString("medicament2"),rs.getString("medicament3"),rs.getString("medicament4"),rs.getString("medicament5"),rs.getString("medicament6")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // col_numDent col_Acte col_Date col_Observation
            col_DateOrdonnance.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_medicament1.setCellValueFactory(new PropertyValueFactory<>("medicament1"));
            col_medicament2.setCellValueFactory(new PropertyValueFactory<>("medicament2"));
            col_medicament3.setCellValueFactory(new PropertyValueFactory<>("medicament3"));
            col_medicament4.setCellValueFactory(new PropertyValueFactory<>("medicament4"));
            col_medicament5.setCellValueFactory(new PropertyValueFactory<>("medicament5"));
            col_medicament6.setCellValueFactory(new PropertyValueFactory<>("medicament6"));
            tableHistoriqueOrdonance.setItems(oblistOrdonn);      //remplir 1er table Historique Ordonnace       
    }
    
    void ficheTechniquePatient(int id_patient) throws SQLException, ClassNotFoundException{
        TablePatient patient = TablePatient.patientWhereID(id_patient);
        labDateN.setText(patient.getDate_nes_pat());
        labNom.setText(patient.getNom_pat());
        labPrenom.setText(patient.getPrenom_pat()); 
        labAdresse.setText(patient.getAdress_pat()); 
        LabNumTele.setText(patient.getNum_tel_pat()); 
        labAntecedent.setText("Non"); 
        labObservation.setText("Vide");
    }
}
