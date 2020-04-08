/*
 * 
 */
package mini_projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Nadir
 */
public class Mini_Projet extends Application {
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginAs.fxml"));
        
        Scene scene = new Scene(root);
        
        
        
        stage.setScene(scene);
        
        System.out.println("Root :::: "+getClass().getDeclaredMethods().toString());
        stage.initStyle(StageStyle.UNDECORATED); 
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
    public static void main(String[] args) {
        launch(args);
    }
    
}
