package com.gxuwz.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxuwz.canteen.dao.UserDao;
import com.gxuwz.canteen.entity.User;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserSerivice{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean loginCheck(User user) {
		return userDao.loginCheck(user);
	}

}
