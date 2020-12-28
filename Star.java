package application;

import javafx.scene.image.ImageView;

public class Star {
	private ImageView image;
	private Position pos;       // getX() function exists
	Star(ImageView x) {
		image = x;
	}
	public Position getPos() {
		return pos;
	}
	public ImageView getImage() {
		return image;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public void setImage(ImageView image) {
		this.image = image;
	}
	public void moveDown() {
		pos.setY(pos.getY() + 50);
	}
}
