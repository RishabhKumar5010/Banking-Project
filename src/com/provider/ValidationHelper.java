package com.provider;

import com.bean.Account;

public class ValidationHelper {
	
	public Account accounts[];
	public int prevAccNo;
	public int accIndex;
	
	public ValidationHelper(){
		accounts = new Account[10];
		prevAccNo = 100;
		accIndex = 0;
	}
	
	public int getAccIndex(int accNo) {
		int index = -1;
		for(int i = 0; i<=accIndex;i++) {
			if (accounts[i] != null && accNo == accounts[i].getAccNo()) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public boolean checkAccNo(int accNo) {
		if (getAccIndex(accNo)!=(-1)) {
			return true;
		}
		return false;
	}
	

}
