package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RhombusObstacle extends Obstacle{
	private ArrayList<Line> lineSegs;        // getX() function exists
	RhombusObstacle(ArrayList<Line> x) {
		lineSegs = x;
	}
	public ArrayList<Line> getLineSegs() {
		return lineSegs;
	}
	public void setLineSegs(ArrayList<Line> x) {
		this.lineSegs = x;
	}
	public void moveDown() {
		pos.setY(pos.getY() + 50);
	}
	@Override
	public void animate(AnchorPane container) {
		RotateTransition rotate = new RotateTransition(); 
		rotate.setAxis(Rotate.Z_AXIS);     
        rotate.setByAngle(360);    
        rotate.setCycleCount(Animation.INDEFINITE);  
        rotate.setDuration(Duration.millis(10000));    
        rotate.setNode(container);  
        rotate.play();
	}
}
