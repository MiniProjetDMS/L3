package mini_projet.portal;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mini_projet.Connexion;
import static mini_projet.Connexion.ConnecterDB;

public class AdminPortalController implements Initializable {

    @FXML
    private Pane paneStatistique;
    @FXML
    private Pane paneManageDoctor;
    @FXML
    private Pane paneManageReceptionist;
    private TextField textF;
    private Label labMessage;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;
    @FXML
    private DatePicker dat;
    private Label labMsg;
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> cNom;
    @FXML
    private TableColumn<ModelTable, String> cPrenom;
    @FXML
    private TableColumn<ModelTable,String> cNee;
    @FXML
    private TableColumn<ModelTable, String> cId;
    @FXML
    private TableColumn<ModelTable, String> cAdress;
    @FXML
    private TableColumn<ModelTable, String> cPhone;
    @FXML
    private TextField idname;
    @FXML
    private TextField idFname;
   
    @FXML
    private TextField textID;
    @FXML
    private TextField textNumber;
    @FXML
    private TextField textNom11;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private PasswordField password;
    @FXML
    private TextField textLogin;
    @FXML
    private TextField textNom1;
    @FXML
    private TextField textPrenom1;
    @FXML
    private DatePicker dat1;
    @FXML
    private TableView<?> table1;//***
    @FXML
    private TableColumn<?, ?> cPrenom1;
    @FXML
    private TableColumn<?, ?> cNee1;
    @FXML
    private TableColumn<?, ?> cNom11;
    @FXML
    private TableColumn<?, ?> cNom21;
    @FXML
    private TableColumn<?, ?> cNom31;
    @FXML
    private TextField textID1;
    @FXML
    private TextField textNumber1;
    @FXML
    private TextField textNom111;
    @FXML
    private RadioButton male1;
    @FXML
    private RadioButton female1;
    @FXML
    private PasswordField password1;
    @FXML
    private TextField textLogin1;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    ObservableList<ModelTable> oblist= FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        
        try{
              Connection conn=Connexion.ConnecterDB(); 
             Statement st=conn.createStatement();
            ResultSet rst=st.executeQuery("SELECT * FROM receptionicte");
              
              while(rst.next()){
                  oblist.add(new ModelTable(rst.getString("id_recep"),rst.getString("nom_recep"),rst.getString("prenom_recep"),rst.getString("num_tel_recep"),rst.getString("adress_recep"),rst.getString("date_nes_recep")));
              }
          }catch(Exception ex){
              System.out.println("Erreur :: "+ ex.getMessage());//********************************** wah tji tem!! are you alive , I don't think so
          } 
        cNom.setCellValueFactory(new PropertyValueFactory<>("nom_recep"));
        cPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom_recep"));
        cAdress.setCellValueFactory(new PropertyValueFactory<>("adress_recep"));
        //cId.setCellValueFactory(new PropertyValueFactory<>("id_recep"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("num_tel_recep"));
        cNee.setCellValueFactory(new PropertyValueFactory<>("date_nes_recep"));
    
    table.setItems(oblist);
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
        home = FXMLLoader.load(getClass().getResource("/mini_projet/LoginAdmin.fxml"));//hna mazal makmalt :'(
        Scene homeScene = new Scene(home);
        Stage app_stage;
        app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homeScene);
        app_stage.resizableProperty().set(false);
        app_stage.show();
    }

    private void fonctionMessage(MouseEvent event) {
        labMessage.setText(textF.getText());// cnx mchat w jat ok aaaa hadik bach ya3etik les suggestion ta3e les méthodes dir ctrl+espace ok N?a3rafha zidha fi rohak
    }// la ghi nza3a9 ok zedtha f raci w 7asit raci smant hhhhhhhhhhhhh hh

    @FXML
    private void Add(MouseEvent event) {
        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String date = dat.getValue().toString(); // hadi rani nasiha 
        String msg = "nom :"+nom + " prenom :"+ prenom + " Née :"+ date; 
        //labMsg.setText(msg);// ta7ssab ni nshouf f  tuto.. dertlak pause
        // raha kayn erreur f 191 hada lblmsg ghi gal3ah, dak label li zedtah bash yafficher msg, ana gla3tah ghi m scenebuilder
        /*cNom.setText(nom);
        cPrenom.setText(prenom);
        cNee.setText(date);//ya rabi ya rabi ya rabi hhhhhhhhhhhhhhh */
        
        
    }

    @FXML
    private void Del(MouseEvent event) {
           labMsg.setText("...");
    }
    
     
    
}
