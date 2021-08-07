package com.serviceimpl;

import com.bean.Account;
import com.exceptions.InvalidAccountNoException;
import com.service.AccountServices;
import com.provider.ValidationHelper;


public class AccountServiceImpl implements AccountServices{

	ValidationHelper helper;
	
	public AccountServiceImpl() {
		
		helper = new ValidationHelper();
	}
	
	public int openAccount(String type, float amt) {
		
		int newAccNo = helper.prevAccNo+1;
		
		helper.accounts[helper.accIndex] = new Account(newAccNo, type, amt);
		
		helper.prevAccNo = helper.accounts[helper.accIndex].getAccNo();
		helper.accIndex++;
		return newAccNo;
	}
	
	
	
	
	public float deposit(int accNo, float amt) {
		float modifiedBal = 0.0f;
		
		if(helper.checkAccNo(accNo) && amt>0) {
			Account acc = helper.accounts[helper.getAccIndex(accNo)];
			float currentBal = acc.getAccBal();
			acc.setAccBal(currentBal + amt);
			modifiedBal = acc.getAccBal();
		}
		else {
			System.out.println("Error in transcation");
		}
		return modifiedBal;
	}
	
	public float withdraw(int accNo, float amt) {
		float modifiedBal = 0.0f;
		if(helper.checkAccNo(accNo) && amt>0) {
			Account acc = helper.accounts[helper.getAccIndex(accNo)];
			float currentBal = acc.getAccBal();
			if (currentBal<amt) {
				System.out.println("Insufficient funds");
				return currentBal;
			}
			
			acc.setAccBal(currentBal - amt);
			modifiedBal = acc.getAccBal();
		}
		else {
			System.out.println("Error in transcation");
		}
		return modifiedBal;
	}
	
	public String getAccDetails(int accNo) throws InvalidAccountNoException{
		String details;
		if(helper.checkAccNo(accNo)) {
			Account acc = helper.accounts[helper.getAccIndex(accNo)];
			details = acc.toString();
		}
		else {
			details = "Error fetching account details for acc no : "+accNo;
			throw new InvalidAccountNoException();
		}
		return details;
	}
	
	
	
	public float fundTransfer(int accNo, int accNo2, float amt) {
		
		float modifiedBalSender = 0.0f;
		String msg = "Transfer of "+amt+" to "+accNo2+" is Successful";
		
		if (helper.checkAccNo(accNo) && helper.checkAccNo(accNo2)) {
			Account acc = helper.accounts[helper.getAccIndex(accNo)];
			Account acc2 = helper.accounts[helper.getAccIndex(accNo2)];
			
			float currentBalSender = acc.getAccBal();
			float currentBalReceiver = acc2.getAccBal();
			
			modifiedBalSender = withdraw(accNo,amt);
			if (modifiedBalSender!=currentBalSender) {
				float modifiedBalReceiver = deposit(acc2.getAccNo(),amt);
				if (modifiedBalReceiver==currentBalReceiver) {
					deposit(accNo,amt);
					msg = "Transfer Failed";
				}
			}
			else
			{
				msg = "Transfer Failed";
			}
		}
		else {
			msg = "Transfer Failed";
		}

		System.out.println(msg);
		return modifiedBalSender;
	}
}
