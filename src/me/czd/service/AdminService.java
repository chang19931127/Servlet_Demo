package me.czd.service;

import me.czd.util.PageBean;

/**
 * Service 层，这里只有分页的
 * @author Administrator
 *
 */
public interface AdminService {
	public PageBean findByPage(int pageNo,int pageSize);
}
