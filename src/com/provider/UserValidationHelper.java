package com.provider;

import com.bean.User;

public class UserValidationHelper {
	
	private User user[];
	public int userIndex;
	
	public UserValidationHelper(){
		user = new User[10];
		userIndex = 0;
	}
	
	public boolean validateUnP(String username, String password) {
		boolean valid = true;
		
		if (username.length()<3) {
			valid = false;
		}
		else if (password.length()<3) {
			valid = false;
		}
		else if(username.contains(" ")) {
			valid = false;
		}
		return valid;
	
	}
	
	public int getUserIndex(String username) {
		int index = -1;
		for(int i = 0; i<=userIndex;i++) {
			if (user[i] != null && username == user[i].getUsername()) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public User getUser(String username) {
		User user = null;
		int index = getUserIndex(username);
		if (index != -1) {
			user = this.user[index];
		}
		return user;
	}
	
	public boolean setUserDetails(String username, String password, 
						String question, String answer) {
		
		boolean status = false;
		if(validateUnP(username, password)) {
			if(getUserIndex(username)==-1) {
				userIndex+=1;
				user[userIndex].setUsername(username);
				user[userIndex].setPassword(password);
				user[userIndex].setQuestion(question);
				user[userIndex].setAnswer(answer);
				status = true;
			}
		}
		return status;
	}
	
	public boolean validateAnswer(String username, String answer) {
		return getUser(username).getAnswer().equals(answer);
	}
	
	public boolean validatePassword(String username, String password) {
		return getUser(username).getPassword().equals(password);
	}
}
