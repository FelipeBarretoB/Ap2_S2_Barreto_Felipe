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
	
	public Classroom() {
		users= new ArrayList<>();
		
	}
	
	public void CreateUser(String username, String password, File photo, LocalDate date, String genderS, String careerS,String browser) {
	    gender= Gender.valueOf(genderS.toUpperCase());
		career= Career.valueOf(careerS.toUpperCase());
		users.add(new UserAccount( username,  password,  photo,  date,  gender,  career, browser) );
		
	}
	
	
	public boolean signIn(String username, String password) {
		boolean singin=false;
		
		for(int c=0; c<users.size();c++) {
			System.out.println("loop");
			if(username.equals(users.get(c).getUsername())) {
				System.out.println("encontro user");
				if(password.equals(users.get(c).getPassword())) {
					singin=true;
				}
				
			}
			
		}
		return singin;
	}
	
	
	public int signInC(String username, String password) {
		int x=0;
		
		for(int c=0; c<users.size();c++) {
			System.out.println("loop");
			if(username.equals(users.get(c).getUsername())) {
				System.out.println("encontro user");
				if(password.equals(users.get(c).getPassword())) {
					x=c;
				}
				
			}
			
		}
		return x;
	}
	
	public UserAccount getUser(int c) {
		return users.get(c);
	}
	
	public boolean empty() {
		return users.isEmpty();
	}
	
}
