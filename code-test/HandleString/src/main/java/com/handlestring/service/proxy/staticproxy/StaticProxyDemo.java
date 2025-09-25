package com.handlestring.service.proxy.staticproxy;

import com.handlestring.service.proxy.OrderService;
import com.handlestring.service.proxy.OrderServiceImpl;

/**
 * 静态代理使用Demo.
 *
 * @author Incool
 * @data 2025/9/25 10:45
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderService proxy = new OrderServiceStaticProxy(orderService, true);
        proxy.deleteOrder("123456");
    }
}
