package com.service;

public interface LoginServices {
	boolean signUp(String username, String password, String question, 
			String answer);
	boolean signIn(String username, String password);
	boolean forgetPass(String username, String answer, 
			String new_password);
	boolean change_password(String username, String password, 
			String new_password);
}
