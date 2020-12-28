package application;
import java.io.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
//import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;




public class Main extends Application {
	private int tScore;
	private int noOfStars;
	private ArrayList<Game> savedGames;
	
	static Stage primaryStage2,primary,primary3;
	static Game currentRunningGame;
	 private static Datbas currentd;
//	//private static Datbas currentd;
	
	 @Override
	public void start(Stage primaryStage) {
		try {
			deserialize();
		primaryStage2 = primaryStage;
			primary3=primaryStage;
			primary=primaryStage;
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("Sample0.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//scene.setFill(Color.rgb(38,42,41));
			//SampleController.rotateLogo();
			primary.setScene(scene);
			primary.setTitle("Color Switch");
			primary.setMaximized(true);
			System.out.println("up1");
			primary.show();
			System.out.println("up2");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getTScore() {
		return tScore;
	}
	public int getNoOfStars() {
		return noOfStars;
	}
	public ArrayList<Game> getSavedGames() {
		return savedGames;
	}
	public void getTScore(int tScore) {
		this.tScore = tScore;
	}
	public void setNoOfStars(int noOfStars) {
		this.noOfStars = noOfStars;
	}
	public void setSavedGames(ArrayList<Game> savedGames) {
		this.savedGames = savedGames;
	}
	public void playNewGame() {
		System.out.println("newGame");
		if(Main.currentRunningGame!=null)
			Main.currentRunningGame.close();
		Game game = new Game();
		game.run();
	}
	public void playSavedGame() {
		System.out.println("load Saved Game");
		Parent root = null;
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
	public void saveGame() {
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
	public void saveTScore() {
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
	public void loadSavedGame(Game game) {
		Parent root = null;
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.primary3.setScene(scene);
	Main.primary3.setTitle("soss");
	Main.primary3.setMaximized(false);
		Main.primary3.setMaximized(true);
		
		System.out.println("up1");
		Main.primary3.show();
	}
	public void useStars() {
		System.out.println( "Continue!" );
		System.out.println(Game.totalscore);
	if(Game.totalscore>=1 && Game.score>=1)
	{	
		System.out.println("rtttttttttttttttt");
		if(Main.currentRunningGame!=null)
		{Main.currentRunningGame.close();
	
		
		}	Game.totalscore=0;	        
	try{
		File file =new File("test.txt");
		
        PrintWriter output = new PrintWriter(file);
        output.println(Integer.toString(Game.totalscore));
        output.close();
    }catch (FileNotFoundException ex){
        System.out.printf("ERROR: %s\n", ex);
    }double rr=Game.fine;
    double wq=Game.yof;
    int hhg=Game.getIndex();
    //AnchorPane qq=Game.getFz();
    System.out.println("EERREREREERERER     "+Game.circle.getLayoutY());String g1=(Integer.toString(Game.score));
    int gx=1;
	Game ee=new Game();
	}
	}
	public void saveNoOfStars() {
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
	public void exit() {
		System.exit(0);
	}
    public static Datbas getDatabase(){
        return currentd;
    }public static void serialize() throws IOException {
        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
            out.writeObject(currentd);
        }
        finally {
            out.close();
         for(int g=0;g<currentd.getdatafiles().size();g++)
        	 System.out.println(currentd.getdatafiles().get(g).getSco()+"   "+ currentd.getdatafiles().get(g).getGameId());
            //System.out.println("Saved!");
     //       System.exit(0);
        }
    }
    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException{
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("database.txt"));
            currentd=(Datbas) in.readObject();
            in.close();
        }
        catch (FileNotFoundException e){
            currentd=new Datbas();
        }
        catch (NullPointerException e) {
            currentd=new Datbas();
            //System.out.println("This user does not exist in the database");
        }
    }

	
	public static void main(String[] args) {
		launch(args);
	}


}
