package com.gxuwz.canteen.entity;

public class Worker {
	private String workerId;
	private String workerName;
	private String telephone;
	public Worker() {
		super();
	}
	public Worker(String workerId, String workerName, String telephone) {
		super();
		this.workerId = workerId;
		this.workerName = workerName;
		this.telephone = telephone;
	}

	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
