package me.czd.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.czd.service.AdminService;
import me.czd.service.impl.AdminServiceImpl;
import me.czd.util.PageBean;

/**
 * 
 * 这里就是jsp+servlet+Dao+page 来了解servlet
 */
@WebServlet("/admin.html")
public class AdminDaoPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = null;
	private int pageNo = 0;

	public AdminDaoPageServlet() {
		super();
		adminService = new AdminServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("pager".equals(action)) {
			String pageNoStr = request.getParameter("pageNo");
			if (pageNoStr == null) {
				pageNo = 1;
			}else{
				pageNo = Integer.parseInt(pageNoStr);
			}
			PageBean pg = adminService.findByPage(pageNo, 5);
			request.getSession().setAttribute("pg", pg);
			request.getRequestDispatcher("servlet_demo/servletPAGE/admin_list.jsp").forward(request, response);
		}
	}

}
