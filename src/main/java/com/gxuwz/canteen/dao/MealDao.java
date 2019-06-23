package com.gxuwz.canteen.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.gxuwz.canteen.entity.Meal;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.vo.Pager;

@Repository("MealDao")
public class MealDao extends BaseDao{
	/**
	 * 根据名称查询菜品套餐信息
	 */
	public List<Meal> find(Meal meal){
		String hql = "from Meal where 1 =1 ";
		if(meal.getMealName() != null&&!meal.getMealName().equals("")) {
			hql = hql+"and mealName like '%"+meal.getMealName()+"%'";
		}
//		System.out.println(hql);
		List<Meal> list = this.hibernateTemplate.find(hql);
		return list;
	}
	/**
	 * 分页显示菜品套餐信息
	 */
	public Pager<Meal> findByPage(Integer pageSize, Integer pageNo, Meal meal){
		List<Meal> list = find(meal);
		Pager<Meal> pager = new Pager<Meal>(pageSize, pageNo, list);
		return pager;
	}
	/**
	 * 保存菜品套餐信息
	 */
	public void save(Meal meal) {
		this.hibernateTemplate.save(meal);
	}
	/**
	 * 删除菜品套餐
	 */
	public void delete(int mealId) {
		String hql = "delete from Meal where mealId = "+mealId;
		this.hibernateTemplate.bulkUpdate(hql);
	}
	/**
	 * 根据菜品套餐id查询
	 */
	public Meal findById(Meal meal) {
		String hql = "from Meal where mealId = "+meal.getMealId();
		List<Meal> list =this.hibernateTemplate.find(hql);
		if(list.size() != 0&&!list.isEmpty()) {
			meal = list.get(0);
		}
		return meal;
	}
	/**
	 * 根据订餐id查询
	 */
	public Order findOrder(int orderId) {
		Order order = new Order();
		String hql = "from Order where orderId = '"+orderId+"'";
		List<Order> list = this.hibernateTemplate.find(hql);
		if(list.size() != 0&&!list.isEmpty()) {
			order = list.get(0);
		}
		return order;
	}
	/**
	 * 更新菜品套餐信息
	 */
	public void update(Meal meal) {
		this.hibernateTemplate.update(meal);
	}
	/**
	 * 查找所有菜品套餐信息
	 */
	public List<Meal> findAll(){
		String hql = "from Meal";
		List<Meal> list = this.hibernateTemplate.find(hql);
		return list;
	}
	/**
	 * 查找所有菜品套餐信息(分页)
	 */
	public Pager<Meal> allPage(Integer pageSize, Integer pageNo) {
		List<Meal> list = findAll();
		Pager<Meal> pager = new Pager<Meal>(pageSize, pageNo, list);
		return pager;
	}
	/**
	 * 保存订餐信息
	 */
	public void saveOrder(Order order) {
		this.hibernateTemplate.save(order);
	}
	/**
	 * 查询个人订餐信息
	 */
	public List<Order> person(String workerId, String startTime, String endTime){
		String hql = "from Order where workerId = '"+workerId+"'";
		if(startTime != null&&!startTime.equals("")) {
			hql = hql+" and orderTime >= '"+startTime+"'";
		}
		if(endTime != null&&!endTime.equals("")) {
			hql = hql+"and orderTime <= '"+endTime+"'";
		}
		System.out.println(hql);
		List<Order> list = this.hibernateTemplate.find(hql);
		return list;
	}
	/**
	 * 查询个人订餐信息(分页)
	 */
	public Pager<Order> personPager(String workerId, String startTime, String endTime, Integer pageSize, Integer pageNo){
		List<Order> list = person(workerId, startTime, endTime);
		Pager<Order> pager = new Pager<Order>(pageSize, pageNo, list);
		return pager;
	}
	/**
	 * 删除个人订餐信息
	 */
	public void deleteOrder(int orderId) {
		String hql = "delete from Order where orderId ="+orderId;
		System.out.println(hql);
		this.hibernateTemplate.bulkUpdate(hql);
		
	}
	/**
	 * 根据订单编号查询可取餐的订餐信息
	 */
	public Pager<Order> orderInfo(Integer pageSize, Integer pageNo, String orderId){
		//获取当前时间
		Date time = null;
		Date data = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//判断订餐信息是否过期
			time = dateFormat.parse(dateFormat.format(data.getTime()-60 * 60 * 1000 * 3));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hql = "FROM Order WHERE status = '未取餐'  and orderTime >'"+dateFormat.format(time)+"'";
		if(orderId != null&&!"".equals(orderId)) {
			hql+=" and orderId = "+orderId;
		}
		List<Order> list = this.hibernateTemplate.find(hql);
		Pager<Order> pager = new Pager<Order>(pageSize, pageNo, list);
		
		return pager;
	}
	/**
	 * 更新订餐的取餐状态
	 */
	public void updateOrder(String orderId) {
		String hql = "update Order set status = '已取餐'  where orderId = "+orderId;
		this.hibernateTemplate.bulkUpdate(hql);
	}
	/**
	 * 取餐判断
	 */
	public Pager<Order> takeOrder(String workerId, Integer pageSize, Integer pageNo, String orderId){
		//获取当前时间
		Date time = null;
		Date data = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//判断订餐信息是否过期
			time = dateFormat.parse(dateFormat.format(data.getTime()-60 * 60 * 1000 * 3));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("time==="+dateFormat.format(time));
		String hql = "FROM Order WHERE status = '未取餐'  and workerId ='"+workerId+"' and orderTime >'"+dateFormat.format(time)+"'";
//		String hql = "FROM Order WHERE DATE_SUB(NOW(),INTERVAL  2 HOUR)< orderTime and workerId ='"+workerId+"'";
		if(orderId != null&&!"".equals(orderId)) {
			hql+=" and orderId = "+orderId;
		}
		List<Order> list = this.hibernateTemplate.find(hql);
		Pager<Order> pager = new Pager<Order>(pageSize, pageNo, list);
		
		return pager;
	}
	
}
