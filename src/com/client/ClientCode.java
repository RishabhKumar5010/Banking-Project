package com.client;

import com.service.AccountServices;
import com.exceptions.InvalidAccountNoException;
import com.provider.BusinessObjectProvider;



public class ClientCode {

	public static void main(String[] args) {
		
		AccountServices bank = BusinessObjectProvider.createObject();
		
		int accNo1 = bank.openAccount("savings", 10000);
		System.out.println("Successfully opened account");
		
		int accNo2 = bank.openAccount("current", 50000);
		System.out.println("Successfully opened account");
		
		float bal = bank.withdraw(accNo1, 1000);
		System.out.println("Updated balance : "+bal);
		
		bal = bank.deposit(accNo1, 2000);
		System.out.println("Updated balance : "+bal);
		
		String accData;
		
		try {
		accData = bank.getAccDetails(accNo1+5);
		System.out.println("Details : "+accData);
		}
		
		catch(InvalidAccountNoException e) {
			e.printStackTrace();
		}
		
		try {
		accData = bank.getAccDetails(accNo2);
		System.out.println("Details : "+accData);
		}
		catch(InvalidAccountNoException e) {
			e.printStackTrace();
		}
		
		
		bal = bank.fundTransfer(accNo1, accNo2, 7000);
		
		try {
		accData = bank.getAccDetails(accNo1);
		System.out.println("Details : "+accData);
		}
		catch(InvalidAccountNoException e) {
			e.printStackTrace();
		}
		
		try {
		accData = bank.getAccDetails(accNo2);
		System.out.println("Details : "+accData);
		}
		catch(InvalidAccountNoException e) {
			e.printStackTrace();
		}
		
	}

}
