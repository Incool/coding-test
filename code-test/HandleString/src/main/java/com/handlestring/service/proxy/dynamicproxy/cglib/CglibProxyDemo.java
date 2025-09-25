package com.handlestring.service.proxy.dynamicproxy.cglib;

import com.handlestring.service.proxy.OrderService;
import com.handlestring.service.proxy.OrderServiceImpl;

/**
 * CGLib 动态代理使用Demo.
 *
 * @author Incool
 * @data 2025/9/25 11:22
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        // 创建 CGLIB 代理对象
        OrderService proxy = (OrderService)OrderServiceCglibProxy.createProxy(orderService, true);
        // 调用
        proxy.deleteOrder("123456");
    }
}
