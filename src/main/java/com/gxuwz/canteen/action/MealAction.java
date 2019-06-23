package com.gxuwz.canteen.action;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.gxuwz.canteen.entity.Meal;
import com.gxuwz.canteen.service.IMealService;
import com.gxuwz.canteen.vo.Pager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class MealAction extends BaseAction implements ModelDriven,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String LIST_JSP = "/page/manager/meal_list.jsp";
	protected static final String ADD_JSP = "/page/manager/meal_add.jsp";
	protected static final String EDIT_JSP = "/page/manager/meal_edit.jsp";
	private Meal meal;
	private List<Meal> list;
	private Pager<Meal> pager;
	@Autowired
	private IMealService mealService;
	private String number;
	private String size;
	private Integer pageNo;
	private Integer pageSize;
	/**
	 * 获取页码信息
	 */
	public void aquire() {
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
	 * 打开菜品套餐信息列表
	 * @return
	 */
	public String list() {
		list = mealService.find(meal);
		forwardView = LIST_JSP;
		return SUCCESS;
	}
	/**
	 * 分页显示菜品套餐信息
	 */
	public String findBypage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		aquire();
		pager = mealService.findByPage(pageSize, pageNo, meal);
		request.setAttribute("result", pager);
		forwardView = LIST_JSP;
		return SUCCESS;
	}
	/**
	 * 打开增加菜品套餐页面
	 */
	public String add() {
		forwardView = ADD_JSP;
		return SUCCESS;
	}
	
	/**
	 * 保存菜品套餐信息
	 */
	public String save() {
		mealService.save(meal);
		return allPage();
	}
	
	/**
	 * 删除菜品套餐
	 */
	public String delete() {
		mealService.delete(meal.getMealId());
		return allPage();
	}
	/**
	 * 打开修改菜品套餐页面
	 * @return
	 */
	public String edit() {
		meal = mealService.findById(meal);
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	/**
	 * 更新菜品套餐信息
	 */
	public String update() {
		mealService.update(meal);
		System.out.println(meal.getMealPrice());
		return allPage();
	}
	
	/**
	 * 查找所有菜品套餐信息
	 */
	public String all() {
		list = mealService.findAll();
		forwardView = LIST_JSP;
		return SUCCESS;
	}
	/**
	 * 查找所有菜品套餐信息(分页)
	 */
	public String allPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		aquire();
		pager = mealService.allPage(pageSize, pageNo);
		request.setAttribute("result", pager);
		forwardView = LIST_JSP;
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		if(meal == null) {
			meal = new Meal();
		}
	}

	@Override
	public Object getModel() {
		return meal;
	}

	public List<Meal> getList() {
		return list;
	}

	public void setList(List<Meal> list) {
		this.list = list;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public Pager<Meal> getPager() {
		return pager;
	}
	public void setPager(Pager<Meal> pager) {
		this.pager = pager;
	}
	
}
