
/**
 * Servlet监听器
 * Servlet中的时间是通过实现Listener接口的类然后在特定的时间发生的时候
 * 呼叫特定的方法来对事件进行响应的，由Container在特定书剑发生时呼叫特定的实现Listener
 * 
 * 6中Listener
 * ServletContextListener 				ServletContextEvent
 * ServletContextAttributeListener		ServletContextAttributeEvent
 * HTtpSessionListener					HttpSessionEvent
 * HttpSessionAttributeListener			HttpSessionBindingEvent
 * HttpSessionActivationListener		HttpSessionEvent
 * ServletRequestListener				RequestEvent
 * ServletRequestAttributeListener		HttpSessionBindingEvent
 * HttpSessionBindingListener			HttpSessionBindingEvent
 * 
 * 通过事件，然后去调用事件相关的监听器
 * 
 * 这个观察者模型应该是由容器来维护的，这里只是猜猜，之后看源代码在考证
 */
package me.czd.listener;