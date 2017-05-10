import javafx.scene.control.Label;

public class FileLabel extends Label {

	public int isDirectory;
	
	public String labelName;
	
	public String fileExtension;
	
	public enum typeOfFile {
		DIRECTORY, 
		TXT, 
		DOC, 
		DOCX,
		PNG,
		JPG,
		GIF,
		MP3,
		FLAC
	};
	
	public FileLabel() {}
	
	public FileLabel(int isDirectory, String labelName, String fileExtension) {
		this.isDirectory = isDirectory;
		this.labelName = labelName;
		this.fileExtension = fileExtension;
		
    	switch (fileExtension) {
    	case "jpeg":
    	case "gif":
    	case "bmp":
    	case "png":
    		//pane1.getChildren().add(new ExplorerLabel(2, listOfFiles[i].getName()));
    		break;
    	case "txt":
    	case "doc":
    	case "pdf":
    		//pane1.getChildren().add(new ExplorerLabel(6, listOfFiles[i].getName()));
    		break;
    	default:
    		//pane1.getChildren().add(new ExplorerLabel(10, listOfFiles[i].getName()));
    		break;
    	}
		
	}
	
}
