package com.gxuwz.canteen.dao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.gxuwz.canteen.entity.Buyer;
import com.gxuwz.canteen.entity.Purchase;
import com.gxuwz.canteen.entity.User;
import com.gxuwz.canteen.vo.Pager;

@Repository("PurchaseDao")
public class PurchaseDao extends BaseDao{
	
	/**
	 * 根据采购日期查询采购清单信息
	 */
	public Pager<Purchase> find(Integer pageSize, Integer pageNo,String startTime, String endTime){
		//获取采购员名称
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("User");
		Buyer buyer = new Buyer();
		buyer = findBuyer(user.getUserName());
		String hql = "from Purchase where status = '0' and buyer = '"+buyer.getBuyerName()+"'";
		if(startTime != null&&!startTime.equals("")) {
			hql = hql+" and purchaseTime >= '"+startTime+"'";
		}
		if(endTime != null&&!endTime.equals("")) {
			hql = hql+"and purchaseTime <= '"+endTime+"'";
		}
		System.out.println(hql);
		List<Purchase> list = this.hibernateTemplate.find(hql);
		Pager<Purchase> pager = new Pager<Purchase>(pageSize, pageNo, list);
		return pager;
	}
	/**
	 *根据采购员查询采购清单信息（分页）
	 */
	public Pager<Purchase> findByPager(Integer pageSize, Integer pageNo, Purchase purchase){
		String hql = "from Purchase where  status = '0' "; 
		if(purchase.getBuyer()!=null&&!"".equals(purchase.getBuyer())) {
			hql+=" and buyer like '%"+purchase.getBuyer()+"%'";
		}
		System.out.println(hql);
		List<Purchase> list = this.hibernateTemplate.find(hql);
		Pager<Purchase> pager = new Pager<Purchase>(pageSize, pageNo, list);
		System.out.println("flag==="+pager.isFlag());
		return pager;
	}
	/**
	 * 根据时间查询当前采购员的全部采购清单信息(分页)
	 */
	public Pager<Purchase> allByPager(Integer pageSize, Integer pageNo, String startTime, String endTime){
		//获取采购员名称
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("User");
		Buyer buyer = new Buyer();
		buyer = findBuyer(user.getUserName());
		String hql = "from Purchase where buyer = '"+buyer.getBuyerName()+"'";
		if(startTime != null&&!startTime.equals("")) {
			hql = hql+" and purchaseTime >= '"+startTime+"'";
		}
		if(endTime != null&&!endTime.equals("")) {
			hql = hql+"and purchaseTime <= '"+endTime+"'";
		}
		List<Purchase> list = this.hibernateTemplate.find(hql);
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).getOpinion() == null|| list.get(i).getOpinion().equals("")) {
				list.get(i).setOpinion("");
			}
			if(list.get(i).getStatus().equals("0")) {
				list.get(i).setStatus("未审核");
			}else if(list.get(i).getStatus().equals("1")) {
				list.get(i).setStatus("不同意");
			}
			else if(list.get(i).getStatus().equals("2")) {
				list.get(i).setStatus("同意");
			}
		}
		Pager<Purchase> pager = new Pager<Purchase>(pageSize, pageNo, list);
		return pager;
	}
	/**
	 * 查询所有采购清单信息
	 * @return
	 */
	public List<Purchase> findAll(){
		String hql = "from Purchase where status = '0'";
		List<Purchase> list = this.hibernateTemplate.find(hql);
		return list;
	}
	/**
	 * 查询所有采购清单信息(分页)
	 * @return
	 */
	public Pager<Purchase> allPage(Integer pageSize, Integer pageNo){
		List<Purchase> list = findAll();
		Pager<Purchase> pager = new Pager<Purchase>(pageSize, pageNo, list);
		return pager;
	}
	/**
	 * 保存采购清单信息
	 */
	public void save(Purchase purchase) {
		this.hibernateTemplate.save(purchase);
	}
	
	/**
	 * 删除采购清单信息
	 */
	public void delete(int purchaseId) {
		String hql = "delete from Purchase where purchaseId = "+purchaseId;
		this.hibernateTemplate.bulkUpdate(hql);
	}
	/**
	 * 根据id查询采购清单信息
	 */
	public Purchase findById(Purchase purchase) {
		String hql = "from Purchase where purchaseId = "+purchase.getPurchaseId();
		List<Purchase> list = this.hibernateTemplate.find(hql);
		if(list.size() != 0) {
			purchase = list.get(0);
		}
		return purchase;
	}
	/**
	 * 更新采购清单信息
	 */
	public void update(Purchase purchase) {
		this.hibernateTemplate.saveOrUpdate(purchase);
	}
	/**
	 * 查询采购员信息
	 */
	public Buyer findBuyer(String  buyerId) {
		String hql = "from Buyer where buyerId ="+buyerId;
		List<Buyer> list = this.hibernateTemplate.find(hql);
		Buyer buyer = new Buyer();
		if(list.size() != 0) {
			buyer = list.get(0);
		}
		return buyer;
	}
	/**
	 * 更新审核清单信息
	 */
	public void updateExainme(Purchase purchase) {
		System.out.println("update");
		this.hibernateTemplate.update(purchase);
	}
	
}
