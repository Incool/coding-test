package com.handlestring.service.proxy.staticproxy;

import com.handlestring.service.proxy.OrderService;

/**
 * 订单服务静态代理类.
 * 静态代理是在编译期就确定代理类与被代理类的关系，代理类和被代理类实现同一个接口，代理类中调用被代理类的方法，并在调用前后添加额外逻辑（如权限、日志）。
 * 优点：
 *      1.简单直观：代码逻辑清晰，适合小型项目或逻辑不频繁变动的场景。
 *      2.编译时确定：没有运行时性能损耗。
 *      3.型安全：代理类与被代理类实现同一接口，IDE支持良好。
 * 缺点：
 *      1.代码冗余：每个需要代理的类都要写一个对应的代理类，难以复用。
 *      2.不易扩展：如果接口增加方法，代理类也需要修改。
 *      3.违反开闭原则：新增功能需要修改或新增代理类。
 *
 * @author Incool
 * @data 2025/9/25 10:40
 */
public class OrderServiceStaticProxy implements OrderService {

    private final OrderService orderService; //被代理的对象
    private final boolean isAdmin;         // 是否是管理员

    public OrderServiceStaticProxy(OrderService orderService, boolean isAdmin) {
        this.orderService = orderService;
        this.isAdmin = isAdmin;
    }

    @Override
    public void deleteOrder(String orderId) {
        // 1. 权限校验
        if (!isAdmin) {
            System.out.println("权限不足，无法删除订单");
            return;
        }

        // 2. 日志记录 - 删除前
        System.out.println("[日志] 管理员准备删除订单：" + orderId);

        // 3. 调用真实对象的方法
        orderService.deleteOrder(orderId);

        // 4. 日志记录 - 删除后
        System.out.println("[日志] 订单已删除：" + orderId);
    }
}
