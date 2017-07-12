package me.czd.util;

import java.util.List;

import me.czd.bean.Admin;

/**
 * 分页的实体类，这里就是工具吧
 * 
 * 分页几个要素，每页大小，总记录数，当前页，结果集
 * 
 * @author Administrator
 *
 */
public class PageBean {
	// 结果集
	private List<Admin> list;
	// 每页多少数据
	private int pageSize;
	// 第几页
	private int pageNo;
	// 查询总记录数
	private int totalRecords;

	public List<Admin> getList() {
		return list;
	}

	public void setList(List<Admin> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * 计算总页面数
	 * 
	 * @return
	 */
	public int getTotalPages() {
		if (totalRecords % pageSize == 0)
			return totalRecords / pageSize;
		else
			return totalRecords / pageSize + 1;
	}

	/**
	 * 获得首页
	 * 
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 获得上一页
	 * 
	 * @return
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1)
			return 1;
		else
			return pageNo - 1;
	}

	/**
	 * 获得尾页
	 * 
	 * @return
	 */
	public int getBottomPageNo() {
		return getTotalPages();
	}

	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public int getNextPageNo() {
		if (pageNo >= getBottomPageNo())
			return getBottomPageNo();
		else
			return pageNo + 1;
	}

}
