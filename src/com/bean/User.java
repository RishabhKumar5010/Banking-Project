package com.bean;



public class User {

	private String username;
	private String password;
	private String question;
	private String answer;
	private Account account;
	
	
	public User(){
		username = null;
		password = null;
		question = null;
		answer = null;
		account = null;
	}
	
	public User(String username, String password, String question, String answer,
			Account account){
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.account = account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

	public String toString() {
		return "Username : "+username+
				"\nSecurity question"+question;
	}
	
	
}
