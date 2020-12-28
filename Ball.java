package application;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball {          // When I wrote circle. on eclipse, I found getCenterX() method.
	private Position pos;
	private double distTravelledInOneJump;
	private Circle circle;
	public Position getPos() {
		return pos;
	}
	public Circle getCircle() {
		return circle;
	}
	public double getDistTravelledInOneJump() {
		return distTravelledInOneJump;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public void setDistTravelledInOneJump(double dist) {
		this.distTravelledInOneJump = dist;
	}
	public void moveUp() {
		pos.setY(pos.getY() - 50);
	}
	public void moveDown() {
		pos.setY(pos.getY() + 50);
	}
	public void changeColor(Paint color) {
		circle.setFill(color);
	}
	Ball(Circle x, Position y, double z) {
		circle = x;
		pos = y;
		distTravelledInOneJump = z;	
	}
}