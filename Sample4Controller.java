package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.layout.AnchorPane;


public class Sample4Controller implements Initializable  {
	Stage primaryStage1;
	@FXML
	private Button RestartBtn;
	@FXML
	public void RestartBtnClicked() throws IOException {   
		
		Main.currentRunningGame.close();
		Game game = new Game();
		game.run();
		}
	@FXML
	public void MainBtnClicked() throws ClassNotFoundException, FileNotFoundException, IOException {     
		System.out.println( "Main page!" );
		  Main.primary.close();
		  Platform.runLater( () -> new Main().start( new Stage() ) );
	}
	@FXML
	public void ContinueBtnClicked() {     
		System.out.println( "Continue!" );
		System.out.println(Game.totalscore);
	if(Game.totalscore>=2 && Game.score>=2)
	{	
		
		
		
		System.out.println("rtttttttttttttttt");
		if(Main.currentRunningGame!=null)
		{Main.currentRunningGame.close();
	
		
		}	Game.totalscore=Game.totalscore-2;	        
	try{
		File file =new File("test.txt");
		
        PrintWriter output = new PrintWriter(file);
        output.println(Integer.toString(Game.totalscore));
        output.close();
    }catch (FileNotFoundException ex){
        System.out.printf("ERROR: %s\n", ex);
    }double rr=Game.fine;
    double wq=Game.yof;
    int rg1 = 0,rg2 = 0,rg3 = 0;
    int hhg=Game.getIndex();
    //AnchorPane qq=Game.getFz();
    
    if(Game.col.equals(Game.pinkColor))
    {rg1=252;rg2=34;rg3=131;}
  
    else if(Game.col.equals(Game.purpleColor))
    
    {rg1=150;rg2=45;rg3=252;}
    
    else if(Game.col.equals(Game.yellowColor))
    {rg1=252;rg2=216;rg3=8;}
    else
    
    	{rg1=252;rg2=34;rg3=131;}
    	  
    System.out.println("EERREREREERERER     "+Game.circle.getLayoutY());String g1=(Integer.toString(Game.score));
    int gx=1;
    System.out.println(Game.arrLstOfContainers.get(hhg));
	Game ee=new Game();
	ee.run1(600, g1,gx,-200,hhg,rg1,rg2,rg3,0);
	}}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
