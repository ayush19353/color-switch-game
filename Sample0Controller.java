package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class Sample0Controller {
	@FXML
	PasswordField passwordField;
	@FXML
	Label invalidLabel;
	@FXML
	public void goBtnClicked() {
		String passwordEntered = passwordField.getText();
		if (passwordEntered.equals("colorswitch")) {
			try {	
				Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				//scene.setFill(Color.rgb(38,42,41));
				//SampleController.rotateLogo();
				//Main.primaryStage2.close();
				Main.primary.setScene(scene);
				Main.primary.setMaximized(false);
				Main.primary.setMaximized(true);
				//Main.primaryStage2.show();
				//Main.primaryStage2.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (passwordEntered.equals("")) {
			invalidLabel.setText("Please enter the password first.");
		}
		else {
			invalidLabel.setText("Incorrect Password !");
		}
	}
}
