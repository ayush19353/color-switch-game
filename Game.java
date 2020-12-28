package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;



public class Game {
	private Ball ball;
	private ArrayList<Obstacle> obstaclesOnScreen;
	private ArrayList<Double> xCoordinatesOfObstacles;
	private ArrayList<Double> yCoordinatesOfObstacles;
	private ArrayList<Star> starsOnScreen;
	private ArrayList<Double> xCoordinatesOfStars;
	private ArrayList<Double> yCoordinatesOfStars;
	private ArrayList<ColorChanger> colorChangers;
	private ArrayList<Double> xCoordinatesOfColorChangers;
	private ArrayList<Double> yCoordinatesOfColorChangers;
	
	
	static Circle circle;static int st;
	static int totalscore;
	static Line pinkLineOfTriangle;
	static Line purpleLineOfTriangle;
	static Line yellowLineOfTriangle;
	static AnchorPane containerOfTriangle;
 static Timeline timelineForStar;
static  Timeline timelineForGravity;
	static  Timeline timelineForCollision;
	static Line pinkLineOfSquare;
	static Line purpleLineOfSquare;
	static Line yellowLineOfSquare;
	static Line blueLineOfSquare;
	static AnchorPane containerOfSquare;
	static double fine;
	static Line pinkLineOfRhombus;
	static Line purpleLineOfRhombus;
	static Line yellowLineOfRhombus;
	static Line blueLineOfRhombus;
	static AnchorPane containerOfRhombus;
	static Paint col;
	static int rg1,rg2,rg3;
	static Line pinkLineOfLineObs;
	static Line purpleLineOfLineObs;
	static Line yellowLineOfLineObs;
	static Line blueLineOfLineObs;
	static AnchorPane containerOfLineObs;
	
	static AnchorPane containerOfChanger;
	static ImageView imgViewOfChanger;
	
	static ImageView imgViewOfStarOfSquare;
	static ImageView imgViewOfStarOfRhombus;
	static ImageView imgViewOfStarOfTriangle;
	//static Button ScoreBtn;static Button TotalScoreBtn;
	static Button pausee;

	@FXML
	static AnchorPane arc;
private	static Scene scene;
	static int indOfComingContainer;
	private static AnchorPane comingContainer;
	static ArrayList<AnchorPane> arrLstOfContainers = new ArrayList<AnchorPane>();
	static Button h;
	static double yof;//y of contine for container
	static int score;
	static Label scoreLabel;
	static Button ScoreBtn,TotalScoreBtn;
	static boolean circleJumpedOnce;
	static ArrayList<Color> arrLstOfColor = new ArrayList();
	static int curColorInd;
	static Button pauseBtn;
	public static Parent root=null;
	private static  AnchorPane fz;
	static Color pinkColor;static Color purpleColor;static Color yellowColor;
private static int index;
	//static Rectangle rect;

	public int getScore() {
		return score;
	}
	public Ball getBall() {
		return ball;
	}
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	public ArrayList<Obstacle> getObstaclesOnScreen() {
		return obstaclesOnScreen;
	}
	public ArrayList<Double> getXCoordinatesOfObstacles() {
		return xCoordinatesOfObstacles;
	}
	public ArrayList<Double> getYCoordinatesOfObstacles() {
		return yCoordinatesOfObstacles;
	}
	public ArrayList<Star> getStarsOnScreen() {
		return starsOnScreen;
	}
	public ArrayList<Double> getXCoordinatesOfStars() {
		return xCoordinatesOfStars;
	}
	public ArrayList<Double> getYCoordinatesOfStars() {
		return yCoordinatesOfStars;
	}
	public ArrayList<ColorChanger> getColorChangers() {
		return colorChangers;
	}
	public ArrayList<Double> getXCoordinatesOfColorChangers() {
		return xCoordinatesOfColorChangers;
	}
	public ArrayList<Double> getYCoordinatesOfColorChangers() {
		return yCoordinatesOfColorChangers;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setObstaclesOnScreen(ArrayList<Obstacle> obstaclesOnScreen) {
		this.obstaclesOnScreen = obstaclesOnScreen;
	}
	public void setXCoordinatesOfObstacles(ArrayList<Double> xCoordinatesOfObstacles) {
		this.xCoordinatesOfObstacles = xCoordinatesOfObstacles;
	}
	public void setYCoordinatesOfObstacles(ArrayList<Double> yCoordinatesOfObstacles) {
		this.yCoordinatesOfObstacles = yCoordinatesOfObstacles;
	}
	public void setStarsOnScreen(ArrayList<Star> starsOnScreen) {
		this.starsOnScreen = starsOnScreen;
	}
	public void setXCoordinatesOfStars(ArrayList<Double> xCoordinatesOfStars) {
		this.xCoordinatesOfStars = xCoordinatesOfStars;
	}
	public void setYCoordinatesOfStars(ArrayList<Double> yCoordinatesOfStars) {
		this.yCoordinatesOfStars = yCoordinatesOfStars;
	}
	public void setColorChangers(ArrayList<ColorChanger> colorChangers) {
		this.colorChangers = colorChangers;
	}
	public void getXCoordinatesOfColorChangers(ArrayList<Double> xCoordinatesOfColorChangers) {
		this.xCoordinatesOfColorChangers = xCoordinatesOfColorChangers;
	}
	public void getYCoordinatesOfColorChangers(ArrayList<Double> yCoordinatesOfColorChangers) {
		this.yCoordinatesOfColorChangers = yCoordinatesOfColorChangers;
	}
	public void pause() {
		Game.timelineForStar.pause();
        Game.timelineForGravity.pause();
        Game.timelineForCollision.pause();
	}
	public void resume() {
		Game.timelineForStar.play();
        Game.timelineForGravity.play();
        Game.timelineForCollision.play();
	}
	public void restart() {
		Main.currentRunningGame.close();
		Game game = new Game();
		game.run();
	}
	public void quit() {
		System.exit(0);
	}
	public void save() {
		Game.timelineForStar.pause();
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
	}
	
	public Game() {
		//arrOfContainers 
		comingContainer=new AnchorPane();
		indOfComingContainer = 0;
		score = 0;
		circleJumpedOnce = false;
		 pinkColor = Color.rgb(252, 34, 131);
	 purpleColor = Color.rgb(150, 45, 252);
		 yellowColor = Color.rgb(255, 216, 8);
		arrLstOfColor.add(pinkColor);
		arrLstOfColor.add(purpleColor);
		arrLstOfColor.add(yellowColor);
		curColorInd = 0;
		//h=new Button("Continue");	h.setLayoutY(100);h.prefHeight(35);h.prefWidth(75);
	}
	public void close()
	{timelineForCollision.stop();
	timelineForStar.stop();
	timelineForGravity.stop();}
	public void run1(double g,String g1,int gx, double wq,int hhg, int rg12, int rg22, int rg32, float angl)
	{Main.currentRunningGame=this;
	//Scene scene = null;
	try {	
		
		root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
		arc=(AnchorPane) root.lookup("#arc");
		pinkLineOfTriangle = (Line) root.lookup("#pinkLineOfTriangle");
		purpleLineOfTriangle = (Line) root.lookup("#purpleLineOfTriangle");
		yellowLineOfTriangle = (Line) root.lookup("#yellowLineOfTriangle");
		containerOfTriangle = (AnchorPane) root.lookup("#containerOfTriangle");

		
		pinkLineOfSquare = (Line) root.lookup("#pinkLineOfSquare");
		purpleLineOfSquare = (Line) root.lookup("#purpleLineOfSquare");
		yellowLineOfSquare = (Line) root.lookup("#yellowLineOfSquare");
		blueLineOfSquare = (Line) root.lookup("#blueLineOfSquare");
		containerOfSquare = (AnchorPane) root.lookup("#containerOfSquare");
		
		pinkLineOfRhombus = (Line) root.lookup("#pinkLineOfRhombus");
		purpleLineOfRhombus = (Line) root.lookup("#purpleLineOfRhombus");
		yellowLineOfRhombus = (Line) root.lookup("#yellowLineOfRhombus");
		blueLineOfRhombus = (Line) root.lookup("#blueLineOfRhombus");
		containerOfRhombus = (AnchorPane) root.lookup("#containerOfRhombus");
		
		pinkLineOfLineObs = (Line) root.lookup("#pinkLineOfLineObs");
		purpleLineOfLineObs = (Line) root.lookup("#purpleLineOfLineObs");
		yellowLineOfLineObs = (Line) root.lookup("#yellowLineOfLineObs");
		blueLineOfLineObs = (Line) root.lookup("#blueLineOfLineObs");
		containerOfLineObs = (AnchorPane) root.lookup("#containerOfLineObs");
		
		
		containerOfChanger = (AnchorPane) root.lookup("#containerOfChanger");
		imgViewOfChanger = (ImageView) root.lookup("#imgViewOfChanger");
		
		
		imgViewOfStarOfSquare = (ImageView) root.lookup("#imgViewOfStarOfSquare");
		imgViewOfStarOfRhombus = (ImageView) root.lookup("#imgViewOfStarOfRhombus");
		imgViewOfStarOfTriangle = (ImageView) root.lookup("#imgViewOfStarOfTriangle");
		pauseBtn=(Button) root.lookup("#pauseBtn");
		scoreLabel = (Label) root.lookup("#scoreLabel");
		Sample2Controller.rotateSquare.setFromAngle(angl);
		Sample2Controller.rotateSquare.playFromStart();
		Sample2Controller.rotateLineObs.setFromAngle(angl);
	Sample2Controller.rotateLineObs.playFromStart();
	Sample2Controller.rotateRhombus.setFromAngle(angl);
		Sample2Controller.rotateRhombus.playFromStart();
	Sample2Controller.rotateTriangle.setFromAngle(angl);
		Sample2Controller.rotateTriangle.playFromStart();
		
		
		System.out.println("scoreL" +scoreLabel);
		Color newone=Color.rgb(rg12,rg22 , rg32);
		circle = (Circle) root.lookup("#circle");
		circle.setFill(newone);
		if(gx==1)
		circle.setLayoutY(g+55);
		else 
			circle.setLayoutY(g);
		System.out.println(Game.arrLstOfContainers.get(hhg)+"   ththth");
		Game.arrLstOfContainers.get(hhg).setLayoutY(wq);
		System.out.println(Game.arrLstOfContainers.get(hhg).hashCode()+"DFKHGK");
		Game.comingContainer=Game.arrLstOfContainers.get(hhg);
		Game.indOfComingContainer=hhg;
		//	circle.setLayoutY(g);
			System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
		//	System.out.println(q);
			System.out.println(wq);
			
			
			
			score=Integer.parseInt(g1);
		scoreLabel.setText(g1);
		setScene(new Scene(root));

		getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//scene.setFill(Color.rgb(38,42,41));
		//SampleController.rotateLogo();
		Main.primaryStage2.setScene(getScene());
		Main.primaryStage2.setMaximized(false);
		Main.primaryStage2.setMaximized(true);

		//Main.primaryStage2.show();
	} catch(Exception e) {
		e.printStackTrace();
	}

	//rect = (Rectangle) root.lookup("#rect");
	
	System.out.println(circle + "myCircle");
	System.out.println("chk2");
	
	    	  scene.setOnKeyPressed(ke -> {
	    	        KeyCode keyCode = ke.getCode();
	    	        if (keyCode.equals(KeyCode.S) || keyCode.equals(KeyCode.A)) {
	    	        	    	System.out.println("qazqaz");
	    	        	    	System.out.println(Game.getComingContainer().getLayoutX()+"VVV  "+Game.getComingContainer().getLayoutY()); 
	    			    		Game.getComingContainer().setLayoutY(Game.getComingContainer().getLayoutY() + 55);		
	    			    		circle.setLayoutY(circle.getLayoutY() - 60);
	    			    		
	    			    		
	    			    		if (Game.circleJumpedOnce == false) {
	    			    			Game.circleJumpedOnce = true;
	    			    		}
	    			     		//System.out.println("Game scnee heigth  "+ Game.getScene().getHeight());
	    			    		if (Game.getComingContainer().getLayoutY() > Game.getScene().getHeight()) {
	    			    			System.out.println("I know to");
	    			    			if (Game.getComingContainer() == containerOfChanger) {
	    			    				Game.getComingContainer().setLayoutY(-Game.getComingContainer().getPrefHeight());
	    			    			}
	    			    			else {
	    			    				Game.getComingContainer().setLayoutY(-Game.getComingContainer().getPrefHeight()- 120);
	    			    			}
	    			    			if (Game.getComingContainer() == containerOfSquare) {
	    			    				imgViewOfStarOfSquare.setVisible(true);
	    			    			}
	    			    			else if (Game.getComingContainer() == containerOfRhombus) {
	    			    				imgViewOfStarOfRhombus.setVisible(true);
	    			    			}
	    			    			else if (Game.getComingContainer() == containerOfTriangle) {
	    			    				imgViewOfStarOfTriangle.setVisible(true);
	    			    			}
	    			    			else if (Game.getComingContainer() == containerOfChanger) {
	    			    				imgViewOfChanger.setVisible(true);
	    			    			}
	    			    			
	    			    			Game.indOfComingContainer = Game.indOfComingContainer + 1;
	    			    			if (Game.indOfComingContainer == Game.arrLstOfContainers.size()) {
	    			    				Game.indOfComingContainer = 0;
	    			    			}
	    			    			Game.setComingContainer(Game.arrLstOfContainers.get(Game.indOfComingContainer)); 
	    			    		
	    			    		}
	    	            return;
	    	        }
	      
	    });
	  
	boolean outside = true;
	 timelineForCollision = new 
			Timeline(new KeyFrame(
			Duration.millis(50),
			(evt) -> {
				//System.out.println(Shape.intersect(circle, pinkLineOfSquare).computeAreaInScreen());
				//System.out.println(Shape.intersect(circle, pinkLineOfSquare).getBoundsInLocal().getWidth() != -1);
				//if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(pinkLineOfTriangle.getBoundsInParent()))) {
				if (Shape.intersect(circle, pinkLineOfTriangle).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(pinkLineOfTriangle.getStroke())) {  
					st=2;
					fine=circle.getLayoutY();
					col=circle.getFill();
				
					System.out.println(circle.getFill());
						System.out.println("Game Over Screen");
						try {	
					
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
							//ScoreBtn.setTextFill(Color.PINK);
							//TotalScoreBtn.setTextFill(Color.IVORY);
							 //ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						    //    ScoreBtn.setStyle("-fx-font-size: 2em; ");
						      //  ScoreBtn.setStyle("-fx-text-fill: #0000ff");
									Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					
				}
				//else if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(purpleLineOfTriangle.getBoundsInParent()))) {
				else if (Shape.intersect(circle, purpleLineOfTriangle).getBoundsInLocal().getWidth() != -1) {	
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(purpleLineOfTriangle.getStroke())) { 
						st=2;
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen");
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						col=circle.getFill();
								
						fine=circle.getLayoutY();
						
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
			//			rootOfGameOver.getChildrenUnmodifiable().add()
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
					TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
					ScoreBtn.setText(Integer.toString(score));
					TotalScoreBtn.setText(Integer.toString(totalscore));
					//ScoreBtn.setTextFill(Color.BLACK);
					//TotalScoreBtn.setTextFill(Color.BLACK);
				//	 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
				        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
				  //      ScoreBtn.setStyle("-fx-background-color: #90EE90");
				           
				    //    ScoreBtn.setStyle("-fx-font-size: 2em; ");
				      //  ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				//else if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(yellowLineOfTriangle.getBoundsInParent()))) {
				else if (Shape.intersect(circle, yellowLineOfTriangle).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(yellowLineOfTriangle.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						st=2;
						System.out.println("Game Over Screen");
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
								
					
					
					try {	
				Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
				ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
				TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
				ScoreBtn.setText(Integer.toString(score));
				TotalScoreBtn.setText(Integer.toString(totalscore));
				ScoreBtn.setTextFill(Color.PINK);
				TotalScoreBtn.setTextFill(Color.IVORY);
				 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
			        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
			        ScoreBtn.setStyle("-fx-background-color: #90EE90");
			           
			        ScoreBtn.setStyle("-fx-font-size: 2em; ");
			        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				
				else if (Shape.intersect(circle, pinkLineOfSquare).getBoundsInLocal().getWidth() != -1) {	
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(pinkLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						st=1;
						//System.exit(0);
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen pinkSquare");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
							ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
								Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					//System.out.println("hit1");
				}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(purpleLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, purpleLineOfSquare).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(purpleLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
						st=1;
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen purpleSquare");
						try {	

							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
							ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
									Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					
					//System.out.println("hit1");
				}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(yellowLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, yellowLineOfSquare).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(yellowLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
						st=1;
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
								
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen yellowSquare");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
				//			ScoreBtn.setTextFill(Color.PINK);
					//		TotalScoreBtn.setTextFill(Color.IVORY);
							// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						//        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						      //  ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
								Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					//System.out.println("hit1");
				}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(blueLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, blueLineOfSquare).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(blueLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
								
						st=1;
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen blueSquare");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
							//ScoreBtn.setTextFill(Color.PINK);
						//	TotalScoreBtn.setTextFill(Color.IVORY);
							// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
						     //   ScoreBtn.setStyle("-fx-text-fill: #0000ff");
								Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					//System.out.println("hit1");
				}


				
				else if (Shape.intersect(circle, pinkLineOfRhombus).getBoundsInLocal().getWidth() != -1) {	
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(pinkLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						st=0;
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen pinkRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
					//	ScoreBtn.setTextFill(Color.PINK);
						//TotalScoreBtn.setTextFill(Color.IVORY);
						// S///coreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
					           
					        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(purpleLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, purpleLineOfRhombus).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(purpleLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);+	
						st=0;
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen purpleRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
				//		ScoreBtn.setTextFill(Color.PINK);
					//	TotalScoreBtn.setTextFill(Color.IVORY);
						// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					      //  ScoreBtn.setStyle("-fx-background-color: Yellow");
					           
					        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					}		//System.out.println("hit1");
				}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(yellowLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, yellowLineOfRhombus).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(yellowLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						st=0;
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen yellowRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
						//ScoreBtn.setTextFill(Color.PINK);
						//TotalScoreBtn.setTextFill(Color.IVORY);
						// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					        //ScoreBtn.setStyle("-fx-background-color: #90EE90");
					           
					       // ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(blueLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, blueLineOfRhombus).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(blueLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						st=0;
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen blueRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
						//ScoreBtn.setTextFill(Color.PINK);
						//TotalScoreBtn.setTextFill(Color.IVORY);
						 //ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					       // ScoreBtn.setStyle("-fx-background-color: Yellow");
					           
					       // ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				
				else if (Shape.intersect(circle, pinkLineOfLineObs).getBoundsInLocal().getWidth() != -1) {	
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(pinkLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
							
						st=3;
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen pinkRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
						//ScoreBtn.setTextFill(Color.PINK);
						//TotalScoreBtn.setTextFill(Color.IVORY);
						// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
					           
					        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(purpleLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, purpleLineOfLineObs).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(purpleLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);+	
						yof=Game.getComingContainer().getLayoutY();
						fz=Game.getComingContainer();
						fine=circle.getLayoutY();
						col=circle.getFill();
								
						st=3;
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen purpleRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
						//ScoreBtn.setTextFill(Color.PINK);
					//	TotalScoreBtn.setTextFill(Color.IVORY);
						// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					  //      ScoreBtn.setStyle("-fx-background-color: Yellow");
					           
					      //  ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					}		//System.out.println("hit1");
				}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(yellowLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, yellowLineOfLineObs).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(yellowLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						fine=circle.getLayoutY();
						col=circle.getFill();
						
						st=3;
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen yellowRhombus");
					
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
					//	ScoreBtn.setTextFill(Color.PINK);
						//TotalScoreBtn.setTextFill(Color.IVORY);
						 //ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					       // ScoreBtn.setStyle("-fx-background-color: #90EE90");
					           
					        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(blueLineOfSquare.getBoundsInParent()))) {
				else if (Shape.intersect(circle, blueLineOfLineObs).getBoundsInLocal().getWidth() != -1) {
					System.out.println(circle.getFill());
					if (!circle.getFill().equals(blueLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
						//System.out.println("hittttttttttttttttttttttttttttttt");
						//System.exit(0);
						st=3;
						System.out.println(circle.getFill());
						System.out.println("Game Over Screen blueRhombus");
						fine=circle.getLayoutY();
						col=circle.getFill();
						
					try {	
						Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
						ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
						//ScoreBtn.setTextFill(Color.PINK);
						///TotalScoreBtn.setTextFill(Color.IVORY);
						 //ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					       // ScoreBtn.setStyle("-fx-background-color: Yellow");
					           
					        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
					        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						
						Scene sceneOfGameOver = new Scene(rootOfGameOver);
						getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.primaryStage2.setScene(sceneOfGameOver);
						Main.primaryStage2.setMaximized(false);
						Main.primaryStage2.setMaximized(true);
					} catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("hit1");
				}}
				else if (circle.getBoundsInParent().intersects(containerOfChanger.localToParent(imgViewOfChanger.getBoundsInParent()))) {
					if (imgViewOfChanger.isVisible() == true) {
						imgViewOfChanger.setVisible(false);
						curColorInd = curColorInd + 1;
						if (curColorInd == arrLstOfColor.size()) {
							curColorInd = 0;
						}
						circle.setFill(arrLstOfColor.get(curColorInd));
					}
				}
				
				
				
				
				/*
				else if (check for line of square) {
					
				}*/
				
				
				//System.out.println("chk3");
			})); 
	timelineForCollision.setCycleCount(Animation.INDEFINITE); 
	//10
	
	timelineForCollision.play();
	System.out.println("chk4");
	
	setTimelineForStar(new 
			Timeline(new KeyFrame(
			Duration.millis(50),
			(evt) -> {
				if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(imgViewOfStarOfSquare.getBoundsInParent()))) {
					//System.out.println("Circle intersected with star of square");
					if (imgViewOfStarOfSquare.isVisible() == true) {
						imgViewOfStarOfSquare.setVisible(false);
						score = score + 1;
						String currentDirectory = System.getProperty("user.dir");
						File file =new File("test.txt");
						 try{
					         
							 BufferedReader reader = new BufferedReader(new FileReader(file));
							 String gg=reader.readLine();
							 totalscore=Integer.parseInt(gg)+1;
							 System.out.println(totalscore);
					        }catch(IOException ex){
					            System.err.println("ERROR");
					        }
						try{
				            PrintWriter output = new PrintWriter(file);
				            output.println(Integer.toString(totalscore));
				            output.close();
				        }catch (FileNotFoundException ex){
				            System.out.printf("ERROR: %s\n", ex);
				        }
						scoreLabel.setText(String.valueOf(score));
						if (score == 10) {
							arrLstOfContainers.add(containerOfTriangle);
							arrLstOfContainers.add(containerOfChanger);
						}
						/*curColorInd = curColorInd + 1;
						if (curColorInd == arrLstOfColor.size()) {
							curColorInd = 0;
						}
						circle.setFill(arrLstOfColor.get(curColorInd));
						*/
					}
				}
				else if (circle.getBoundsInParent().intersects(containerOfRhombus.localToParent(imgViewOfStarOfRhombus.getBoundsInParent()))) {
					//System.out.println("Circle intersected with star of square");
					if (imgViewOfStarOfRhombus.isVisible() == true) {
						imgViewOfStarOfRhombus.setVisible(false);
						score = score + 1;
						String currentDirectory = System.getProperty("user.dir");
						File file =new File("test.txt");
						 try{
					         
							 BufferedReader reader = new BufferedReader(new FileReader(file));
							 String gg=reader.readLine();
							 totalscore=Integer.parseInt(gg)+1;
							 System.out.println(totalscore);
						 }catch(IOException ex){
					            System.err.println("ERROR22");
					        }
						try{
				            PrintWriter output = new PrintWriter(file);
				            output.println(Integer.toString(totalscore));
				            output.close();
				        }catch (FileNotFoundException ex){
				            System.out.printf("ERROR: %s\n", ex);
				        }
						scoreLabel.setText(String.valueOf(score));
						if (score == 10) {
							arrLstOfContainers.add(containerOfTriangle);
							arrLstOfContainers.add(containerOfChanger);
						}
						/*
						curColorInd = curColorInd + 1;
						if (curColorInd == arrLstOfColor.size()) {
							curColorInd = 0;
						}
						circle.setFill(arrLstOfColor.get(curColorInd));
						*/
					}
				}
				else if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(imgViewOfStarOfTriangle.getBoundsInParent()))) {
					//System.out.println("Circle intersected with star of square");
					if (imgViewOfStarOfTriangle.isVisible() == true) {
						imgViewOfStarOfTriangle.setVisible(false);
						score = score + 1;
						String currentDirectory = System.getProperty("user.dir");
						File file =new File("test.txt");
						 try{
					         
							 BufferedReader reader = new BufferedReader(new FileReader(file));
							 String gg=reader.readLine();
							 totalscore=Integer.parseInt(gg)+1;
							 System.out.println(totalscore);
					        }catch(IOException ex){
					            System.err.println("ERROR11");
					        }
						try{
				            PrintWriter output = new PrintWriter(file);
				            output.println(Integer.toString(totalscore));
				            output.close();
				        }catch (FileNotFoundException ex){
				            System.out.printf("ERROR: %s\n", ex);
				        }
						scoreLabel.setText(String.valueOf(score));
						if (score == 10) {
							arrLstOfContainers.add(containerOfTriangle);
							arrLstOfContainers.add(containerOfChanger);
						}
						/*
						curColorInd = curColorInd + 1;
						if (curColorInd == arrLstOfColor.size()) {
							curColorInd = 0;
						}
						circle.setFill(arrLstOfColor.get(curColorInd));
						*/
					}
				}
			}))); 
	getTimelineForStar().setCycleCount(Animation.INDEFINITE);       //10

	getTimelineForStar().play();
	
	
	timelineForGravity = new 
			Timeline(new KeyFrame(
			Duration.millis(50),
			(evt) -> {
				if (circleJumpedOnce == true) {
					circle.setLayoutY(circle.getLayoutY()+5);
				}
			})); 
	timelineForGravity.setCycleCount(Animation.INDEFINITE);       //10
	
	timelineForGravity.play();
	

}
	public void run() {
		Main.currentRunningGame = this;
		//Scene scene = null;
		try {	
			root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
			arc=(AnchorPane) root.lookup("#arc");
			System.out.println("abcabcabcc");
			
			//Syste
			setScene(new Scene(root));
	
			getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//scene.setFill(Color.rgb(38,42,41));
			//SampleController.rotateLogo();
			Main.primaryStage2.setScene(getScene());
			Main.primaryStage2.setMaximized(false);
			Main.primaryStage2.setMaximized(true);
			//Main.primaryStage2.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		pinkLineOfTriangle = (Line) root.lookup("#pinkLineOfTriangle");
		purpleLineOfTriangle = (Line) root.lookup("#purpleLineOfTriangle");
		yellowLineOfTriangle = (Line) root.lookup("#yellowLineOfTriangle");
		containerOfTriangle = (AnchorPane) root.lookup("#containerOfTriangle");
System.out.println("contaierof triangle=- "+containerOfTriangle.getLayoutY());
		containerOfTriangle.setVisible(true);
		pinkLineOfSquare = (Line) root.lookup("#pinkLineOfSquare");
		purpleLineOfSquare = (Line) root.lookup("#purpleLineOfSquare");
		yellowLineOfSquare = (Line) root.lookup("#yellowLineOfSquare");
		blueLineOfSquare = (Line) root.lookup("#blueLineOfSquare");
		containerOfSquare = (AnchorPane) root.lookup("#containerOfSquare");
		System.out.println("contaier of square=- "+containerOfSquare.getLayoutY());
		containerOfSquare.setVisible(true);
		
		pinkLineOfRhombus = (Line) root.lookup("#pinkLineOfRhombus");
		purpleLineOfRhombus = (Line) root.lookup("#purpleLineOfRhombus");
		yellowLineOfRhombus = (Line) root.lookup("#yellowLineOfRhombus");
		blueLineOfRhombus = (Line) root.lookup("#blueLineOfRhombus");
		containerOfRhombus = (AnchorPane) root.lookup("#containerOfRhombus");
		System.out.println("contaierof Rhombus=- "+containerOfRhombus.getLayoutY());
		containerOfRhombus.setVisible(true);
		
		pinkLineOfLineObs = (Line) root.lookup("#pinkLineOfLineObs");
		purpleLineOfLineObs = (Line) root.lookup("#purpleLineOfLineObs");
		yellowLineOfLineObs = (Line) root.lookup("#yellowLineOfLineObs");
		blueLineOfLineObs = (Line) root.lookup("#blueLineOfLineObs");
		containerOfLineObs = (AnchorPane) root.lookup("#containerOfLineObs");
		containerOfLineObs.setVisible(true);
		
		containerOfChanger = (AnchorPane) root.lookup("#containerOfChanger");
		imgViewOfChanger = (ImageView) root.lookup("#imgViewOfChanger");
		containerOfChanger.setVisible(true);
		
		
		imgViewOfStarOfSquare = (ImageView) root.lookup("#imgViewOfStarOfSquare");
		imgViewOfStarOfRhombus = (ImageView) root.lookup("#imgViewOfStarOfRhombus");
		imgViewOfStarOfTriangle = (ImageView) root.lookup("#imgViewOfStarOfTriangle");
		pauseBtn=(Button) root.lookup("#pauseBtn");
		scoreLabel = (Label) root.lookup("#scoreLabel");
		
		System.out.println("scoreL" +scoreLabel);
		
		circle = (Circle) root.lookup("#circle");
		System.out.println(circle.getLayoutY());
		//rect = (Rectangle) root.lookup("#rect");
		
		System.out.println(circle + "myCircle");
		System.out.println("chk2");
		
		    	  getScene().setOnKeyPressed(ke -> {
		    	        KeyCode keyCode = ke.getCode();
		    	        if (keyCode.equals(KeyCode.S) || keyCode.equals(KeyCode.A)) {
		    	        	    	System.out.println("qazqaz");
		    	        	    	System.out.println(getComingContainer().getLayoutX()+"VVV  "+getComingContainer().getLayoutY()); 
		    	        	    	getComingContainer().setLayoutY(Game.getComingContainer().getLayoutY() + 55);		
		    			    		circle.setLayoutY(circle.getLayoutY() - 60);
		    			    		
		    			    		
		    			    		if(circleJumpedOnce == false) {
		    			    		circleJumpedOnce = true;
		    			    		}
		    			    		
		    			    		if (getComingContainer().getLayoutY() > getScene().getHeight()) {
		    			    			System.out.println("ayush");
		    			    			if (getComingContainer() == containerOfChanger) {
		    			    				getComingContainer().setLayoutY(-getComingContainer().getPrefHeight());
		    			    			}
		    			    			else {
		    			    				getComingContainer().setLayoutY(-getComingContainer().getPrefHeight()- 120);
		    			    			}
		    			    			System.out.println(getComingContainer().getLayoutY());
		    			    			if (getComingContainer() == containerOfSquare) {
		    			    			System.out.println("WHYYYYYYYYYYYYYYY");
		    			    				imgViewOfStarOfSquare.setVisible(true);
		    			    			}
		    			    			else if (getComingContainer() == containerOfRhombus) {
		    			    				imgViewOfStarOfRhombus.setVisible(true);

			    			    			System.out.println("WHYYYYYYYYYYYYYYY22");
		    			    			}
		    			    			else if (getComingContainer() == containerOfTriangle) {
		    			    				imgViewOfStarOfTriangle.setVisible(true);
			    			    			System.out.println("WHYYYYYYYYYYYYYYY33");
		    			    			}
		    			    			else if (Game.getComingContainer() == containerOfChanger) {
		    			    				imgViewOfChanger.setVisible(true);
		    			    			}
		    			    			
		    			    			
		    			    			indOfComingContainer = indOfComingContainer + 1;
		    			    			if (indOfComingContainer == arrLstOfContainers.size()) {
		    			    				indOfComingContainer = 0;
		    			    			}
		    			    			System.out.println("index of containing container "+ getComingContainer());
		    			    	getComingContainer().setVisible(true);
		    			    			setComingContainer(arrLstOfContainers.get(indOfComingContainer)); 
		    			    		
		    			    		}
		    	            return;
		    	        }
		      
		    });
		  
		boolean outside = true;
		 timelineForCollision = new 
				Timeline(new KeyFrame(
				Duration.millis(50),
				(evt) -> {
					//System.out.println(Shape.intersect(circle, pinkLineOfSquare).computeAreaInScreen());
					//System.out.println(Shape.intersect(circle, pinkLineOfSquare).getBoundsInLocal().getWidth() != -1);
					//if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(pinkLineOfTriangle.getBoundsInParent()))) {
					if (Shape.intersect(circle, pinkLineOfTriangle).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(pinkLineOfTriangle.getStroke())) {  
			System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen");
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=2;//standard for continue to show if it wwas a triangle which made tje game quit
							System.out.println("okaz");
							setIndex(indOfComingContainer);
							fine=circle.getLayoutY();
							col=circle.getFill();
							
							try {	
						
								Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
								ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
								TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
								ScoreBtn.setText(Integer.toString(score));
								TotalScoreBtn.setText(Integer.toString(totalscore));
							//	ScoreBtn.setTextFill(Color.PINK);
								////TotalScoreBtn.setTextFill(Color.IVORY);
								 //ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
							        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
							       // ScoreBtn.setStyle("-fx-background-color: #90EE90");
							           
							        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
							        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
										Scene sceneOfGameOver = new Scene(rootOfGameOver);
								getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								Main.primaryStage2.setScene(sceneOfGameOver);
								Main.primaryStage2.setMaximized(false);
								Main.primaryStage2.setMaximized(true);
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
						
					}
					//else if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(purpleLineOfTriangle.getBoundsInParent()))) {
					else if (Shape.intersect(circle, purpleLineOfTriangle).getBoundsInLocal().getWidth() != -1) {	
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(purpleLineOfTriangle.getStroke())) { 
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen");
							fine=circle.getLayoutY();
							setIndex(indOfComingContainer);
							
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
							col=circle.getFill();
							
							st=2;//standard for continue to show if it wwas a triangle which made tje game quit
							System.out.println("okaz");		
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
				//			rootOfGameOver.getChildrenUnmodifiable().add()
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
						TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
						ScoreBtn.setText(Integer.toString(score));
						TotalScoreBtn.setText(Integer.toString(totalscore));
					//	ScoreBtn.setTextFill(Color.PINK);
						//TotalScoreBtn.setTextFill(Color.IVORY);
						// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
					        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
					      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
					           
					        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
					       // ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					//else if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(yellowLineOfTriangle.getBoundsInParent()))) {
					else if (Shape.intersect(circle, yellowLineOfTriangle).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(yellowLineOfTriangle.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
									st=2;
									setIndex(indOfComingContainer);
									col=circle.getFill();
											
									System.out.println("okaz");
							fine=circle.getLayoutY();
							System.out.println("Game Over Screen");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						
						
						try {	
					Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
					ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
					TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
					ScoreBtn.setText(Integer.toString(score));
					TotalScoreBtn.setText(Integer.toString(totalscore));
					//ScoreBtn.setTextFill(Color.PINK);
				//	TotalScoreBtn.setTextFill(Color.IVORY);
					// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
				        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
				      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
				           
				        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
				        //ScoreBtn.setStyle("-fx-text-fill: #0000ff");
								Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					
					else if (Shape.intersect(circle, pinkLineOfSquare).getBoundsInLocal().getWidth() != -1) {	
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(pinkLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							st=1;//standard for continue to show if it wwas a sqyare which made tje game quit
							System.out.println("ok222");
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen pinkSquare");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
							try {	
								Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
								ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
								TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
								ScoreBtn.setText(Integer.toString(score));
								TotalScoreBtn.setText(Integer.toString(totalscore));
				/*	//			ScoreBtn.setTextFill(Color.PINK);
						//		TotalScoreBtn.setTextFill(Color.IVORY);
							//	 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
							/ /       //ScoreBtn.setStyle("-fx-background-color: #00ff00");
							   //     ScoreBtn.setStyle("-fx-background-color: #90EE90");
							           
							     //   ScoreBtn.setStyle("-fx-font-size: 2em; ");
							       // ScoreBtn.setStyle("-fx-text-fill: #0000ff");
					*/
									Scene sceneOfGameOver = new Scene(rootOfGameOver);
								getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								Main.primaryStage2.setScene(sceneOfGameOver);
								Main.primaryStage2.setMaximized(false);
								Main.primaryStage2.setMaximized(true);
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
						
						//System.out.println("hit1");
					}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(purpleLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, purpleLineOfSquare).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(purpleLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=1;//standard for continue to show if it wwas a sqyare which made tje game quit
							System.out.println("ok222");
							System.out.println(circle.getFill());
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							System.out.println("Game Over Screen purpleSquare");
							fine=circle.getLayoutY();
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
							try {	

								Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
								ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
								TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
								ScoreBtn.setText(Integer.toString(score));
								TotalScoreBtn.setText(Integer.toString(totalscore));
							//	ScoreBtn.setTextFill(Color.PINK);
							///	TotalScoreBtn.setTextFill(Color.IVORY);
								// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
							        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
							      //  ScoreBtn.setStyle("-fx-background-color: #90EE90");
							           
							        //ScoreBtn.setStyle("-fx-font-size: 2em; ");
							       // ScoreBtn.setStyle("-fx-text-fill: #0000ff");
										Scene sceneOfGameOver = new Scene(rootOfGameOver);
								getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								Main.primaryStage2.setScene(sceneOfGameOver);
								Main.primaryStage2.setMaximized(false);
								Main.primaryStage2.setMaximized(true);
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
						
						
						//System.out.println("hit1");
					}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(yellowLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, yellowLineOfSquare).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(yellowLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							System.out.println(circle.getFill());
							yof=Game.getComingContainer().getLayoutY();
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							fz=Game.getComingContainer();
								st=1;//standard for continue to show if it wwas a sqyare which made tje game quit
							System.out.println("okppp");
							fine=circle.getLayoutY();
							System.out.println("Game Over Screen yellowSquare");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
							try {	
								Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
								ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
								TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
								ScoreBtn.setText(Integer.toString(score));
								TotalScoreBtn.setText(Integer.toString(totalscore));
							//	ScoreBtn.setTextFill(Color.PINK);
								//TotalScoreBtn.setTextFill(Color.IVORY);
					//			// ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
							        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						//	        ScoreBtn.setStyle("-fx-background-color: #90EE90");
							           
							//        ScoreBtn.setStyle("-fx-font-size: 2em; ");
							  //      ScoreBtn.setStyle("-fx-text-fill: #0000ff");
									Scene sceneOfGameOver = new Scene(rootOfGameOver);
								getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								Main.primaryStage2.setScene(sceneOfGameOver);
								Main.primaryStage2.setMaximized(false);
								Main.primaryStage2.setMaximized(true);
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
						
						//System.out.println("hit1");
					}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(blueLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, blueLineOfSquare).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						
						if (!circle.getFill().equals(blueLineOfSquare.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=1;//standard for continue to show if it wwas a sqyare which made tje game quit
								
							fine=circle.getLayoutY();
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen blueSquare");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
							try {	
								Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
								ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
								TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
								ScoreBtn.setText(Integer.toString(score));
								TotalScoreBtn.setText(Integer.toString(totalscore));
								/*
								ScoreBtn.setTextFill(Color.PINK);
								TotalScoreBtn.setTextFill(Color.IVORY);
								 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
							        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
							        ScoreBtn.setStyle("-fx-background-color: #90EE90");
							           
							        ScoreBtn.setStyle("-fx-font-size: 2em; ");
							        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
									*/
									Scene sceneOfGameOver = new Scene(rootOfGameOver);
								getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								Main.primaryStage2.setScene(sceneOfGameOver);
								Main.primaryStage2.setMaximized(false);
								Main.primaryStage2.setMaximized(true);
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
						
						//System.out.println("hit1");
					}


					
					else if (Shape.intersect(circle, pinkLineOfRhombus).getBoundsInLocal().getWidth() != -1) {	
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(pinkLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=0;//standard for continue to show if it wwas a rhombus which made tje game quit
								System.out.println("ok");
							fine=circle.getLayoutY();
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen pinkRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
						
							/*ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(purpleLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, purpleLineOfRhombus).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(purpleLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
							fine=circle.getLayoutY();
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);+	
							yof=Game.getComingContainer().getLayoutY();
							setIndex(indOfComingContainer);
							col=circle.getFill();
									
							fz=Game.getComingContainer();
								st=0;//standard for continue to show if it wwas a rhombus which made tje game quit
							System.out.println("ok");
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen purpleRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
						/*	ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: Yellow");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
								Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						}		//System.out.println("hit1");
					}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(yellowLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, yellowLineOfRhombus).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(yellowLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							fine=circle.getLayoutY();
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							st=0;//standard for continue to show if it wwas a rhombus which made tje game quit
							System.out.println("ok");		
							//System.exit(0);
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen yellowRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
						/*	ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(blueLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, blueLineOfRhombus).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(blueLineOfRhombus.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							fine=circle.getLayoutY();
							setIndex(indOfComingContainer);
							
							col=circle.getFill();
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
									st=0;//standard for continue to show if it wwas a rhombus which made tje game quit
							//System.exit(0);
						System.out.println("ok");
						System.out.println(circle.getFill());
							System.out.println("Game Over Screen blueRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
							
							/*ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: Yellow");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					
					else if (Shape.intersect(circle, pinkLineOfLineObs).getBoundsInLocal().getWidth() != -1) {	
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(pinkLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=3;//standard for continue to show if it wwas a rhombus which made tje game quit
								System.out.println("ok");
							fine=circle.getLayoutY();
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen pinkRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
					/*		ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
						*/
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(purpleLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, purpleLineOfLineObs).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(purpleLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
							fine=circle.getLayoutY();
							//System.out.println("hittttttttttttttttttttttttttttttt");
							//System.exit(0);+	
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=3;//standard for continue to show if it wwas a rhombus which made tje game quit
								setIndex(indOfComingContainer);
								col=circle.getFill();
									
								System.out.println("ok");
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen purpleRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
						/*	ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: Yellow");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
								Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						}		//System.out.println("hit1");
					}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(yellowLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, yellowLineOfLineObs).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(yellowLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							fine=circle.getLayoutY();
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
								st=3;//standard for continue to show if it wwas a rhombus which made tje game quit
							System.out.println("ok");		
							//System.exit(0);
							System.out.println(circle.getFill());
							System.out.println("Game Over Screen yellowRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
						/*	ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: #90EE90");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					//else if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(blueLineOfSquare.getBoundsInParent()))) {
					else if (Shape.intersect(circle, blueLineOfLineObs).getBoundsInLocal().getWidth() != -1) {
						System.out.println(circle.getFill());
						if (!circle.getFill().equals(blueLineOfLineObs.getStroke())) {  //NOTE THE ! SIGN HERE
							//System.out.println("hittttttttttttttttttttttttttttttt");
							fine=circle.getLayoutY();
							setIndex(indOfComingContainer);
							col=circle.getFill();
							
							yof=Game.getComingContainer().getLayoutY();
							fz=Game.getComingContainer();
									st=3;//standard for continue to show if it wwas a rhombus which made tje game quit
							//System.exit(0);
						System.out.println("ok");
						System.out.println(circle.getFill());
							System.out.println("Game Over Screen blueRhombus");
							System.out.println(circle.getLayoutY()+" ffffffffffffffffffff");
						try {	
							Parent rootOfGameOver = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
							ScoreBtn=(Button) rootOfGameOver.lookup("#ScoreBtn");
							TotalScoreBtn=(Button) rootOfGameOver.lookup("#TotalScoreBtn");
							ScoreBtn.setText(Integer.toString(score));
							TotalScoreBtn.setText(Integer.toString(totalscore));
							/*ScoreBtn.setTextFill(Color.PINK);
							TotalScoreBtn.setTextFill(Color.IVORY);
							 ScoreBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
						        //ScoreBtn.setStyle("-fx-background-color: #00ff00");
						        ScoreBtn.setStyle("-fx-background-color: Yellow");
						           
						        ScoreBtn.setStyle("-fx-font-size: 2em; ");
						        ScoreBtn.setStyle("-fx-text-fill: #0000ff");
							*/
							Scene sceneOfGameOver = new Scene(rootOfGameOver);
							getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							Main.primaryStage2.setScene(sceneOfGameOver);
							Main.primaryStage2.setMaximized(false);
							Main.primaryStage2.setMaximized(true);
						} catch(Exception e) {
							e.printStackTrace();
						}
						//System.out.println("hit1");
					}}
					else if (circle.getBoundsInParent().intersects(containerOfChanger.localToParent(imgViewOfChanger.getBoundsInParent()))) {
						if (imgViewOfChanger.isVisible() == true) {
							imgViewOfChanger.setVisible(false);
							Image img;
					
							curColorInd = curColorInd + 1;
							if (curColorInd == arrLstOfColor.size()) {
								curColorInd = 0;
							}
							circle.setFill(arrLstOfColor.get(curColorInd));
						}
					}
					
					/*
					else if (check for line of square) {
						
					}*/
					
					
					//System.out.println("chk3");
				})); 
		timelineForCollision.setCycleCount(Animation.INDEFINITE); 
		//10
		
		timelineForCollision.play();
		System.out.println("chk4");
		
		setTimelineForStar(new 
				Timeline(new KeyFrame(
				Duration.millis(50),
				(evt) -> {
					if (circle.getBoundsInParent().intersects(containerOfSquare.localToParent(imgViewOfStarOfSquare.getBoundsInParent()))) {
						//System.out.println("Circle intersected with star of square");
						if (imgViewOfStarOfSquare.isVisible() == true) {
							imgViewOfStarOfSquare.setVisible(false);
							score = score + 1;
							String currentDirectory = System.getProperty("user.dir");
							File file =new File("test.txt");
							 try{
						         
								 BufferedReader reader = new BufferedReader(new FileReader(file));
								 String gg=reader.readLine();
								 totalscore=Integer.parseInt(gg)+1;
								 System.out.println(totalscore);
						        }catch(IOException ex){
						            System.err.println("ERROR");
						        }
							try{
					            PrintWriter output = new PrintWriter(file);
					            output.println(Integer.toString(totalscore));
					            output.close();
					        }catch (FileNotFoundException ex){
					            System.out.printf("ERROR: %s\n", ex);
					        }
							scoreLabel.setText(String.valueOf(score));
							if (score == 10) {
								arrLstOfContainers.add(containerOfTriangle);
								arrLstOfContainers.add(containerOfChanger);
							}
							/*
							curColorInd = curColorInd + 1;
							if (curColorInd == arrLstOfColor.size()) {
								curColorInd = 0;
							}
							circle.setFill(arrLstOfColor.get(curColorInd));
							*/
						}
					}
					else if (circle.getBoundsInParent().intersects(containerOfRhombus.localToParent(imgViewOfStarOfRhombus.getBoundsInParent()))) {
						//System.out.println("Circle intersected with star of square");
						if (imgViewOfStarOfRhombus.isVisible() == true) {
							imgViewOfStarOfRhombus.setVisible(false);
							score = score + 1;
							String currentDirectory = System.getProperty("user.dir");
							File file =new File("test.txt");
							 try{
						         
								 BufferedReader reader = new BufferedReader(new FileReader(file));
								 String gg=reader.readLine();
								 totalscore=Integer.parseInt(gg)+1;
								 System.out.println(totalscore);
							 }catch(IOException ex){
						            System.err.println("ERROR22");
						        }
							try{
					            PrintWriter output = new PrintWriter(file);
					            output.println(Integer.toString(totalscore));
					            output.close();
					        }catch (FileNotFoundException ex){
					            System.out.printf("ERROR: %s\n", ex);
					        }
							scoreLabel.setText(String.valueOf(score));
							if (score == 10) {
								arrLstOfContainers.add(containerOfTriangle);
								arrLstOfContainers.add(containerOfChanger);
							}
							/*
							curColorInd = curColorInd + 1;
							if (curColorInd == arrLstOfColor.size()) {
								curColorInd = 0;
							}
							circle.setFill(arrLstOfColor.get(curColorInd));
							*/
						}
					}
					else if (circle.getBoundsInParent().intersects(containerOfTriangle.localToParent(imgViewOfStarOfTriangle.getBoundsInParent()))) {
						//System.out.println("Circle intersected with star of square");
						if (imgViewOfStarOfTriangle.isVisible() == true) {
							imgViewOfStarOfTriangle.setVisible(false);
							score = score + 1;
							String currentDirectory = System.getProperty("user.dir");
							File file =new File("test.txt");
							 try{
						         
								 BufferedReader reader = new BufferedReader(new FileReader(file));
								 String gg=reader.readLine();
								 totalscore=Integer.parseInt(gg)+1;
								 System.out.println(totalscore);
						        }catch(IOException ex){
						            System.err.println("ERROR11");
						        }
							try{
					            PrintWriter output = new PrintWriter(file);
					            output.println(Integer.toString(totalscore));
					            output.close();
					        }catch (FileNotFoundException ex){
					            System.out.printf("ERROR: %s\n", ex);
					        }
							scoreLabel.setText(String.valueOf(score));
							if (score == 10) {
								arrLstOfContainers.add(containerOfTriangle);
								Game.arrLstOfContainers.add(containerOfChanger);
							}
							/*
							curColorInd = curColorInd + 1;
							if (curColorInd == arrLstOfColor.size()) {
								curColorInd = 0;
							}
							circle.setFill(arrLstOfColor.get(curColorInd));
							*/
						}
					}
				}))); 
		getTimelineForStar().setCycleCount(Animation.INDEFINITE);       //10
	
		getTimelineForStar().play();
		
		
		timelineForGravity = new 
				Timeline(new KeyFrame(
				Duration.millis(50),
				(evt) -> {
					if (circleJumpedOnce == true) {
						circle.setLayoutY(circle.getLayoutY()+5);
					}
				})); 
		timelineForGravity.setCycleCount(Animation.INDEFINITE);       //10
		
		timelineForGravity.play();
		

	}
	public static Scene getScene() {
		return scene;
	}
	public static void setScene(Scene scene) {
		Game.scene = scene;
	}
	public static AnchorPane getComingContainer() {
		return comingContainer;
	}
	public static void setComingContainer(AnchorPane comingContainer) {
		Game.comingContainer = comingContainer;
	}
	public Timeline getTimelineForStar() {
		return timelineForStar;
	}
	public void setTimelineForStar(Timeline timelineForStar) {
		this.timelineForStar = timelineForStar;
	}
	public static AnchorPane getFz() {
		return fz;
	}
	public static void setFz(AnchorPane fz) {
		Game.fz = fz;
	}
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		Game.index = index;
	}
}
