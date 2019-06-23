package com.gxuwz.canteen.service;

import java.util.List;

import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.vo.Pager;

public interface IAccountantService {
	/**
	 * 查询员工的订餐记录
	 */
	public List<Order> find(String workerId, String startTime, String endTime);
	/**
	 * 分页显示员工订餐记录
	 * @param workerId
	 * @param startTime
	 * @param endTime
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager<Order> findByPage(String workerId, String startTime, String endTime,Integer pageSize, Integer pageNo);
}
