package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class aController implements Initializable {

	@FXML
	private TableView<Pro> t1;
	@FXML
	private TableColumn<Pro, String> c1;
	@FXML
	private TableColumn<Pro, String> c2;

	private  ObservableList<Pro> data=FXCollections.observableArrayList();
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	try {
c1.setCellValueFactory(new PropertyValueFactory<>("g"));
c2.setCellValueFactory(new PropertyValueFactory<>("star"));

		additems();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@FXML
public void playGame(ActionEvent event)
{
	
Pro gg=	t1.getSelectionModel().getSelectedItem();
if(gg!=null)

	{if(Main.currentRunningGame!=null)
		Main.currentRunningGame.close();
	System.out.println(gg.getStar());	
	int ff=gg.getStar();
	int a1=gg.getXp1();int a2=gg.getXp2();int a3=gg.getXp3();
double rre=gg.getR().getG2();
int f=gg.getInd();double f1=gg.getGd();
float angl=gg.getCx();
AnchorPane qpq=Game.containerOfLineObs;
t1.getItems().removeAll(gg);
Game qq=new Game();
qq.run1(rre, Integer.toString(ff),2,f1,f, a1, a2, a3,angl);
	}

}




private void additems()throws IOException,ClassNotFoundException, IOException
{
	int gp=1;
	Main.deserialize();
	Datbas a=Main.getDatabase();
	for(DatTab a1:a.getdatafiles())
	{
		ImageView q=new ImageView();
		//Image f=new Image(this.getClass().getResourceAsStream("colorChangerImage.png"));
		//q.setImage(f);
		System.out.println(a1.getSco());
		int gf=a1.getInde();
		float ang=a1.getAngle();
		int x1=a1.getRgg1();int x2=a1.getRgg2();int x3=a1.getRgg3();
		double gfd=a1.getComing();
	Pro t=new Pro(q,gp,a1.getSco(),a1,gf,gfd,x1,x2,x3,ang);
	gp++;
	System.out.println("RRRRRRRRRRR");
	System.out.println(t.getStar());
data.add(t);		}
t1.setItems(data);
}
}