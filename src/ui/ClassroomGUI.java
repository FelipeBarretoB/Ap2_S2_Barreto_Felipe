package ui;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Classroom;
public class ClassroomGUI {

	private Classroom classroom;
	
	public ClassroomGUI(Classroom cr) {
		classroom= cr;
	}
	
	//login
	@FXML
	FileChooser fileChooser;
	
	//main-pain
	@FXML
	private Pane mainPane;
	
	//Login
	@FXML
	private DatePicker datePicker = new DatePicker();	
	
	//main-pane
	@FXML
	private TextField txtUserName;

	//main-pane
	@FXML
	private TextField txtPassword;

	//main-pane
	@FXML
	private Button btnSingIn;

	//main-pane
	@FXML
	private Button btnLogIn;
	
	
	public void initializeLogIn() {
		
		
	}

	@FXML
	public void LogIn(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("login.fxml"));
    	fxmlLoader.setController(this);
    	Parent addContactPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(addContactPane);
	}

	@FXML
	public void SingIn(ActionEvent event) {
		datePicker.setEditable(true);
		LocalDate a= datePicker.getValue();
		System.out.println("date "+a);
		
	}
	

	
	@FXML
	public void showDate(ActionEvent event) {
		datePicker.setEditable(true);
		LocalDate date = datePicker.getValue();
	    System.out.println("Selected date: " + date);
	    

	    
	   
	}


}
