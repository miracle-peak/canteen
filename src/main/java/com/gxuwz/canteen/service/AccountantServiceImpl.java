package com.gxuwz.canteen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxuwz.canteen.dao.AccountantDao;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.vo.Pager;

@Service("AccountantServiceImpl")
public class AccountantServiceImpl implements IAccountantService{
	@Autowired
	private AccountantDao accountantDao;
	
	@Override
	public List<Order> find(String workerId, String startTime, String endTime) {
		return accountantDao.find(workerId, startTime, endTime);
	}

	@Override
	public Pager<Order> findByPage(String workerId, String startTime, String endTime, Integer pageSize,
			Integer pageNo) {
		return accountantDao.findByPage(workerId, startTime, endTime, pageSize, pageNo);
	}

}
