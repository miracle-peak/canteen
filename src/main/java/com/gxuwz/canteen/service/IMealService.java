package com.gxuwz.canteen.service;

import java.util.List;

import com.google.zxing.common.BitMatrix;
import com.gxuwz.canteen.entity.Meal;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.vo.Pager;

public interface IMealService {
	/**
	 * 根据名称查询菜品套餐信息
	 */
	public List<Meal> find(Meal meal);
	/**
	 * 分页显示菜品套餐信息
	 */
	public Pager<Meal> findByPage(Integer pageSize, Integer pageNo, Meal meal);
	/**
	 * 保存菜品套餐信息
	 */
	public void save(Meal meal);
	/**
	 * 删除菜品套餐
	 */
	public void delete(int mealId);
	/**
	 * 根据id查询
	 */
	public Meal findById(Meal meal);
	/**
	 * 根据订餐id查询
	 */
	public Order findOrder(int orderId);
	/**
	 * 更新菜品套餐信息
	 */
	public void update(Meal meal);
	/**
	 * 查找所有菜品套餐信息
	 */
	public List<Meal> findAll();
	/**
	 * 查找所有菜品套餐信息(分页)
	 */
	public Pager<Meal> allPage(Integer pageSize, Integer pageNo);
	/**
	 * 保存订餐信息
	 */
	public void saveOrder(Order order);
	/**
	 * 查询个人订餐信息
	 */
	public List<Order> person(String workerId,  String startTime, String endTime);
	/**
	 * 查询个人订餐信息(分页)
	 */
	public Pager<Order> personPager(String workerId, String startTime, String endTime, Integer pageSize, Integer pageNo);
	/**
	 * 删除个人订餐信息
	 */
	public void deleteOrder(int orderId);
	/**
	 * 根据订单编号查询可取餐的订餐信息
	 */
	public Pager<Order> orderInfo(Integer pageSize, Integer pageNo, String orderId);
	/**
	 * 更新订餐的取餐状态
	 */
	public void updateOrder(String orderId);
	/**
	 * 取餐判断
	 */
	public Pager<Order> takeOrder(String workerId, Integer pageSize, Integer pageNo, String orderId);
	
}
