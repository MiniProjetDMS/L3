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
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    private int id_med;
    private int id_pat;
    @FXML
    private Label labObservation;
    @FXML
    private TextField texteFNumDent;
    
    public void setId(int id_med,int id_pat) throws SQLException, ClassNotFoundException{
        this.id_med = id_med;
        this.id_pat = id_pat;
        ficheTechniquePatient(this.id_pat);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        labDateConsultation.setText(dtf.format(now));
        labAuDateCertification.setText(dtf.format(now));
        System.out.println(dtf.format(now)); 
        dateDuCertification.setValue(LocalDate.now());
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
    
    @FXML
    private int getAnamnese() throws SQLException, ClassNotFoundException{
        int num_dent,mont,vers,rest;        
        try {
           num_dent = Integer.parseInt(texteFNumDent.getText());
           mont = Integer.parseInt(texteFMontant.getText());
           vers = Integer.parseInt(texteFVersement.getText());
        }catch (NumberFormatException e){
           num_dent = 0;
           mont = 0;
           vers = 0;
        }
        rest = mont - vers;
        labResteVersement.setText(""+rest+".00 da");
        String act = "acte";//(String) comBoxActe.getValue();
        String obser = TextObservation.getText();
        ResultSet rs = null;
        int anamneseId = 0;
        try(Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `anamnese` (`id_pat`, `id_med`, `num_dent`, `acte`, `montant`, `versement`, `reste`, `observation`) VALUES (?,?,?,?,?,?,?,?);");) {
            pstmt.setInt(1, id_pat);
            pstmt.setInt(2, id_med);
            pstmt.setInt(3, num_dent);
            pstmt.setString(4, act);
            pstmt.setInt(5, mont);
            pstmt.setInt(6, vers);
            pstmt.setInt(7, rest);
            pstmt.setString(8, obser);
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    anamneseId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return anamneseId;
    }
    
}
