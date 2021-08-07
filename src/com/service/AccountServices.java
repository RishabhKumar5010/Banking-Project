package com.service;

import com.exceptions.InvalidAccountNoException;

public interface AccountServices {
	int openAccount(String type, float amt);
	float deposit(int accNo, float amt);
	float withdraw(int accNo, float amt);
	String getAccDetails(int accNo) throws InvalidAccountNoException;
	public float fundTransfer(int accNo, int accNo2, float amt);
}
