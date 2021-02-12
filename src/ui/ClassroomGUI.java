package ui;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.stage.Stage;
import model.Classroom;
public class ClassroomGUI {

	private Classroom classroom;

	public ClassroomGUI(Classroom cr) {
		classroom= cr;
	}


	//register
	@FXML
	private FileChooser fileChooser;

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

	@FXML
	private RadioButton rbtnFemale;

	@FXML
	private RadioButton rbtnMale;


	@FXML
	private RadioButton rbtnOther;

	@FXML
	private RadioButton rbtnSoftware;

	@FXML
	private ToggleGroup genderG;

	@FXML
	private ToggleGroup careerG;

	@FXML
	private RadioButton rbtnTelematic;

	@FXML
	private RadioButton rbtnIdustrial;

	//register
	@FXML
	private  ComboBox<String> cboxFavBrowser;

	//register
	@FXML
	private Button btnBrowse;

	//register
	@FXML
	private File file;




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



	}

	//register
	@FXML
	public void fileBrowse(ActionEvent event) {

		fileChooser= new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("NEF", "*.nef") );
		Stage stage=new Stage();
		file= fileChooser.showOpenDialog(stage);
		lblFileDirector.setText("Nombre "+file.getPath());

	}

	//Register
	@FXML
	public void creeateAccount(ActionEvent event) {
		String genderS="";
		String careerS="";
		if(rbtnFemale.isSelected()) {
			genderS= "FEMALE";
		}else if(rbtnMale.isSelected()) {
			genderS= "MALE";
		}else if(rbtnOther.isSelected()) {
			genderS= "OTHER";
		}



		if(rbtnSoftware.isSelected()) {
			careerS="SOFTWARE_ENGINEERING";	
		}else if(rbtnTelematic.isSelected()) {
			careerS="TELEMATIC_ENGINEERING";
		}else if(rbtnIdustrial.isSelected()) {
			careerS="INDUSTRIAL_ENGINEERING";
		}


		try {
			classroom.CreateUser(
					txtNewUserName.getText(),
					txtNewPassword.getText(),
					file , 
					datePicker.getValue(), 
					genderS,
					careerS,
					cboxFavBrowser.getSelectionModel().getSelectedItem().toString());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Account created");
			alert.setHeaderText("The new account has been created");
			alert.showAndWait();
		}catch(NullPointerException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Validation Error");
			alert.setHeaderText("Youmust fill each field in the form");
			alert.showAndWait();
		}

	}

	@FXML
	public void returnToLogIn(ActionEvent event)throws IOException {
		loadLogin();
	}



	//main-pane
	@FXML
	public void SingIn(ActionEvent event) throws IOException{
		if(classroom.empty()) {
			System.out.println(txtPassword.getText());
		}
		System.out.println(txtUserName.getText().toString());
		if(classroom.signIn(txtUserName.getText().toString(),txtPassword.getText().toString() )) {
			loadAccountlist();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("log in incorrect");
			alert.setHeaderText("The username and password given are incorrect");
			alert.showAndWait();
		}

	}


	//solo cosa que quiero ver de la fecha del login
	@FXML
	public void showDate(ActionEvent event) {
		datePicker.setEditable(true);
		LocalDate date = datePicker.getValue();
	}

	@FXML
	public void loadAccountlist()throws IOException {
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("account-list.fxml"));
		fxmlLoader.setController(this);
		Parent loadAccountlist = fxmlLoader.load();
		mainPane.getChildren().setAll(loadAccountlist);

	}


}
