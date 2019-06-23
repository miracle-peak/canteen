package com.gxuwz.canteen.entity;

public class Order {
	private int orderId;
	private String mealName;
	private String orderNumber;
	private String orderTime;
	private String workerId;
	private int mealId;
	private String mealPrice;
	private String telephone;
	private String status;
	
	public Order() {
		super();
	}
	public Order(int orderId, String mealName, String orderNumber, String orderTime, String workerId, int mealId,
			String mealPrice, String telephone, String status) {
		super();
		this.orderId = orderId;
		this.mealName = mealName;
		this.orderNumber = orderNumber;
		this.orderTime = orderTime;
		this.workerId = workerId;
		this.mealId = mealId;
		this.mealPrice = mealPrice;
		this.telephone = telephone;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public String getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(String mealPrice) {
		this.mealPrice = mealPrice;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
