
package me.czd.action;

/**
 * 这里就是存放的我们的serlvet 
 * 这里我们需要了解一下Servlet
 * Servlet的实质就是实现了Servlet接口的类
 * 该接口定义了Web容器用来管理Servlet和与之交互的方法用于处理HTTP请求
 * 
 * Servlet常用方法
 * init()用来初始化，在用户第一次访问Servlet的时候进行调用，可用于提供初始化参数
 * doGet()
 * doPost() 常用的方法 当然还有其他的方法
 * destory() 构成一个生命周期
 * 
 * 期初的Servlet 是通过Web.xml来进行配置映射关系
 * 伴随着Servlet3.0的到来，注解增加了
 */