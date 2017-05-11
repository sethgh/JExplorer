import javafx.scene.control.Label;

public class FileLabel extends Label {

	public int paneID;
	public int actionID;
	public int isDirectory;
	public String fileName;
	public String fileExtension;
	
	public int viewType;
	
	LabelIcon icon;
	
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
	
	public FileLabel() {
		this.actionID = 0;
		this.setText("..");
		this.setGraphic(new LabelIcon(0, true, 24, 24));
	}
	
	public FileLabel(String fileName) {
		this.actionID=1;
		this.isDirectory = 1;
		this.fileName = fileName;
		this.setText(this.fileName);
		this.setGraphic(new LabelIcon(1, true, 24, 24));
	}
	
	public FileLabel(String fileName, String fileExtension) {
		fileExtension = fileExtension.toLowerCase();
		this.actionID=2;
		this.isDirectory = 0;
		this.fileName = fileName;
		this.setText(this.fileName);
		this.fileExtension = fileExtension;
		
    	switch (fileExtension) {
    	case "txt":
    		break;
    	case "exe":
    		break;
    	case "doc":
    	case "docx":
    	case "rtf":
    		this.setGraphic(new LabelIcon(5, true, 24, 24));
    		break;
    	case "pdf":
    		break;
    	case "jpg":
    	case "jpeg":
    	case "png":
    	case "bmp":
    	case "gif":
    		this.setGraphic(new LabelIcon(6, true, 24, 24));
    		break;
    	case "mp3":
    	case "flac":
    		break;
    	case "mp4":
    	case "mkv":
    	case "webm":
    	case "avi":
    		break;
    	default:
    		this.setGraphic(new LabelIcon(999, true, 24, 24));
    		break;
    	}
	}
	
	public void onDoubleClick() {
		String currentDirectory = JEController.pane1.currentDirectory;
		String newDirectory="";
		switch(this.actionID) {
		case 0:
			String[] temp_str_array = currentDirectory.split("/|\\\\");
			if (temp_str_array.length<2) {
			} else {
				for (int i=0; i<(temp_str_array.length-1);i++) {
					newDirectory = newDirectory+temp_str_array[i]+"\\";
				}
				JEController.pane1.goTo(newDirectory);
			}
			break;
		case 1:
			newDirectory = currentDirectory+"\\"+this.fileName;
			JEController.pane1.goTo(newDirectory);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			break;
		}
	}
	
}
