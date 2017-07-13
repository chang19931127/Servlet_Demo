package me.czd.action;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.czd.util.AuthCode;

/**
 * 生成验证码的servlet 通过工具类生成 验证码，然后生成图片显示
 */
@WebServlet("/code")
public class AuthCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AuthCodeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scode = AuthCode.getAuthCode();
		request.getSession().setAttribute("scode", scode);
		//ImageIO 来讲图片写入到指定的流中
		ImageIO.write(AuthCode.getAuthImg(scode), "JPEG", response.getOutputStream());
	}

}
