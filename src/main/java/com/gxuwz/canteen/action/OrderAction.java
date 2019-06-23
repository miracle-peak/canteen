package com.gxuwz.canteen.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.gxuwz.canteen.entity.Meal;
import com.gxuwz.canteen.entity.Order;
import com.gxuwz.canteen.entity.User;
import com.gxuwz.canteen.service.IMealService;
import com.gxuwz.canteen.vo.Pager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class OrderAction extends BaseAction implements ModelDriven,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String LIST_JSP = "/page/worker/order_list.jsp";
	protected static final String ORDER_JSP = "/page/worker/order_order.jsp";
	protected static final String INFO_JSP = "/page/worker/order_info.jsp";
	protected static final String PERSON_JSP = "/page/worker/order_person.jsp";
	protected static final String TAKE_JSP = "/page/worker/order_take.jsp";
	protected static final String TAKE_MEAL = "/page/manager/meal_take.jsp";
	protected static final String CODE_JSP = "/page/worker/order_code.jsp";
	private Meal meal;
	private Order order;
	private List<Meal> list;
	private List<Order> listOrder;
	private Pager<Order> pagerOrder;
	private Pager<Meal> pagerMeal;
	@Autowired
	private IMealService mealService;
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
	 * 打开菜品套餐列表（查询）
	 * @return
	 */
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
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
		acquire();
		pagerMeal = mealService.findByPage(pageSize, pageNo, meal);
		request.setAttribute("result", pagerMeal);
		forwardView = LIST_JSP;
		return SUCCESS;
	}
	/**
	 * 打开所有菜品套餐列表
	 * @return
	 */
	public String all() {
		list = mealService.findAll();
		forwardView = LIST_JSP;
		return SUCCESS;
	}
	/**
	 * 打开所有菜品套餐列表(分页)
	 * @return
	 */
	public String allPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		pagerMeal = mealService.allPage(pageSize, pageNo);
		request.setAttribute("result", pagerMeal);
		forwardView = LIST_JSP;
		return SUCCESS;
	}
	/**
	 * 打开订餐页面
	 */
	public String openOrder() {
		meal = mealService.findById(meal);
		forwardView = ORDER_JSP;
		return SUCCESS;
	}
	/**
	 * 保存订餐信息
	 */
	public String saveOrder() {
		//生成订餐时间
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate = dateFormat.format(date);
		order.setOrderTime(orderDate);
		//自动保存订餐人名称
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user= (User) session.getAttribute("User");
		String workerId = user.getUserName();
		//保存订餐信息
		String number = request.getParameter("orderNumber");
		String telephone = request.getParameter("telephone");
		order.setOrderNumber(number);
		order.setWorkerId(workerId);
		order.setMealName(meal.getMealName());
		order.setMealPrice(meal.getMealPrice());
		order.setMealId(meal.getMealId());
		order.setTelephone(telephone);
		order.setStatus("未取餐");
		mealService.saveOrder(order);
		return allPage();
	}
	/**
	 * 查询个人订餐信息
	 */
	public String person() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user= (User) session.getAttribute("User");
		String workerId = user.getUserName();
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		acquire();
		pagerOrder = mealService.personPager(workerId, startTime, endTime, pageSize, pageNo);
		request.setAttribute("result", pagerOrder);
		forwardView = PERSON_JSP;
		return SUCCESS;
	}
	/**
	 * 删除个人订餐信息
	 */
	public String deleteOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("orderId");
		int orderId = Integer.parseInt(id);
		mealService.deleteOrder(orderId);
		return person();
	}
	/**
	 * 取餐判断
	 */
	public String takeOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		acquire();
		String orderId = request.getParameter("orderId");
		pagerOrder = mealService.takeOrder(user.getUserName(), pageSize, pageNo, orderId);
		request.setAttribute("result", pagerOrder);
		forwardView = TAKE_JSP;
		return SUCCESS;
	}
	/**
	 * 打开取餐登记页面
	 */
	public String orderInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		acquire();
		String orderId = request.getParameter("orderId");
		pagerOrder = mealService.orderInfo(pageSize, pageNo, orderId);
		request.setAttribute("result", pagerOrder);
		forwardView = TAKE_MEAL;
		return SUCCESS;
	}
	/**
	 * 生成二维码
	 * @return
	 * @throws Exception
	 */
	public String getCode() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("orderId");
		System.out.println("id=="+id);
		int orderId = Integer.parseInt(id);
		System.out.println("orderId=="+orderId);
		order = mealService.findOrder(orderId);
		String text = "订餐编号:"+order.getOrderId()+", 菜品套餐名称:"+order.getMealName()+", 订餐数量："+order.getOrderNumber(); // 二维码内容
		int width = 380; // 二维码图片宽度
		int height = 380; // 二维码图片高度
		String format = "jpg";// 二维码的图片格式
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");	// 内容所使用字符集编码
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		String fileName = "二维码"+orderId+".jpg";
		// 生成二维码
		String path = request.getSession().getServletContext().getRealPath("/images/"); 
		File outputFile = new File(path+fileName);
		System.out.println("path==="+path);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		String URL="http://localhost:8080/canteen/images/二维码"+orderId+".jpg";
		request.setAttribute("path", URL);
		forwardView = CODE_JSP;
		return SUCCESS;
	}
	/**
	 * 更新订餐的取餐状态
	 */
	public String updateOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderId = request.getParameter("orderId");
		mealService.updateOrder(orderId);
		forwardView = TAKE_MEAL;
		return SUCCESS;
	}
	/**
	 * 根据订餐id查询
	 */
	public String findOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("orderId");
		System.out.println("id=="+id);
		int orderId = Integer.parseInt(id);
		System.out.println("orderId=="+orderId);
		order = mealService.findOrder(orderId);
		forwardView = INFO_JSP;
		return SUCCESS;
	}

	
	@Override
	public void prepare() throws Exception {
		if(meal == null) {
			meal = new Meal();
		}
		if(order == null) {
			order = new Order();
		}
	}
	@Override
	public Object getModel() {
		return meal;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public List<Meal> getList() {
		return list;
	}
	public void setList(List<Meal> list) {
		this.list = list;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getListOrder() {
		return listOrder;
	}
	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

	public Pager<Order> getPagerOrder() {
		return pagerOrder;
	}

	public void setPagerOrder(Pager<Order> pagerOrder) {
		this.pagerOrder = pagerOrder;
	}

	public Pager<Meal> getPagerMeal() {
		return pagerMeal;
	}

	public void setPagerMeal(Pager<Meal> pagerMeal) {
		this.pagerMeal = pagerMeal;
	}

}
