package com.provider;

import com.serviceimpl.AccountServiceImpl;

public class BusinessObjectProvider {
	public static AccountServiceImpl createObject() {
			
		return new AccountServiceImpl();
	}
}
