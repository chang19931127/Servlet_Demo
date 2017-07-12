package me.czd.dao;

import java.util.List;

import me.czd.bean.Admin;

/**
 * 这里是为了通过实现mvc 中的 控制逻辑 c 中提供了 dao层 就是访问数据库的，也就是
 * 
 * @author Administrator
 *
 */
public interface AdminDao {
	List<Admin> findAdmins();

	int addAdmin(Admin admin);

	Admin findById(int id);

	int delById(int id);

	int updateAdmin(Admin admin);
}
