package me.czd.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web.xml方式配置
 * http://localhost:8080/Hello_jsp_1/firstServlet
 * @author Administrator
 *
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FirstServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>First Servlet</title>");
		out.println("</head><body>");
		out.println("Hello First Servlet");
		out.println("</body></html>");
		out.close();
	}

}
