package com.gxuwz.canteen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.canteen.entity.Buyer;
import com.gxuwz.canteen.entity.Purchase;
import com.gxuwz.canteen.entity.User;
import com.gxuwz.canteen.service.IPurchaseService;
import com.gxuwz.canteen.vo.Pager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class PurchaseAction extends BaseAction implements ModelDriven,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String LISR_JSP = "/page/buyer/purchase_list.jsp";
	protected static final String ADD_JSP = "/page/buyer/purchase_add.jsp";
	protected static final String EDIT_JSP = "/page/buyer/purchase_edit.jsp";
	protected static final String EXAMINE_JSP = "/page/cashier/examine_list.jsp";
	protected static final String PURCHASE_EXAMINE = "/page/cashier/purchase_examine.jsp";
	protected static final String ALL_JSP = "/page/buyer/purchase_all.jsp";
	private Purchase purchase;
	@Autowired
	private IPurchaseService purchaseService;
	private List<Purchase> list;
	private Pager<Purchase> pager;
	private String number;
	private Integer pageNo;
	private String size;
	private Integer pageSize;
	/**
	 * 获取分页信息
	 */
	public void acquire() {
		HttpServletRequest request = ServletActionContext.getRequest();
		number = request.getParameter("pageNumber");
		if(number != null&&!number.equals("")) {
			pageNo = Integer.parseInt(number);
		}
		pageNo = pageNo == null?1:pageNo;
		size = request.getParameter("pageSize");
		if(size != null&&!size.equals("")) {
			pageSize = Integer.parseInt(size);
		}
		pageSize = pageSize == null?5:pageSize;
	}
	/**
	 * 审核状态名称以及审核意见转换
	 */
	public void change() {
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
	}
	/**
	 * 审核状态名称以及审核意见转换(分页)
	 */
	public void changePager() {
		for(int i = 0;i<pager.list.size();i++) {
			if(pager.list.get(i).getOpinion() == null|| pager.list.get(i).getOpinion().equals("")) {
				pager.list.get(i).setOpinion("");
			}
			if(pager.list.get(i).getStatus().equals("0")) {
				pager.list.get(i).setStatus("未审核");
			}else if(list.get(i).getStatus().equals("1")) {
				pager.list.get(i).setStatus("不同意");
			}
			else if(pager.list.get(i).getStatus().equals("2")) {
				pager.list.get(i).setStatus("同意");
			}
		}
	}
	/**
	 * 根据采购日期查询采购清单信息
	 * @return
	 */
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		acquire();
//		String number = request.getParameter("pageNumber");
//		Integer pageNo =null;
//		if(number != null&&!number.equals("")) {
//			pageNo = Integer.parseInt(number);
//		}
//		pageNo = pageNo == null?1:pageNo;
//		String size = request.getParameter("pageSize");
//		Integer pageSize = null;
//		if(size != null&&!size.equals("")) {
//			pageSize = Integer.parseInt(size);
//		}
//		pageSize = pageSize == null?5:pageSize;
		pager = purchaseService.find(pageSize, pageNo, startTime, endTime);
		if(!pager.isFlag()) {
			System.out.println("changer");
			changePager();
		}
		request.setAttribute("result", pager);
		forwardView = LISR_JSP;
		return SUCCESS;
	}
	/**
	 * 全部采购清单信息(分页)
	 */
	public String allBypage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		acquire();
		pager = purchaseService.allByPager(pageSize, pageNo, startTime, endTime);
		request.setAttribute("result", pager);
		forwardView = ALL_JSP;
		return SUCCESS;
	}
	/**
	 * 查询所有采购清单信息(分页)
	 * @return
	 */
	public String all() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pager = purchaseService.allPage(pageSize, pageNo);
		System.out.println(pager.list.size());
		if(!pager.isFlag()) {
			changePager();
		}
		request.setAttribute("result", pager);
		forwardView = LISR_JSP;
		return SUCCESS;
	}
	/**
	 * 查询所有采购清单信息(分页)
	 * @return
	 */
	public String allPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pager = purchaseService.allPage(pageSize, pageNo);
		if(!pager.isFlag()) {
			changePager();
		}
		request.setAttribute("result", pager);
		forwardView = EXAMINE_JSP;
		return SUCCESS;
	}
	/**
	 * 打开增加采购清单页面
	 */
	public String add() {
		forwardView = ADD_JSP;
		return SUCCESS;
	}
	/**
	 * 保存采购清单信息
	 */
	public String save() {
		//获取食堂采购员名称
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("User");
		Buyer buyer = new Buyer();
		buyer = purchaseService.findBuyer(user.getUserName());
		if(purchase.getBuyer() == null) {
			purchase.setBuyer(buyer.getBuyerName());
		}
		if(purchase.getStatus()==null||purchase.getStatus().equals("")) {
			purchase.setStatus("0");
		}
		purchaseService.save(purchase);
		return all();
	}
	
	/**
	 * 删除采购清单信息
	 */
	public String delete() {
		purchaseService.delete(purchase.getPurchaseId());
		return all();
	}
	/**
	 * 打开修改采购清单信息页面
	 */
	public String edit() {
		forwardView = EDIT_JSP;
		purchase = purchaseService.findById(purchase);
		return SUCCESS;
	}
	/**
	 * 更新采购清单信息
	 */
	public String update() {
		//获取食堂采购员名称
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("User");
		Buyer buyer = new Buyer();
		buyer = purchaseService.findBuyer(user.getUserName());
		if(purchase.getBuyer() == null) {
			purchase.setBuyer(buyer.getBuyerName());
		}
		//设置默认值
		purchase.setOpinion(null);
		purchase.setStatus("0");
		purchaseService.update(purchase);
		return all();
	}
	/**
	 * 打开审核采购清单页面
	 */
	public String openExamine() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pager = purchaseService.findByPager(pageSize, pageNo, purchase);
		if(!pager.isFlag()) {
			changePager();
		}
		request.setAttribute("result", pager);
		forwardView = EXAMINE_JSP;
		return SUCCESS;
	}
	/**
	 *分页显示根据采购员查询采购清单信息
	 */
	public String listPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pager = purchaseService.findByPager(pageSize, pageNo, purchase);
		System.out.println("pager====s="+pager.list.size());
		if(!pager.isFlag()) {
			System.out.println("changer");
			changePager();
		}
		request.setAttribute("result", pager);
		forwardView = EXAMINE_JSP;
		return SUCCESS;
	}
	/**
	 * 查询采购清单信息（分页）
	 */
	public String findBypage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pager = purchaseService.findByPager(pageSize, pageNo, purchase);
		if(!pager.isFlag()) {
			System.out.println("changer");
			changePager();
		}
		request.setAttribute("result", pager);
		forwardView = EXAMINE_JSP;
		return SUCCESS;
	}
	/**
	 * 分页显示根据采购员查询采购清单信息
	 */
	public void pageFindBuyer() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pager = purchaseService.findByPager(pageSize, pageNo, purchase);
		System.out.println("pager====s="+pager.list.size());
		if(!pager.isFlag()) {
			System.out.println("changer");
			changePager();
		}
		request.setAttribute("result", pager);
	}
	/**
	 * 打开审核的弹出层
	 */
	public String examine() {
		purchase = purchaseService.findById(purchase);
		forwardView = PURCHASE_EXAMINE;
		return SUCCESS;
	}
	/**
	 *  更新审核清单信息
	 */
	public String updateExainme() {
		purchaseService.updateExainme(purchase);
		return allPage();
	}
	
	
	
	@Override
	public void prepare() throws Exception {
		if(purchase == null) {
			purchase = new Purchase();
		}
	}
	@Override
	public Object getModel() {
		return purchase;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public List<Purchase> getList() {
		return list;
	}

	public void setList(List<Purchase> list) {
		this.list = list;
	}

	public Pager<Purchase> getPager() {
		return pager;
	}

	public void setPager(Pager<Purchase> pager) {
		this.pager = pager;
	}
	
}
