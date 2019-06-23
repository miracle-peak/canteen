package com.gxuwz.canteen.vo;

import java.util.List;

public class Pager<T> {
	private Integer totalPage;   // 总页数
	private Integer currentPage; //当前页码
	private Integer totalRecord; //总记录数
	private Integer pageSize;	 //每页记录数
	public List<T> list;
	private boolean flag;
	
	public Pager() {
		super();
	}
	public Pager(Integer pageSize, Integer pageNo, List<T> list) {
		if(list == null||list.isEmpty()||list.size()==0) {
			this.flag = list.isEmpty();
			return;
		}
		this.totalRecord = list.size();
		this.pageSize = pageSize;
		this.list = list;
		//总页数
		this.totalPage = this.totalRecord%this.pageSize == 0?this.totalRecord/this.pageSize:(this.totalRecord/this.pageSize)+1;
		//当前第几页
		if(this.totalPage<pageNo) {
			this.currentPage = this.totalPage;
		}else {
			this.currentPage = pageNo;
		}
		//起始索引 
		Integer startIndex = this.pageSize*(this.currentPage-1); 
		//结束索引 
		Integer endIndex = this.pageSize*this.currentPage>this.totalRecord?this.totalRecord:this.pageSize*this.currentPage; 
		
		this.list = list.subList(startIndex, endIndex);
		
	}

	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
