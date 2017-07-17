package me.czd.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首先Filter 是一个java组件，用来在与之先关的Servlet 之前或者JSP 运行的服务器之前运行 翻译过来就是过滤器
 * 
 * 用来对请求进行过滤
 * 
 * 这里就是一个联系，登录拦截的过滤器，字符转化
 * 
 * 这里用的是注解的方式 来 映射规则的
 */
@WebFilter("/*")
public class CheckLoginFilter implements Filter {

	public CheckLoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 先进行类型转换 将Servlet 环境转换到WebSerlvet 环境
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uriStr = req.getRequestURI();
		boolean flag = true;
		if (uriStr.indexOf("login") == -1 && req.getSession().getAttribute("u") == null) {
			flag = false;
		}
		if (flag)
			chain.doFilter(request, response);
		else
			resp.sendRedirect("login.jsp");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter 初始化 ，声明周期啦");
	}

}
