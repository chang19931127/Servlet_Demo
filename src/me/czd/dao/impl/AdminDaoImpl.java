package me.czd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.czd.bean.Admin;
import me.czd.dao.AdminDao;
import me.czd.db.DBConnection;

/**
 * Dao 层的实现类
 * 
 * @author Administrator
 *
 */
public class AdminDaoImpl implements AdminDao {

	private DBConnection dbc = null;

	public AdminDaoImpl() {
		super();
		dbc = new DBConnection();
	}

	@Override
	public List<Admin> findAdmins() {
		List<Admin> adminList = new ArrayList<>();
		String sql = "SELECT * FROM admin ORDER BY id";
		try {
			ResultSet rs = dbc.doQuery(sql, new Object[] {});
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close();
		}
		return adminList;

	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "INSERT INTO admin(username,password)values(?,?)";
		int res = 0;
		res = dbc.doUpdate(sql, new Object[] { admin.getUsername(), admin.getPassword() });
		dbc.close();
		return res;
	}

	@Override
	public Admin findById(int id) {
		Admin admin = null;
		String sql = "SELECT * FROM admin where id = ?";
		try {
			ResultSet rs = dbc.doQuery(sql, new Object[] { id });
			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close();
		}
		return admin;
	}

	@Override
	public int delById(int id) {
		int res = 0;
		String sql = "DELETE FROM admin WHERE id = ?";
		res = dbc.doUpdate(sql, new Object[] { id });
		dbc.close();
		return res;
	}

	@Override
	public int updateAdmin(Admin admin) {
		int res = 0;
		String sql = "UPDATE admin set username=?,password=? WHERE id =?";
		res = dbc.doUpdate(sql, new Object[] { admin.getUsername(), admin.getPassword(), admin.getId() });
		dbc.close();
		return res;
	}

}
