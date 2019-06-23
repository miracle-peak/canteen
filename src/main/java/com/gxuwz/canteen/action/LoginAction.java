package com.gxuwz.canteen.action;


import org.springframework.beans.factory.annotation.Autowired;
import com.gxuwz.canteen.entity.User;
import com.gxuwz.canteen.service.IUserSerivice;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements ModelDriven<User> ,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	@Autowired
	private IUserSerivice userSerivice;
	
	
	public String login() {
		boolean flag;
		flag = userSerivice.loginCheck(user);
		String dispatcher = "";
		if(flag == true) {
			if(user.getUtype().equals("0")){
				dispatcher = "buyer";
			}else if(user.getUtype().equals("1")){
				dispatcher = "worker";
			}else if(user.getUtype().equals("2")){
				dispatcher = "manager";
			}else if(user.getUtype().equals("3")){
				dispatcher = "cashier";
			}else if(user.getUtype().equals("4")){
				dispatcher = "accountant";
			}
		}else if(flag == false){
			dispatcher = "fail";
		}
		return dispatcher;
	}
	
	
	
	
	@Override
	public void prepare() throws Exception {
		if(user == null) {
			user = new User();
		}
	}

	@Override
	public User getModel() {
		return user;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
