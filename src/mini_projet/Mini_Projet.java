package mini_projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mini_Projet extends Application {
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginAs.fxml"));
        
        Scene scene = new Scene(root);   
        
        stage.setScene(scene);
        stage.resizableProperty().set(false);
        //stage.initStyle(StageStyle.UNDECORATED); 
        //pour ue bar d'etat transparance
	//grab your root here
	root.setOnMousePressed((MouseEvent event) -> {
		xOffset = event.getSceneX();
		yOffset = event.getSceneY();
	});

	//move around here
	root.setOnMouseDragged((MouseEvent event) -> {
		stage.setX(event.getScreenX() - xOffset);
		stage.setY(event.getScreenY() - yOffset);
	});
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/clinique_dentaire";
            String user      = "root";
            String password  = "";
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            //****
            if(conn != null)
                System.out.println("cnx Done !!");
            // for testing :
            Statement stmt=conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from medcin");  
            while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            // ...
	
        } catch(SQLException e) {
           System.out.println("dommage erreur ::"+e.getMessage());
        } 
        
        launch(args);
        
    }
    
}
