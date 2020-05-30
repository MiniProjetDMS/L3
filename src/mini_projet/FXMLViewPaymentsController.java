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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLViewPaymentsController implements Initializable {

    @FXML
    private TableView<?> tablePayments;
    @FXML
    private TableColumn<?, ?> col_numFacture;
    @FXML
    private TableColumn<?, ?> col_numDent;
    @FXML
    private TableColumn<?, ?> col_Act;
    @FXML
    private TableColumn<?, ?> col_montant;
    @FXML
    private TableColumn<?, ?> col_Versement;
    @FXML
    private TableColumn<?, ?> col_Reste;
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
        // TODO
    }    
    
}
