package me.czd.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.czd.bean.Admin;
import me.czd.dao.AdminDao;
import me.czd.dao.impl.AdminDaoImpl;

/**
 * 这个servlet 就是使用的是 mvc 的模式 
 * m 就是我们封装数据的bean 
 * v 就是我们的jsp 页面 
 * c 就是我们的serlvet 控制逻辑
 */
@WebServlet("/adminDao")
public class AdminDaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao = null;

	public AdminDaoServlet() {
		super();
		System.out.println("调用构造方法");
		adminDao = new AdminDaoImpl();
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
			List<Admin> results = adminDao.findAdmins();
			HttpSession session = request.getSession();
			session.setAttribute("adminList", results);
			request.getRequestDispatcher("servlet_demo/servletDAO/admin_list.jsp").forward(request, response);
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			int res = adminDao.delById(id);
			if (res > 0) {
				request.getRequestDispatcher("adminDao?action=query");
			} else {
				PrintWriter out = response.getWriter();
				out.println("删除失败");
				out.close();
			}
		} else if ("edit".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Admin admin = adminDao.findById(id);
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("servlet_demo/servletDAO/edit_admin.jsp").forward(request, response);
			;
		} else if ("update".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Admin admin = new Admin(id, username, password);
			int res = adminDao.updateAdmin(admin);
			if (res > 0) {
				request.getRequestDispatcher("adminDao?action=query").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("更新失败");
				out.close();
			}
		} else if ("add".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Admin admin = new Admin(username, password);
			int res = adminDao.addAdmin(admin);
			if (res > 0) {
				request.getRequestDispatcher("adminDao?action=query").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("添加失败");
				out.close();
			}
		}
	}

}
