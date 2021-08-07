package com.serviceimpl;

import com.provider.UserValidationHelper;
import com.service.LoginServices;

public class LoginServiceImpl implements LoginServices{

	UserValidationHelper helper;
	public LoginServiceImpl(){
		helper = new UserValidationHelper();
	}
	
	@Override
	public boolean signUp(String username, String password, String question, 
			String answer) {
		
		boolean status = helper.setUserDetails(username, 
				password, question, answer);
		
		return status;
	}

	@Override
	public boolean signIn(String username, String password) {
		boolean status = false;
		
		if (helper.getUserIndex(username)!=-1) {
			if (helper.validatePassword(username, password)) {
				status = true;
			}
		}
		return status;
	}

	@Override
	public boolean forgetPass(String username, String answer, 
			String new_password) {
		boolean status = false;
		if (helper.validateAnswer(username, answer)) {
			status = change_password(username,
					helper.getUser(username).getPassword(), new_password);
		}
		else {
			System.out.println("Wrong answer |"+answer+"|");
		}
		return status;
	}
	
	
	public boolean change_password(String username, String password, 
			String new_password) {
		
		boolean status = false;
		if(helper.validatePassword(username,password)) {
			helper.getUser(username).setPassword(password);
			status = true;
		}
		return status;
	}

}
