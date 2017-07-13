package me.czd.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传 借助Apache 的Common -fileupload -io 两个jar 包来进行文件流的快速读写
 * 这里一定要确保路径 正确，因为放置目录找不到
 * 
 * 总思想   ，显示通过request 来判断是否 文件上传，然后parseRequest封装到FileItem类中，然后执行类的写操作
 * 
 * 地下有判断，如果为null 就直接return
 * 
 */
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath = "e:/upload";
	private String tempFilePath = "e:/upload/temp";

	public FileUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置缓冲区的大小
			factory.setSizeThreshold(4 * 1024);
			// 设置临时目录
			factory.setRepository(new File(tempFilePath));
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置文件最大尺寸
			upload.setSizeMax(4 * 1024 * 1024);
			
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					out.println(name + ";" + value + "\r\n");
				} else {
					// 上传文件
					String filename = item.getName();
					int index = filename.lastIndexOf("\\");
					filename = filename.substring(index + 1, filename.length());
					long fileSize = item.getSize();
					if (filename.equals("") || fileSize == 0)
						return;
					File uploadFile = new File(filePath + "/" + filename);
					//这里才是文件读写的地方
					item.write(uploadFile);
					out.println(filename + "已经保存");
					out.println("文件 " + filename + " 的大小：" + fileSize + "\r\n");
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.println("文件为空！！！！！");
			out.close(); 
		}
	}

}
