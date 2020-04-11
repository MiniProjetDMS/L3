
package mini_projet;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangePage {
    public ChangePage(String page)throws IOException{
        Parent home;
        home = FXMLLoader.load(getClass().getResource(page));
        Scene homeScene;
        homeScene = new Scene(home);
        Stage app_stage;
        //app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setScene(homeScene);
        //app_stage.show();
    }
    
    
    
}
