import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.commons.io.FilenameUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class JEController implements Initializable {
	
	public static ExplorerPane pane1;
	public ArrayList<FileLabel> pane1Content = new ArrayList<FileLabel>();
	
	@FXML
	public TextField mainTextField;
	
	@FXML
	public ScrollPane primaryPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		pane1 = new ExplorerPane();
		primaryPane.setContent(pane1);
		pane1.launchPane("C:/");
		
	}

}
