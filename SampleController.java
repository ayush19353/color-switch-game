package application;







import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SampleController implements Initializable {
	@FXML
	private AnchorPane root1;
	@FXML
	private Button newGameBtn;
	@FXML
	private Button loadSavedGameBtn;
	@FXML
	private ImageView imageViewOfLogo;
	@FXML
	private ImageView imageViewOfLogoName;
	@FXML 
	public void newGameBtnClicked()  {
		System.out.println("newGame");
		if(Main.currentRunningGame!=null)
			Main.currentRunningGame.close();
		Game game = new Game();
		game.run();
	}
	@FXML
	public void exitBtnClicked() {
		System.exit(0);
	}
	@FXML
	public void loadSavedGameBtnClicked() throws IOException,ClassNotFoundException, IOException {
		
		System.out.println("load Saved Game");
		Parent root = FXMLLoader.load(getClass().getResource("a.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//scene.setFill(Color.rgb(38,42,41));
		//SampleController.rotateLogo();
		Main.primary3.setScene(scene);
	Main.primary3.setTitle("soss");
	Main.primary3.setMaximized(false);
		Main.primary3.setMaximized(true);
		
		System.out.println("up1");
		Main.primary3.show();
	
		
		
	}
	/*
	@FXML
	public void rotateLogo(ActionEvent e) {
		System.out.println("rotateLogo");
		/*
		 RotateTransition rotate = new RotateTransition();  
         
	        //Setting Axis of rotation   
	        rotate.setAxis(Rotate.Z_AXIS);  
	          
	        // setting the angle of rotation   
	        rotate.setByAngle(360);  
	          
	        //setting cycle count of the rotation   
	        rotate.setCycleCount(500);  
	          
	        //Setting duration of the transition   
	        rotate.setDuration(Duration.millis(1000));  
	          
	        //the transition will be auto reversed by setting this to true   
	        rotate.setAutoReverse(true);  
	        rotate.setNode(imageViewOfLogo);  
	          
	        //playing the transition   
	        rotate.play();
		////////////
	}*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("hello of initialization");
		RotateTransition rotate = new RotateTransition();  
        rotate.setAxis(Rotate.Z_AXIS);     
        rotate.setByAngle(720);    
        rotate.setCycleCount(Animation.INDEFINITE);  
        rotate.setDuration(Duration.millis(2000));    
        //rotate.setRate(0.0005);
        rotate.setAutoReverse(true);      // Don't delete this line because this hides the sudden break of rotation   
        rotate.setNode(imageViewOfLogo);  
        rotate.play();
	}
}
