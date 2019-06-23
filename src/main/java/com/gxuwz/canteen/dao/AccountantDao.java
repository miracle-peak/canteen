package com.gxuwz.canteen.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.vo.Pager;
@Repository("AccountantDao")
public class AccountantDao extends BaseDao{
	/**
	 * 查询员工的订餐记录
	 */
	public List<Order> find(String workerId, String startTime, String endTime){
		String hql = "from Order where 1 = 1";
		if(workerId != null&&!workerId.equals("")) {
			hql = hql+" and workerId = '"+workerId+"'";
		}
		if(startTime != null&&!startTime.equals("")) {
			hql = hql+" and orderTime >= '"+startTime+"'";
		}
		if(endTime != null&&!endTime.equals("")) {
			hql = hql+"and orderTime <= '"+endTime+"'";
		}
		List<Order> list = this.hibernateTemplate.find(hql);
		return list;
	}
	/**
	 * 分页显示员工订餐记录
	 * @param workerId
	 * @param startTime
	 * @param endTime
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager<Order> findByPage(String workerId, String startTime, String endTime,Integer pageSize, Integer pageNo){
		List<Order> list = find(workerId, startTime, endTime);
		Pager<Order> pager = new Pager<Order>(pageSize, pageNo, list);
		return pager;
	}
	
}
