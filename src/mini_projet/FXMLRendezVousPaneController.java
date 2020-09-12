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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLRendezVousPaneController implements Initializable {

    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelDateNaissance;
    @FXML
    private Label labelPhone;
    @FXML
    private Spinner<Integer> spinnerH;
    @FXML
    private Spinner<Integer> spinnerM;
    @FXML
    private DatePicker dateRDV;
    @FXML
    private TextArea infoRDV;
    @FXML
    private Button closeButton;
    
    ObservableList<TableDoctor> doctor = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<TableDoctor> choicBoxDoctor;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerInit();
        try {
            remplirChoicBoxMed();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRendezVousPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void remplirChoicBoxMed() throws SQLException{
        try(Connection conn = DBConnector.getConnection();) {
            ResultSet rs2 = conn.createStatement().executeQuery("select * from medcin");
                while(rs2.next()){
                    doctor.add(new TableDoctor(rs2.getInt("id_med"), rs2.getString("nom_med"), rs2.getString("prenom_med"),rs2.getString("date_nes_med"), rs2.getString("adress_med"), rs2.getString("num_tel_med")));
                }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        choicBoxDoctor.setItems(doctor);
    }
    
    private void spinnerInit(){
        SpinnerValueFactory<Integer> gradesValueFactoryH = new SpinnerValueFactory.IntegerSpinnerValueFactory(8,16, 8);
        spinnerH.setValueFactory(gradesValueFactoryH);
        SpinnerValueFactory<Integer> gradesValueFactoryM = new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 30, 00, 30);
        spinnerM.setValueFactory(gradesValueFactoryM);
    }
    
    private int id;
    public void setId(int id) throws SQLException, ClassNotFoundException{
        this.id = id;
        remplirInfoPatient(id);
    }
    private void remplirInfoPatient(int id) throws SQLException, ClassNotFoundException{
        TablePatient patient = TablePatient.patientWhereID(id);
        labelNom.setText(patient.getNom_pat());
        labelPrenom.setText(patient.getPrenom_pat());
        labelDateNaissance.setText(patient.getDate_nes_pat());
        labelPhone.setText(patient.getNum_tel_pat());
    }
    
    @FXML
    private void getInfoRDV(MouseEvent event) throws SQLException, ClassNotFoundException{
        String date, heur, info;
        int idMed;
        date = dateRDV.getValue().format(DateTimeFormatter.ISO_DATE);
        heur = ""+spinnerH.getValue()+":"+spinnerM.getValue()+":00";
        idMed = choicBoxDoctor.getSelectionModel().getSelectedItem().getId_med();
        info = infoRDV.getText();
        if(testTime(spinnerH.getValue(),spinnerM.getValue())){
            if(!TableRendezVous.verifierTime(date, heur)){
                TableRendezVous.insertNewRDV(id, date, heur, info);
                TablePatient.updateIdPatient(id,idMed);
                Stage stage = (Stage) closeButton.getScene().getWindow();
                stage.close();
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Warning");
                //alert.setHeaderText("Results:");
                alert.setContentText("Mer7babik chawala bedal lwa9t !!"); 
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Warning");
            //alert.setHeaderText("Results:");
            alert.setContentText("Mankhedmoch f had lwa9t aaaa 7mar !!"); 
            alert.showAndWait();
            
        }
    }
    
    @FXML
    private void cancelBut(MouseEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    boolean testTime(int hr,int min){
        return (hr >= 9 && hr <= 12) || (hr >= 14 && hr <= 16);
        
    }
    
    
}
