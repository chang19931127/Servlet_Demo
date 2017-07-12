package me.czd.service.impl;

import java.util.List;

import me.czd.bean.Admin;
import me.czd.dao.AdminDao;
import me.czd.dao.impl.AdminDaoImpl;
import me.czd.service.AdminService;
import me.czd.util.PageBean;

/**
 * Service 实现类
 * 
 * @author Administrator
 *
 */
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao = null;

	public AdminServiceImpl() {
		super();
		adminDao = new AdminDaoImpl();
	}

	@Override
	public PageBean findByPage(int pageNo, int pageSize) {
		PageBean pg = new PageBean();
		List<Admin> adminList = adminDao.findByPage(pageNo, pageSize);
		pg.setList(adminList);
		pg.setPageNo(pageNo);
		pg.setPageSize(pageSize);
		pg.setTotalRecords(adminDao.getTotalRecords());
		return pg;
	}

}
