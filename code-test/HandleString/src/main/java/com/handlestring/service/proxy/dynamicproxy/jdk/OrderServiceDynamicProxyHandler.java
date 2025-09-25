package com.handlestring.service.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 订单服务JDK动态代理类.
 * JDK 动态代理是基于 Java 反射机制，在运行时动态生成代理类，要求被代理的类必须实现接口。代理逻辑通过实现 InvocationHandler接口来定义。
 * 优点：
 *      1.解耦：代理逻辑集中在 InvocationHandler 中，无需为每个类编写代理类。
 *      2.灵活：可以在运行时动态生成代理，适合多个类有相同横切关注点（如日志、权限）。
 *      3.符合开闭原则：新增功能无需修改原有代码。
 * 缺点：
 *      1.只能代理接口：被代理类必须实现接口，对没有接口的类无法直接使用 JDK 动态代理。
 *      2.反射有一定性能开销：虽然现代 JDK 对反射优化不少，但仍比直接调用略慢。
 *      3.调试复杂：动态生成的代理类在运行时生成，不利于调试和追踪。
 *
 * @author Incool
 * @data 2025/9/25 10:54
 */
public class OrderServiceDynamicProxyHandler implements InvocationHandler {

    private final Object target;     // 被代理对象
    private final boolean isAdmin;

    public OrderServiceDynamicProxyHandler(Object target, boolean isAdmin) {
        this.target = target;
        this.isAdmin = isAdmin;
    }

    /**
     * 创建被代理对象.
     */
    public static Object createProxy(Object target, boolean isAdmin) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new OrderServiceDynamicProxyHandler(target, isAdmin)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        // 1. 权限校验
        if (!isAdmin) {
            System.out.println("权限不足，无法执行操作: " + methodName);
            return null;
        }

        // 2. 日志 - 方法调用前
        System.out.println("[JDK动态代理日志] 准备执行方法: " + methodName + "，参数: " + (args != null ? args[0] : "无"));

        // 3. 执行目标方法
        Object result = method.invoke(target, args);

        // 4. 日志 - 方法调用后
        System.out.println("[JDK动态代理日志] 方法执行完成: " + methodName);

        return result;
    }
}
