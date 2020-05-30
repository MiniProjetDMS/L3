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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.HTMLEditor;

/**
 * FXML Controller class
 *
 * @author Nadir
 */
public class FXMLNewConsultationController implements Initializable {

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
    private Label labDateConsultation;
    @FXML
    private ComboBox<?> comBoxActe;
    @FXML
    private TextField texteFMontant;
    @FXML
    private TextField labNumDent;
    @FXML
    private TextField texteFVersement;
    @FXML
    private TextArea TextObservation;
    @FXML
    private Label labResteVersement;
    @FXML
    private TableView<?> tableOrdonnance;
    @FXML
    private TableColumn<?, ?> col_Num_medicament;
    @FXML
    private TableColumn<?, ?> col_medicament;
    @FXML
    private TableColumn<?, ?> col;
    @FXML
    private TableColumn<?, ?> colPostagie;
    @FXML
    private TableColumn<?, ?> col_quentite;
    @FXML
    private TextField TexteFMedicament;
    @FXML
    private TextField TexteFDosage;
    @FXML
    private TextField TexteFQuentite;
    @FXML
    private TextField TexteFPostage;
    @FXML
    private HTMLEditor htmlLetre;
    @FXML
    private DatePicker dateDuCertification;
    @FXML
    private TextField TexteNombreDuJours;
    @FXML
    private Label labAuDateCertification;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
