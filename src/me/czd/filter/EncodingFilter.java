package me.czd.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 这是一个字符转化的过滤器 这里采用的是xml 配置的方式 配置映射
 * 
 */
// @WebFilter(value = "/EncodingFilter", initParams = @WebInitParam(name =
// "encoding", value = "utf-8"))
public class EncodingFilter implements Filter {

	private String encoding = null;
	// 需要来获取filter 参数
	private FilterConfig config;

	public EncodingFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (encoding == null ) {
			encoding = config.getInitParameter("encoding");
		}
		if (encoding != null ) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset = " + encoding);
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
