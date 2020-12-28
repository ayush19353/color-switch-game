package application;

import javafx.scene.image.ImageView;

public class ColorChanger {
	private Position pos;
	private ImageView image;
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
	ColorChanger(ImageView x, Position y) {
		image = x;
		pos = y;
	}
}
