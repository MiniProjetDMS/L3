/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLPatientRecordController implements Initializable {

    @FXML
    private TableView<?> tableHistoriqueAnamnese;
    @FXML
    private TableColumn<?, ?> col8numDent;
    @FXML
    private TableColumn<?, ?> col_Acte;
    @FXML
    private TableColumn<?, ?> col_Date;
    @FXML
    private TableColumn<?, ?> col_Observation;
    @FXML
    private TableView<?> tableHistoriqueOrdonance;
    @FXML
    private TableColumn<?, ?> col_DateOrdonnance;
    @FXML
    private TableColumn<?, ?> col_medicament1;
    @FXML
    private TableColumn<?, ?> col_medicament2;
    @FXML
    private TableColumn<?, ?> col_medicament3;
    @FXML
    private TableColumn<?, ?> col_medicament4;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
