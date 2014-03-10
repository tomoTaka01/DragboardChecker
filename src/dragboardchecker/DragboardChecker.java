package dragboardchecker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Dragboard Checker main
 * 
 * @author tomo
 */
public class DragboardChecker extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DragboardChecker.fxml"));        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setTitle("Dragboard Checker Sample");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
