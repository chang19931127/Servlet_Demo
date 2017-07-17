package me.czd.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 转门产生一个Servlet 用于 前台通过ajax来进行请求 ajax 是 js css dom XMLHttpRequest 四种技术的搭配 异步
 * asynchronized JavaScript and xml
 */
@WebServlet("/ajax")
public class AJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AJAXServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String str = username + "的 密码是 :"+password;
		System.out.println(str);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

}
