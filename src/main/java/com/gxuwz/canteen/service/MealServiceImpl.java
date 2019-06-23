package com.gxuwz.canteen.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.gxuwz.canteen.dao.MealDao;
import com.gxuwz.canteen.entity.Meal;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.vo.Pager;
@Service("MealServiceImpl")
public class MealServiceImpl implements IMealService{
	@Autowired
	private MealDao mealDao;
	
	@Override
	public List<Meal> find(Meal meal) {
		return mealDao.find(meal);
	}

	@Override
	public void save(Meal meal) {
		mealDao.save(meal);
	}

	@Override
	public void delete(int mealId) {
		mealDao.delete(mealId);
	}

	@Override
	public Meal findById(Meal meal) {
		return mealDao.findById(meal);
	}

	@Override
	public void update(Meal meal) {
		mealDao.update(meal);
	}

	@Override
	public List<Meal> findAll() {
		return mealDao.findAll();
	}

	@Override
	public void saveOrder(Order order) {
		mealDao.saveOrder(order);
	}

	@Override
	public List<Order> person(String workerId, String startTime, String endTime){
		return mealDao.person(workerId, startTime,endTime);
	}

	@Override
	public void deleteOrder(int orderId) {
		mealDao.deleteOrder(orderId);
	}
	
	@Override
	public Pager<Order> takeOrder(String workerId, Integer pageSize, Integer pageNo, String orderId) {
		return mealDao.takeOrder(workerId, pageSize, pageNo, orderId);
	}

	@Override
	public Pager<Meal> findByPage(Integer pageSize, Integer pageNo, Meal meal) {
		return mealDao.findByPage(pageSize, pageNo, meal);
	}

	@Override
	public Pager<Meal> allPage(Integer pageSize, Integer pageNo) {
		return mealDao.allPage(pageSize, pageNo);
	}

	@Override
	public Pager<Order> personPager(String workerId, String startTime, String endTime, Integer pageSize,
			Integer pageNo) {
		return mealDao.personPager(workerId, startTime, endTime, pageSize, pageNo);
	}

	@Override
	public Order findOrder(int orderId) {
		return mealDao.findOrder(orderId);
	}

	@Override
	public void updateOrder(String orderId) {
		mealDao.updateOrder(orderId);
	}
	@Override
	public Pager<Order> orderInfo(Integer pageSize, Integer pageNo, String orderId) {
		return mealDao.orderInfo(pageSize, pageNo, orderId);
	}


}
