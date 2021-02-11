package model;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class Classroom {
	private ArrayList<UserAccount> users;
	private Gender gender;
	private Career career;
	
	
	public ArrayList<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserAccount> users) {
		this.users = users;
	}

	public Classroom(ArrayList<UserAccount> users) {
		this.users = users;
	}
	
	public Classroom() {}
	
	public void CreateUser(String username, String password, File photo, LocalDate date, String genderS, String careerS,String browser) {
	    gender= gender.valueOf(genderS.toUpperCase());
		career= career.valueOf(careerS.toUpperCase());
		users.add(new UserAccount( username,  password,  photo,  date,  gender,  career, browser) );
	}
	
	
	
}
