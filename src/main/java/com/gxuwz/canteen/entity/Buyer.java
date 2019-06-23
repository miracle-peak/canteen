package com.gxuwz.canteen.entity;

public class Buyer {
	private String buyerId;
	private String buyerName;
	public Buyer() {
		super();
	}
	public Buyer(String buyerId, String buyerName) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
	}

	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
}
