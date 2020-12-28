package application;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle {
	Position pos;
	Obstacle() {
		pos = new Position(0, 0);
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public void moveDown() {
		pos.setY(pos.getY() + 50);
	}
	public void animate(AnchorPane container) {
		RotateTransition rotate = new RotateTransition(); 
		rotate.setAxis(Rotate.Z_AXIS);     
        rotate.setByAngle(360);    
        rotate.setCycleCount(Animation.INDEFINITE);  
        rotate.setDuration(Duration.millis(10000));    
        rotate.setNode(container);  //imgViewOfWheelObstacle  
        rotate.play();
	}
}
