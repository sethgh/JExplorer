import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ExplorerPane extends VBox {
	
	public int labelPositionY = 28;
	public int labelPositionX = 0;
	public double preferredWidth = 810;
	public double preferredHeight = 610;
	public String currentDirectory;
	
	public TextField addressBar;
	public ArrayList<FileLabel> paneContent;
	
	public ExplorerPane() {
		this.setStyle("-fx-background-color:white;");
		this.setLayoutY(0);
		this.setLayoutX(0);
		this.setPrefHeight(preferredHeight);
		this.setPrefWidth(preferredWidth);
		
		try {
			this.addressBar = new TextField();
			this.addressBar.setPrefWidth(preferredWidth);
			this.addressBar.setFocusTraversable(false);
			this.addressBar.setStyle("-fx-display-caret: false; -fx-focus-color: red;");
			this.getChildren().add(addressBar);
		} catch (Exception e) {}
	}
	
	public void launchPane(String directory) {
		
		directory=directory.toLowerCase();
		paneContent = new ArrayList<FileLabel>();
		currentDirectory = directory;
		this.addressBar.setText(directory);
		paneContent.add(new FileLabel());
		
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		for (File f : listOfFiles) {
			String fileName = f.getName();
			System.out.println(fileName);
			if (f.isDirectory()) {
				paneContent.add(new FileLabel(fileName));
			} else {
				paneContent.add(new FileLabel(fileName, FilenameUtils.getExtension(fileName)));
				System.out.println(FilenameUtils.getExtension(fileName.toString()));
			}
		}
		
		for (FileLabel fl : paneContent) {
			fl.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				    new EventHandler<MouseEvent>() {
				        @Override public void handle(MouseEvent e) {
				            fl.setStyle("-fx-background-color:aliceblue; -fx-focus-color: red;");
				        }
				});
			fl.addEventHandler(MouseEvent.MOUSE_EXITED, 
				    new EventHandler<MouseEvent>() {
				        @Override public void handle(MouseEvent e) {
				            fl.setStyle("-fx-background-color:white; -fx-focus-color: white;");
				        }
				});
		    fl.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2) {
		            fl.onDoubleClick();
		        }
		    });
			fl.setLayoutY(labelPositionY);
			labelPositionY+=28;
			fl.setLayoutX(labelPositionX);
			fl.setPrefHeight(28);
			fl.setPrefWidth(preferredWidth-labelPositionX);
			fl.setFocusTraversable(true);
			fl.setStyle("-fx-background-color:white;");
			this.getChildren().add(fl);
		}
	}
	
	public void goTo(String directory) {
		labelPositionY=28;
		this.getChildren().removeIf(n -> n instanceof FileLabel);
		directory=directory.toLowerCase();
		currentDirectory = directory;
		this.addressBar.setText(directory);
		paneContent = new ArrayList<FileLabel>();
		paneContent.add(new FileLabel());
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		for (File f : listOfFiles) {
			String fileName = f.getName();
			System.out.println(fileName);
			if (f.isDirectory()) {
				paneContent.add(new FileLabel(fileName));
			} else {
				paneContent.add(new FileLabel(fileName, FilenameUtils.getExtension(fileName)));
				System.out.println(FilenameUtils.getExtension(fileName.toString()));
			}
		}
		for (FileLabel fl : paneContent) {
			fl.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				    new EventHandler<MouseEvent>() {
				        @Override public void handle(MouseEvent e) {
				            fl.setStyle("-fx-background-color:aliceblue; -fx-focus-color: red;");
				        }
				});
			fl.addEventHandler(MouseEvent.MOUSE_EXITED, 
				    new EventHandler<MouseEvent>() {
				        @Override public void handle(MouseEvent e) {
				            fl.setStyle("-fx-background-color:white; -fx-focus-color: white;");
				        }
				});
		    fl.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2) {
		            fl.onDoubleClick();
		        }
		    });
			fl.setLayoutY(labelPositionY);
			labelPositionY+=30;
			fl.setLayoutX(labelPositionX);
			fl.setPrefHeight(28);
			fl.setPrefWidth(preferredWidth-labelPositionX);
			fl.setFocusTraversable(true);
			this.getChildren().add(fl);
		}
	}
	
}
