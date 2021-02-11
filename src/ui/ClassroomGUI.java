package ui;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Classroom;
public class ClassroomGUI {

	private Classroom classroom;
	
	public ClassroomGUI(Classroom cr) {
		classroom= cr;
	}
	private final ToggleGroup genderG= new ToggleGroup();
	private final ToggleGroup careerG= new ToggleGroup();
	
	//register
	@FXML
	FileChooser fileChooser;
	
	//mainPane
	@FXML
	private Pane mainPane;
	
	//register
	@FXML
	private DatePicker datePicker = new DatePicker();	
	
	//login
	@FXML
	private TextField txtUserName;

	//login
	@FXML
	private TextField txtPassword;

	//login
	@FXML
	private Button btnSingIn;

	//login
	@FXML
	private Button btnLogIn;
	
	//register
	@FXML
	private TextField txtNewUserName;
	
	//register
	@FXML
	private TextField txtNewPassword;

	//register
	@FXML
	private Label lblFileDirector;

	//register
	@FXML
	private RadioButton rbtnMale;

	//register
	@FXML
	private RadioButton rbtnFemale;

	//register
	@FXML
	private RadioButton rbtnOther;

	//register
	@FXML
	private RadioButton rbtnSoftware;

	//register
	@FXML
	private RadioButton rbtnTelematic;

	//register
	@FXML
	private RadioButton rbtnIdustrial;

	//register
	@FXML
	private  ComboBox cboxFavBrowser;

	//register
	@FXML
	private Button btnBrowse;

	
	@FXML 
	public void initialize() throws IOException {
    

		
	}
	
	@FXML
    public void reeeeeeee(ActionEvent event)throws IOException {
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("login.fxml"));
    	fxmlLoader.setController(this);
    	Parent login = fxmlLoader.load();
    	mainPane.getChildren().setAll(login);
    }

	
	
	@FXML
	public void loadLogin()throws IOException {
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("login.fxml"));
    	fxmlLoader.setController(this);
    	Parent login = fxmlLoader.load();
    	mainPane.getChildren().setAll(login);
		
	}

	//goes from login to register
	@FXML
	public void register(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("register.fxml"));
    	fxmlLoader.setController(this);
    	Parent register = fxmlLoader.load();
    	mainPane.getChildren().setAll(register);
    	cboxFavBrowser.getItems().addAll("adwad","asdawdaw","asdawdasdaw");
    	rbtnMale = new RadioButton("Male");
    	rbtnMale.setToggleGroup(genderG);
    	

    	rbtnFemale= new RadioButton("Female");
    	rbtnFemale.setToggleGroup(genderG);

    	rbtnOther= new RadioButton("Other");
    	rbtnOther.setToggleGroup(genderG);

    	rbtnSoftware= new RadioButton();
    	rbtnSoftware.setToggleGroup(careerG);

    	rbtnTelematic= new RadioButton();
    	rbtnTelematic.setToggleGroup(careerG);

    	rbtnIdustrial= new RadioButton();
    	rbtnIdustrial.setToggleGroup(careerG);
    	

	}

	//main-pane
	@FXML
	public void SingIn(ActionEvent event) {
		datePicker.setEditable(true);
		LocalDate a= datePicker.getValue();
		System.out.println("date "+a);
		
	}
	

	//solo cosa que quiero ver de la fecha del login
	@FXML
	public void showDate(ActionEvent event) {
		datePicker.setEditable(true);
		LocalDate date = datePicker.getValue();
	    System.out.println("Selected date: " + date);
	    

	    
	   
	}


}
