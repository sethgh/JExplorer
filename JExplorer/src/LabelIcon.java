import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LabelIcon extends ImageView {
	
	public double iconWidth;
	public double iconHeight;
	
	public LabelIcon() {
		
	}
	
	public LabelIcon(int iconID, boolean overridesDefaultDimensions, double iconWidth, double iconHeight) {
		if (overridesDefaultDimensions) {
			this.setFitHeight(iconWidth);
			this.setFitWidth(iconHeight);
		}
		switch(iconID) {
		case 0:
			this.setImage(new Image(getClass().getResourceAsStream("icon-up-directory.png")));
			break;
		case 1:
			this.setImage(new Image(getClass().getResourceAsStream("icon-directory.png")));
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			this.setImage(new Image(getClass().getResourceAsStream("docicon.png")));
			break;
		case 6:
			this.setImage(new Image(getClass().getResourceAsStream("icon-img.png")));
			break;
		case 7:
			break;
		case 8:
			break;
		default:
			this.setImage(new Image(getClass().getResourceAsStream("icon-generic.png")));
			break;
		}
	}

}
