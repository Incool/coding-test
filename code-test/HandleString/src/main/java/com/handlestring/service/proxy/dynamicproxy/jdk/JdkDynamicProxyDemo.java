package com.handlestring.service.proxy.dynamicproxy.jdk;

import com.handlestring.service.proxy.OrderService;
import com.handlestring.service.proxy.OrderServiceImpl;

/**
 * JDK动态代理使用Demo.
 *
 * @author Incool
 * @data 2025/9/25 11:02
 */
public class JdkDynamicProxyDemo {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = (OrderService)OrderServiceDynamicProxyHandler.createProxy(orderService, true);
        // 调用
        proxy.deleteOrder("123456");
    }
}
