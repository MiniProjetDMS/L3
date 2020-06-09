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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLViewPaymentsController implements Initializable {

    @FXML
    private TableView<TableFacture> tablePayments; 
    @FXML
    private TableColumn<TableFacture, String> col_numFacture;
    @FXML
    private TableColumn<TableFacture, String> col_numDent;
    @FXML
    private TableColumn<TableFacture, String> col_Act;
    @FXML
    private TableColumn<TableFacture, String> col_Date;
    @FXML
    private TableColumn<TableFacture, String> col_montant;
    @FXML
    private TableColumn<TableFacture, String> col_Versement;
    @FXML
    private TableColumn<TableFacture, String> col_Reste;
    ObservableList<TableFacture> oblistFacture = FXCollections.observableArrayList();
    
    @FXML
    private Spinner<?> spinnerNumFacture;
    @FXML
    private Spinner<?> spinnerVersement;
    @FXML
    private Label labNomPrenom;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTblesHistoriqueOrdonnance();
    }    
    
    /*
    * Remplir la table Facture
    * 
    */
    void remplirTblesHistoriqueOrdonnance(){         

        try(Connection conn = DBConnector.getConnection();) {            
            ResultSet rs = conn.createStatement().executeQuery("SELECT num_dent,acte,date_consultation,montant,versement,reste FROM anamnese");   
            int i = 0;
            while(rs.next()){
                i++;
                oblistFacture.add(new TableFacture(i,rs.getInt("num_dent"),rs.getString("acte"),rs.getString("date_consultation"),rs.getInt("montant"),rs.getInt("versement"),rs.getInt("reste")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }   
            col_numFacture.setCellValueFactory(new PropertyValueFactory<>("num_facture"));
            col_numDent.setCellValueFactory(new PropertyValueFactory<>("num_dent"));
            col_Act.setCellValueFactory(new PropertyValueFactory<>("acte"));
            col_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
            col_Versement.setCellValueFactory(new PropertyValueFactory<>("versement"));
            col_Reste.setCellValueFactory(new PropertyValueFactory<>("reste"));
            tablePayments.setItems(oblistFacture);      //remplir 1er table Historique Ordonnace      
    }
    
    private int id;

    public void setId(int id) throws SQLException, ClassNotFoundException {
        this.id = id;
        labNomPrenom.setText(TablePatient.patientWhereID(this.id).getNom_pat()+" "+TablePatient.patientWhereID(this.id).getPrenom_pat());
    }
    
}
