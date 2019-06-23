package com.gxuwz.canteen.dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;
import com.gxuwz.canteen.entity.User;

@Repository("UserDao")
public class UserDao extends BaseDao{

	/**
	 * 登录检测
	 * @param user
	 * @return
	 */
	public boolean loginCheck(User user) {
		boolean flag;
		String usetType = ""; // 登录用户类型
		String name = "";  // 登录用户账号
		if(user.getUtype().equals("0")) {
			usetType = "Buyer";
			name = "buyerId";
		}else if(user.getUtype().equals("1")){
			usetType = "Worker";
			name = "workerId";
		}else if(user.getUtype().equals("2")){
			usetType = "Manager";
			name = "managerNo";
		}else if(user.getUtype().equals("3")){
			usetType = "Cashier";
			name = "cashierId";
		}else if(user.getUtype().equals("4")){
			usetType = "Accountant";
			name = "accountantId";
		}
		String hql = "from "+usetType+" where "+name+" = '"+user.getUserName()+"' and password = '"+user.getPassword()+"'";
		System.out.println(hql);
		//保存登录用户对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("User", user);
//		System.out.println("保存成功");
		List list = this.hibernateTemplate.find(hql);
		if(list.size()==0) {
			flag = false;
		}else {
			flag = true;
		}
		return flag;
	}
}
