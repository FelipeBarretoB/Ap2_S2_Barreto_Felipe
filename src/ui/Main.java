package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application {

	private ClassroomGUI classroomGUI;
	private Classroom cr;
	public Main() {
		classroomGUI= new ClassroomGUI(cr);
	}
	
	public static void main(String [] args)  {
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(classroomGUI);
		Parent root= fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("a");
		primaryStage.show();
		classroomGUI.loadLogin();
		
	}
}
