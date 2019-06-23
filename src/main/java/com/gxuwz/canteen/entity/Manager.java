package com.gxuwz.canteen.entity;

public class Manager {
	private String managerNo;
	private String managerName;
	
	public Manager() {
		super();
	}
	public Manager(String managerNo, String managerName) {
		super();
		this.managerNo = managerNo;
		this.managerName = managerName;
	}
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
}
