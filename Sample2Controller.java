package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;


public class Sample2Controller implements Initializable {
	
	Ball ball;
	private DatTab data;
	
	@FXML
	Circle circle;
	
	@FXML
	Label scoreLabel;
	
	static   RotateTransition rotateTriangle; 
	  static  RotateTransition rotateRhombus;  
	  static   RotateTransition rotateSquare;
       
	  static RotateTransition rotateLineObs;  
       
	
	@FXML
	Line pinkLineOfLineObs;
	@FXML
	Line purpleLineOfLineObs;
	@FXML
	Line yellowLineOfLineObs;
	@FXML
	Line blueLineOfLineObs;
	@FXML
	AnchorPane containerOfLineObs;
	
	@FXML
	Line pinkLineOfTriangle;
	@FXML
	Line purpleLineOfTriangle;
	@FXML
	Line yellowLineOfTriangle;
	@FXML
	AnchorPane containerOfTriangle;
	
	
	@FXML
	Line pinkLineOfSquare;
	@FXML
	Line purpleLineOfSquare;
	@FXML
	Line yellowLineOfSquare;
	@FXML
	Line blueLineOfSquare;
	@FXML
	AnchorPane containerOfSquare;
	
	@FXML
	Line pinkLineOfRhombus;
	@FXML
	Line purpleLineOfRhombus;
	@FXML
	Line yellowLineOfRhombus;
	@FXML
	Line blueLineOfRhombus;
	@FXML
	AnchorPane containerOfRhombus;
	

	
	@FXML
	Rectangle rect;
	@FXML
	private Button jumpBtn;
	@FXML
	private Button pauseBtn;
	/*
	@FXML
	ImageView imgViewOfWheelObstacle;
	@FXML
	ImageView imgViewOfSquareObstacle;
	@FXML
	ImageView imgViewOfTringleObstacle;
	@FXML
	ImageView imgViewOfRhombusObstacle;
	*/
	
	@FXML
	AnchorPane containerOfChanger;
	@FXML
	ImageView imgViewOfChanger;
	
	
	@FXML
	ImageView imgViewOfStarOfTriangle;
	@FXML
	ImageView imgViewOfStarOfSquare;
	@FXML
	ImageView imgViewOfStarOfRhombus;
	/*
	@FXML
	ImageView imgViewOfColorChanger;
	*/
	@FXML
	public void jumpBtnClicked() {     
	    		
	}
	@FXML
	public void pauseBtnClicked() {
		System.out.println("game paused");
		
          
                    Game.timelineForStar.pause();
                    Game.timelineForGravity.pause();
                    Game.timelineForCollision.pause();

                    rotateSquare.pause();     
                    rotateTriangle.pause();
                    rotateRhombus.pause();
                    rotateLineObs.pause();
                
	
	}	@FXML
	public void ResumeBtnClicked() {
		System.out.println("game d");
		
          
                    Game.timelineForStar.play();
                    Game.timelineForGravity.play();
                    Game.timelineForCollision.play();
                    
     rotateSquare.play();     
     rotateTriangle.play();
     rotateRhombus.play();
     rotateLineObs.play();
	}
	@FXML
	public void ExitBtnClicked() {
	      System.exit(0);
	
	}
	@FXML
	
		public void MainBtnClicked()
		{ 
		
		System.out.println( "Main page!" );
		  Main.primary.close();
		  Platform.runLater( () -> new Main().start( new Stage() ) );
	
		
		}
	
	@FXML
	public void SaveBtnClicked() throws IOException
	{ Game.timelineForStar.pause();
    Game.timelineForGravity.pause();
    Game.timelineForCollision.pause();
   
		int a1=Main.currentRunningGame.score;
	double a2=Main.currentRunningGame.circle.getLayoutY();
	double a3=Main.currentRunningGame.containerOfRhombus.getLayoutY();
	double a4=Main.currentRunningGame.containerOfSquare.getLayoutY();
	double a5=Main.currentRunningGame.containerOfTriangle.getLayoutY();
	int gk=Game.indOfComingContainer;
	float angle=Game.arrLstOfContainers.get(gk).rotateProperty().floatValue();
	double gz=Game.getComingContainer().getLayoutY();
System.out.println(gk+"  wgskf   "+  gz);		
			if(Main.getDatabase().getdatafiles().size()>10)
        Main.getDatabase().getdatafiles().remove(0);
			 
			int rg1=0,rg2=0,rg3=0;
		    if(Game.circle.getFill().equals(Game.pinkColor))
		    {rg1=252;rg2=34;rg3=131;}
		  
		    else if(Game.circle.getFill().equals(Game.purpleColor))
		    
		    {rg1=150;rg2=45;rg3=252;}
		    
		    else if(Game.circle.getFill().equals(Game.yellowColor))
		    {rg1=252;rg2=216;rg3=8;}
		    else
		    
		    	{rg1=252;rg2=34;rg3=131;}
		    	  

	DatTab data=new DatTab();
		data.update(a1,a2,a3,a4,a5,gk,gz,rg1,rg2,rg3,angle);
	      data.saveGame();

          rotateSquare.pause();     
          rotateTriangle.pause();
          rotateRhombus.pause();
          rotateLineObs.pause();
         
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Game.arrLstOfContainers.clear();
		rotateTriangle = new RotateTransition();  
	     rotateRhombus = new RotateTransition();  
	     rotateSquare = new RotateTransition();  
       
	 rotateLineObs = new RotateTransition();  
       
		
		Game.arrLstOfContainers.add(containerOfSquare);
		
		Game.arrLstOfContainers.add(containerOfChanger);
		Game.arrLstOfContainers.add(containerOfRhombus);
		Game.arrLstOfContainers.add(containerOfChanger);
		Game.arrLstOfContainers.add(containerOfLineObs);
		Game.arrLstOfContainers.add(containerOfChanger);
		//Game.arrLstOfContainers.add(containerOfTriangle);
		System.out.println("JJGFdf");
	   System.out.println(containerOfSquare.hashCode()+"ienroFSquarehash");
		System.out.println(Game.arrLstOfContainers.size());
		Game.setComingContainer(Game.arrLstOfContainers.get(0));
		System.out.println("chk1");
		
		
		containerOfTriangle.setLayoutY(-containerOfTriangle.getPrefHeight()- 120);
		containerOfTriangle.setLayoutX(447);
		containerOfSquare.setLayoutY(-containerOfSquare.getPrefHeight()- 120);
		containerOfSquare.setLayoutX(513);
		
		containerOfRhombus.setLayoutY(-containerOfRhombus.getPrefHeight()- 120);
		containerOfRhombus.setLayoutX(513);
		
		containerOfLineObs.setLayoutY(-containerOfLineObs.getPrefHeight()- 120);
		containerOfLineObs.setLayoutX(560);
		
		containerOfChanger.setLayoutY(-containerOfChanger.getPrefHeight());
		containerOfChanger.setLayoutX(585);
		
	//	RotateTransition rotateTriangle = new RotateTransition();  
        rotateTriangle.setAxis(Rotate.Z_AXIS);     
        rotateTriangle.setByAngle(360);    
        rotateTriangle.setCycleCount(Animation.INDEFINITE);  
        rotateTriangle.setDuration(Duration.millis(10000));    
        rotateTriangle.setNode(containerOfTriangle);  //imgViewOfWheelObstacle  
        rotateTriangle.play();
        
        
		
      //  RotateTransition rotateSquare = new RotateTransition();  
        rotateSquare.setAxis(Rotate.Z_AXIS);     
        rotateSquare.setByAngle(360);    
        rotateSquare.setCycleCount(Animation.INDEFINITE);  
        rotateSquare.setDuration(Duration.millis(10000));    
        //rotate.setRate(0.0005);
        //rotate.setAutoReverse(true);      // Don't delete this line because this hides the sudden break of rotation   
        rotateSquare.setNode(containerOfSquare);  //imgViewOfWheelObstacle  
        rotateSquare.play();
        
        
       // RotateTransition rotateRhombus = new RotateTransition();  
        rotateRhombus.setAxis(Rotate.Z_AXIS);     
        rotateRhombus.setByAngle(360);    
        rotateRhombus.setCycleCount(Animation.INDEFINITE);  
        rotateRhombus.setDuration(Duration.millis(10000));    
        //rotate.setRate(0.0005);
        //rotate.setAutoReverse(true);      // Don't delete this line because this hides the sudden break of rotation   
        rotateRhombus.setNode(containerOfRhombus);  //imgViewOfWheelObstacle  
        rotateRhombus.play();
        
     //   RotateTransition rotateLineObs = new RotateTransition();  
        rotateLineObs.setAxis(Rotate.Z_AXIS);     
        rotateLineObs.setByAngle(360);    
        rotateLineObs.setCycleCount(Animation.INDEFINITE);  
        rotateLineObs.setDuration(Duration.millis(10000));    
        //rotate.setRate(0.0005);
        //rotate.setAutoReverse(true);      // Don't delete this line because this hides the sudden break of rotation   
        rotateLineObs.setNode(containerOfLineObs);  //imgViewOfWheelObstacle  
        rotateLineObs.play();
	}
	
	
}
