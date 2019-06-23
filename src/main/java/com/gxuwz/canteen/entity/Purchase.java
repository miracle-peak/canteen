package com.gxuwz.canteen.entity;

public class Purchase {
	private int purchaseId;
	private String foodName;
	private String foodPrice;
	private String totalAmount;
	private String number;
	private String supplier;
	private String purchaseTime;
	private String buyer;
	private String status;
	private String opinion;
	
	public Purchase() {
		super();
	}
	public Purchase(int purchaseId, String foodName, String foodPrice, String totalAmount, String number,
			String supplier, String purchaseTime, String buyer, String status, String opinion) {
		super();
		this.purchaseId = purchaseId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.totalAmount = totalAmount;
		this.number = number;
		this.supplier = supplier;
		this.purchaseTime = purchaseTime;
		this.buyer = buyer;
		this.status = status;
		this.opinion = opinion;
	}

	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
}
