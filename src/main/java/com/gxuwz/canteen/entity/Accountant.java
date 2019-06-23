package com.gxuwz.canteen.entity;

public class Accountant {
	private String accountantId;
	private String accountantName;
	public Accountant() {
		super();
	}
	public Accountant(String accountantId, String accountantName) {
		super();
		this.accountantId = accountantId;
		this.accountantName = accountantName;
	}

	public String getAccountantId() {
		return accountantId;
	}
	public void setAccountantId(String accountantId) {
		this.accountantId = accountantId;
	}
	public String getAccountantName() {
		return accountantName;
	}
	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}
	
}
