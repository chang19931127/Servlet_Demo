package me.czd.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.czd.bean.Admin;
import me.czd.db.DBConnection;

/**
 * 这里是通过 Servlet3.0 版本基于注解实现的Servlet 因此不需要在xml中在进行配置了
 * 
 * 仅仅通过servlet 在doPost 中调用了不同的方法
 * 
 * 这里就是一个 流程设计过程
 * 
 * @author Administrator
 *
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private DBConnection dbc = new DBConnection();
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("query".equals(action)) {
			String sql = "select * from admin";
			ResultSet rs = null;
			List<Admin> adminList = new ArrayList<>();
			try {
				rs = dbc.doQuery(sql, new Object[] {});
				while (rs.next()) {
					Admin admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setUsername(rs.getString("username"));
					admin.setPassword(rs.getString("password"));
					adminList.add(admin);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("adminList", adminList);
			System.out.println(request.getContextPath()+"/servelt_demo/servletCRUD/admin_list.jsp");
			request.getRequestDispatcher("servlet_demo/servletCRUD/admin_list.jsp").forward(request, response);
		} else if ("del".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String sql = "delete from admin where id = ?";
			int res = 0;
			res = dbc.doUpdate(sql, new Object[] { id });
			if (res > 0) {
				request.getRequestDispatcher("admin?action=query").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.print("删除失败");
				out.close();
			}
		} else if ("add".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String sql = "insert into admin(username,password)values(?,?)";
			int res = 0;
			res = dbc.doUpdate(sql, new Object[] { username, password });
			if (res > 0) {
				request.getRequestDispatcher("admin?action=query").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("添加失败");
				out.close();
			}
		} else if ("edit".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String sql = "select * from admin where id = ?";
			Admin admin = null;
			try {
				ResultSet rs = dbc.doQuery(sql, new Object[] { id });
				if (rs.next()) {
					admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setPassword(rs.getString("password"));
					admin.setUsername(rs.getString("username"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("servlet_demo/servletCRUD/edit_admin.jsp").forward(request, response);
		} else if ("update".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String sql = "update admin set username = ? , password = ? where id = ?";
			int res = 0;
			res = dbc.doUpdate(sql, new Object[] { username, password, id });
			if(res > 0){
				request.getRequestDispatcher("admin?action=query").forward(request, response);
			}else{
				PrintWriter out = response.getWriter();
				out.println("更新失败");
				out.close();
			}
		}else{
			PrintWriter out = response.getWriter();
			out.println("其他方法，找不到啊");
			out.close();
		}
	}

}
