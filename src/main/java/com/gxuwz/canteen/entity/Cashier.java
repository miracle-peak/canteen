package com.gxuwz.canteen.entity;

public class Cashier {
	private String cashierId;
	private String cashierName;
	
	public Cashier() {
		super();
	}
	public Cashier(String cashierId, String cashierName) {
		super();
		this.cashierId = cashierId;
		this.cashierName = cashierName;
	}
	public String getCashierId() {
		return cashierId;
	}
	public void setCashierId(String cashierId) {
		this.cashierId = cashierId;
	}
	public String getCashierName() {
		return cashierName;
	}
	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}
	
}
