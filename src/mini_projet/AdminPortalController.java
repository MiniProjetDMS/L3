package mini_projet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AdminPortalController implements Initializable {

    @FXML
    private Pane paneStatistique;
    @FXML
    private Pane paneManageDoctor;
    @FXML
    private Pane paneManageReceptionist;
    @FXML
    private TableView<TableReceptionicte> table; //*** 1er table
    @FXML
    private TableColumn<TableReceptionicte, String> cNom;
    @FXML
    private TableColumn<TableReceptionicte, String> cPrenom;
    @FXML
    private TableColumn<TableReceptionicte, String> cNee;
    @FXML
    private TableColumn<TableReceptionicte, String> cID;
    @FXML
    private TableColumn<TableReceptionicte, String> cAdress;
    @FXML
    private TableColumn<TableReceptionicte, String> cPhone;
    
    ObservableList<TableReceptionicte> oblist1 = FXCollections.observableArrayList();
    
    @FXML
    private TextField idname;
    @FXML
    private TextField idFname;   
    @FXML
    private TextField textID;
    @FXML
    private TextField textNomDoc;
    @FXML
    private TextField textPrenomDoc;
    @FXML
    private DatePicker dat1;
    @FXML
    private TableView<TableDoctor> table1;//*** 2eme table
    @FXML
    private TableColumn<TableDoctor, String> cID_doctor;
    @FXML
    private TableColumn<TableDoctor, String> cNom_doctor;
    @FXML
    private TableColumn<TableDoctor, String> cPrenom_doctor;
    @FXML
    private TableColumn<TableDoctor, String> cNee_doctor;
    @FXML
    private TableColumn<TableDoctor, String> cNumTlf_doctor;
    @FXML
    private TableColumn<TableDoctor, String> cAdres_doctor;
    
    ObservableList<TableDoctor> oblist2 = FXCollections.observableArrayList();
    
    @FXML
    private TextField textID1;
    @FXML
    private TextField textNumberDoc;
    @FXML
    private TextField textAddressDoc;
    @FXML
    private RadioButton RadioBtnDoc_M;
    @FXML
    private RadioButton RadioBtnDoc_F;
    @FXML
    private PasswordField passwordDoc;
    @FXML
    private TextField textLoginDoc;  
    @FXML
    private TextField textFieldNom_rescep;
    @FXML
    private TextField textFieldPrenom_rescep;
    @FXML
    private DatePicker datePicker_recep;
    @FXML
    private TextField textFieldPhone_rescep;
    @FXML
    private TextField textFieldAdress_rescep;
    @FXML
    private RadioButton radioButtonMal_recep;
    @FXML
    private RadioButton radioButtonFem_recep;
    @FXML
    private PasswordField textFieldPassword_rescep;
    @FXML
    private TextField textFieldLogin_rescep;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testCnx();        
    }    
    
    void testCnx(){
        // ##### connection BDD
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            if(conn != null)
                System.out.println("connection BDD Admin controller done !");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ##### 
        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from receptionicte");
            ResultSet rs2 = conn.createStatement().executeQuery("select * from medcin");
            
            while(rs.next()){
                oblist1.add(new TableReceptionicte(rs.getString("id_recep"),rs.getString("nom_recep"),rs.getString("prenom_recep"),rs.getString("date_nes_recep"),rs.getString("adress_recep"),rs.getString("num_tel_recep")));
            }
            while(rs2.next()){
                oblist2.add(new TableDoctor(rs2.getString("id_med"), rs2.getString("nom_med"), rs2.getString("prenom_med"),rs2.getString("date_nes_med"), rs2.getString("adress_med"), rs2.getString("num_tel_med")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPortalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cNom.setCellValueFactory(new PropertyValueFactory<>("nom_recep"));
        cPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom_recep"));
        cNee.setCellValueFactory(new PropertyValueFactory<>("date_nes_recep"));
        cID.setCellValueFactory(new PropertyValueFactory<>("id_recep"));
        cAdress.setCellValueFactory(new PropertyValueFactory<>("adress_recep"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("num_tel_recep"));
        table.setItems(oblist1);      //remplir 1er table   
        
        cID_doctor.setCellValueFactory(new PropertyValueFactory<>("id_med"));
        cNom_doctor.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
        cPrenom_doctor.setCellValueFactory(new PropertyValueFactory<>("prenom_med"));
        cNee_doctor.setCellValueFactory(new PropertyValueFactory<>("date_nes_med"));
        cNumTlf_doctor.setCellValueFactory(new PropertyValueFactory<>("num_tel_med"));
        cAdres_doctor.setCellValueFactory(new PropertyValueFactory<>("adress_med"));
        table1.setItems(oblist2);     //remplir 2eme table
    }
    
    @FXML
    private void receptionisteFor() throws SQLException{
        String nomR,prenomR,dateR,phoneNR,adressR,sexeR = null,passwordR,loginR;
        //String  ID_r= null ;
        String emailR = null;//-------------
        
        nomR = textFieldNom_rescep.getText();
        prenomR = textFieldPrenom_rescep.getText();
        dateR = datePicker_recep.getValue().format(DateTimeFormatter.ISO_DATE);//getPromptText();
        phoneNR = textFieldPhone_rescep.getText();
        adressR = textFieldAdress_rescep.getText();
        if(radioButtonMal_recep.isSelected())
            sexeR = "M";
        if(radioButtonFem_recep.isSelected())
            sexeR = "F";
        passwordR = textFieldPassword_rescep.getText();
        loginR = textFieldLogin_rescep.getText();
        
        Random rand = new Random();
        char c = (char)(rand.nextInt(26) + 97);
        String ID_r = new String();
        ID_r = c+"";
        emailR = "test@mail.dz"; 
        
        TableReceptionicte rpRecep = new TableReceptionicte(ID_r,nomR,prenomR, sexeR, dateR,adressR, phoneNR, loginR, passwordR, emailR);
        rpRecep.insertingReceptioniste();
        testCnx();
    }
    
    @FXML
    private void DoctorFor() throws SQLException{
        String nomD,prenomD,dateD,phoneD,adressD,sexeD = null,passwordD,loginD;
        //String  ID_r= null ;
        String emailD = null;//-------------
        
        nomD = textNomDoc.getText();
        prenomD = textPrenomDoc.getText();
        dateD = dat1.getValue().format(DateTimeFormatter.ISO_DATE);//getPromptText();
        phoneD = textNumberDoc.getText();
        adressD = textAddressDoc.getText();
        if(RadioBtnDoc_M.isSelected())
            sexeD = "M";
        if(RadioBtnDoc_F.isSelected())
            sexeD = "F";
        passwordD = passwordDoc.getText();
        loginD = textLoginDoc.getText();
        
        Random rand = new Random();
        char c = (char)(rand.nextInt(26) + 97);
        String textID1 = new String();
        textID1 = c+"";
        emailD = "test1@mail.dz"; 
        
        TableDoctor docDoctor = new TableDoctor(textID1,nomD,prenomD, sexeD, dateD,adressD, phoneD, loginD, passwordD, emailD);
        docDoctor.insertingDoctor();
        testCnx();
    }
    
    
    @FXML
    private void toFrontMR(MouseEvent event) {
        paneManageReceptionist.toFront();
    }

    @FXML
    private void toFrontMD(MouseEvent event) {
        paneManageDoctor.toFront();
    }

    @FXML
    private void toFrontStatistique(MouseEvent event) {
        paneStatistique.toFront();
    }

    @FXML
    private void exitA(MouseEvent event) throws IOException {
        Parent home;
        home = FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();
    }

   /* private void fonctionMessage(MouseEvent event) {
        labMessage.setText(textF.getText());
    }*/

    @FXML
    private void Add(MouseEvent event) {
   
    }

    /*@FXML
    private void Del(MouseEvent event) {
           labMsg.setText("...");
    }*/

    @FXML
    private void Del(MouseEvent event) {
    }

    @FXML
    private void printTest(MouseEvent event) throws SQLException {// button add :: Fonction test Receptionist
        receptionisteFor();
    }
    
    @FXML
    private void printDoc(MouseEvent event) throws SQLException {// button add :: Fonction test Doctor
        DoctorFor();
    }
    
}
