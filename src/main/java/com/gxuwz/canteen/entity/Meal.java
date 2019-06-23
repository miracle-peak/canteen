package com.gxuwz.canteen.entity;

public class Meal {
	private int mealId;
	private String mealName;
	private String mealDescribe;
	private String mealPrice;
	
	public Meal() {
		super();
	}
	
	public Meal(int mealId, String mealName, String mealDescribe, String mealPrice) {
		super();
		this.mealId = mealId;
		this.mealName = mealName;
		this.mealDescribe = mealDescribe;
		this.mealPrice = mealPrice;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getMealDescribe() {
		return mealDescribe;
	}
	public void setMealDescribe(String mealDescribe) {
		this.mealDescribe = mealDescribe;
	}
	public String getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(String mealPrice) {
		this.mealPrice = mealPrice;
	}
	
}
