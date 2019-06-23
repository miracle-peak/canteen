package com.gxuwz.canteen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.canteen.dao.PurchaseDao;
import com.gxuwz.canteen.entity.Buyer;
import com.gxuwz.canteen.entity.Purchase;
import com.gxuwz.canteen.vo.Pager;

@Service("PurchaseServiceImpl")
public class PurchaseServiceImpl implements IPurchaseService{
	@Autowired
	private PurchaseDao purchaseDao;
	
	@Override
	public List<Purchase> findAll() {
		return purchaseDao.findAll();
	}

	@Override
	public Pager<Purchase> find(Integer pageSize, Integer pageNo,String startTime, String endTime) {
		return purchaseDao.find(pageSize, pageNo, startTime, endTime);
	}

	@Override
	public void save(Purchase purchase) {
		purchaseDao.save(purchase);
	}

	@Override
	public void delete(int purchaseId) {
		purchaseDao.delete(purchaseId);
	}

	@Override
	public void update(Purchase purchase) {
		purchaseDao.update(purchase);
	}

	@Override
	public Buyer findBuyer(String  buyerId) {
		return purchaseDao.findBuyer(buyerId);
	}

	@Override
	public Purchase findById(Purchase purchase) {
		return purchaseDao.findById(purchase);
	}

	@Override
	public void updateExainme(Purchase purchase) {
		purchaseDao.updateExainme(purchase);
	}

	@Override
	public Pager<Purchase> allPage(Integer pageSize, Integer pageNo) {
		return purchaseDao.allPage(pageSize, pageNo);
	}

	@Override
	public Pager<Purchase> findByPager(Integer pageSize, Integer pageNo, Purchase purchase) {
		return purchaseDao.findByPager(pageSize, pageNo, purchase);
	}

	@Override
	public Pager<Purchase> allByPager(Integer pageSize, Integer pageNo,String startTime, String endTime) {
		return purchaseDao.allByPager(pageSize, pageNo ,startTime, endTime);
	}

}
