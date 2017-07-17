package me.czd.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import me.czd.bean.Admin;

/**
 * 这里是一个Listener 采用的是注解的方式配置的 spring 的容器 启动也是通过Listener 这里是一个SessionListener
 * 用户通过Session 的变化，来进行操作
 */
@WebListener
public class SessionListener implements HttpSessionAttributeListener {

	public SessionListener() {

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Listener触发session ADD");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("Listener触发 session REPLACE");
	}

}
