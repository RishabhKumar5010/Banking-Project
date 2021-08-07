package com.bean;

public class Account {
	
	private int accNo;
	private String accType;
	private float accBal;
	
	public Account() {
		System.out.println("chala..");
		accNo = 0;
		accType = null;
		accBal = 0;
	}
	
	public Account(int accNo, String accType, float accBal) {
		this.accNo = accNo;
		this.accType = accType;
		this.accBal = accBal;
	}
	/**
	 * @return the accNo
	 */
	public int getAccNo() {
		return accNo;
	}
	/**
	 * @param accNo the accNo to set
	 */
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	/**
	 * @return the accType
	 */
	public String getAccType() {
		return accType;
	}
	/**
	 * @param accType the accType to set
	 */
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	/**
	 * @return the accBal
	 */
	public float getAccBal() {
		return accBal;
	}
	/**
	 * @param accBal the accBal to set
	 */
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	
	public String toString() {
		return "Employee details: Acc no: "+accNo+
				"\nType: "+accType+"\nBalance: "+accBal;
		}
	
}
