import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JExplorer extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        	Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("stylesheet.css");
            primaryStage.setScene(scene);
    	} catch (Exception e) {
    		
    	}
    	
        primaryStage.setTitle("Hello World!");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
