package com.gxuwz.canteen.service;

import java.util.List;

import com.gxuwz.canteen.entity.Buyer;
import com.gxuwz.canteen.entity.Purchase;
import com.gxuwz.canteen.vo.Pager;

public interface IPurchaseService {
	/**
	 * 根据采购日期查询采购清单信息
	 */
	public Pager<Purchase> find(Integer pageSize, Integer pageNo,String startTime, String endTime);
	/**
	 * 根据时间查询全部采购清单信息(分页)
	 */
	public Pager<Purchase> allByPager(Integer pageSize, Integer pageNo, String startTime, String endTime);
	/**
	 * 查询所有采购清单信息
	 * @return
	 */
	public List<Purchase> findAll();
	/**
	 * 查询所有采购清单信息(分页)
	 * @return
	 */
	public Pager<Purchase> allPage(Integer pageSize, Integer pageNo);
	/**
	 * 保存采购清单信息
	 */
	public void save(Purchase purchase);
	
	/**
	 * 删除采购清单信息
	 */
	public void delete(int purchaseId);
	/**
	 * 根据id查询采购清单信息
	 */
	public Purchase findById(Purchase purchase);
	/**
	 * 更新采购清单信息
	 */
	public void update(Purchase purchase);
	/**
	 * 查询采购员信息
	 */
	public Buyer findBuyer(String  buyerId);
	/**
	 * 更新审核清单信息
	 */
	public void updateExainme(Purchase purchase);
	/**
	 * 查询采购清单信息（分页）
	 */
	public Pager<Purchase> findByPager(Integer pageSize, Integer pageNo, Purchase purchase);
}
