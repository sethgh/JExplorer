import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.io.FilenameUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class JEController implements Initializable {
	
	@FXML
	public TextField mainTextField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mainTextField.setText("asd");
		mainTextField.setFocusTraversable(false);
		
		File folder = new File("C:/");
		File[] listOfFiles = folder.listFiles();
		
		int i=0;
		
		for (File f : listOfFiles) {
			String fileName = f.getName();
			System.out.println(fileName);
			if (f.isDirectory()) {
				i++;
				FileLabel label = new FileLabel();
			} else {
				i++;
				System.out.println(FilenameUtils.getExtension(fileName.toString()));
			}
		}
		
		System.out.println(i);
		
	}

}
