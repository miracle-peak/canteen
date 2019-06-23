package com.gxuwz.canteen.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.service.IAccountantService;
import com.gxuwz.canteen.vo.Pager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AccountantAction extends BaseAction implements ModelDriven,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String ACCOUNTANT_LIST = "/page/accountant/accountant_list.jsp";
	@Autowired
	private IAccountantService accountantService;
	private Order order;
	private List<Order> list;
	private Pager<Order> pager;
	private double totalCost; // 总费用
	private int totalNumber;
	
	/**
	 *  查询员工的订餐记录
	 * @return
	 */
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		list = accountantService.find(order.getWorkerId(), startTime, endTime);
		totalNumber = list.size();
		if(list.size()>0) {
			for(int i = 0;i<list.size();i++) {
				double price = Double.parseDouble(list.get(i).getMealPrice());
				double number = Double.parseDouble(list.get(i).getOrderNumber());
				totalCost += price*number;
			}
		}
		
		forwardView = ACCOUNTANT_LIST;
		return SUCCESS;
	}
	/**
	 *  分页显示查询员工的订餐记录
	 * @return
	 */
	public String listPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String number = request.getParameter("pageNumber");
		Integer pageNo = null;
		if(number != null&&!number.equals("")) {
			pageNo = Integer.parseInt(number);
		}
		pageNo = pageNo==null?1:pageNo;
		String size = request.getParameter("pageSize");
		Integer pageSize = null;
		if(size != null&&!size.equals("")) {
			pageSize = Integer.parseInt(size);
		}
		pageSize = pageSize==null?5:pageSize;
		pager = accountantService.findByPage(order.getWorkerId(), startTime, endTime, pageSize, pageNo);
		if(!pager.isFlag()) {
			totalNumber = pager.list.size();
			if(pager.list.size()>0) {
				for(int i = 0;i<pager.list.size();i++) {
					double price = Double.parseDouble(pager.list.get(i).getMealPrice());
					double N = Double.parseDouble(pager.list.get(i).getOrderNumber());
					totalCost += price*N;
				}
			}
		}
		request.setAttribute("result", pager);
		forwardView = ACCOUNTANT_LIST;
		return SUCCESS;
	}
	
	
	@Override
	public void prepare() throws Exception {
		if(order == null) {}
			order = new Order();
	}

	@Override
	public Object getModel() {
		return order;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public Pager<Order> getPager() {
		return pager;
	}
	public void setPager(Pager<Order> pager) {
		this.pager = pager;
	}

}
