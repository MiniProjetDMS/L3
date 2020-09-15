/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.SpinnerValueFactory;
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
    private Spinner<Integer> spinnerVersement = new Spinner<Integer>();
    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 1000, 100);
    @FXML
    private Label labNomPrenom;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerVersement.setValueFactory(valueFactory);
    }    
    
    /*
    * Remplir la table Facture
    * 
    */
    private void remplirTblesFacture(int id_med,int id_pat){     
        
        try(Connection conn = DBConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT num_dent,acte,date_consultation,montant,versement,reste FROM anamnese WHERE id_med = ? AND id_pat = ?");) {
            pstmt.setInt(1, id_med);
            pstmt.setInt(2, id_pat);
            ResultSet rs = pstmt.executeQuery();
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
    
    private int id_pat;
    private int id_med;

    public void setId(int id_med, int id_pat) throws SQLException, ClassNotFoundException { 
        this.id_pat = id_pat;
        this.id_med = id_med;
        labNomPrenom.setText(TablePatient.patientWhereID(this.id_pat).getNom_pat()+" "+TablePatient.patientWhereID(this.id_pat).getPrenom_pat());
        remplirTblesFacture(this.id_med,this.id_pat);
    }
    
    @FXML
    public void updateVersement() throws SQLException, ClassNotFoundException{
        int versement = spinnerVersement.getValue();
        System.out.println("test Spinner = " +versement + "id med pat ::"+id_med +" "+ id_pat);
        TableFacture.setVersement(id_med, id_pat, versement);
        oblistFacture.clear();
        remplirTblesFacture(id_med, id_pat);
    }
    
    
}
