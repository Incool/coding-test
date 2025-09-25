package com.handlestring.service.proxy.dynamicproxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * 订单服务 CGLib 动态代理类.
 * CGLIB（Code Generation Library）是一个强大的高性能代码生成库，它通过继承方式实现代理，可以在运行时动态生成被代理类的子类，从而实现对类的代理。不需要接口！
 * 注意：CGLIB 通过字节码增强技术生成代理类，不能代理 final 类或 final 方法。
 * 优点：
 *      1.无需接口：可以直接代理普通类，不强制要求被代理类实现接口。
 *      2.灵活性高：运行时生成子类代理，适合更广泛的场景。
 *      3.性能较好：相比 JDK 反射，CGLIB 直接调用方法更快（尤其是生成子类后）。
 * 缺点：
 *      1.不能代理 final 类 / 方法：final 类无法被继承，final 方法无法被覆盖。
 *      2.基于继承实现：如果被代理类本身已经继承了某个类（Java 不支持多继承），则无法使用 CGLIB。
 *      3.引入第三方库：需要引入 CGLIB 依赖，而 JDK 动态代理是 JDK 自带的。
 *      4.复杂性略高：相比 JDK 动态代理，使用和理解门槛稍高。
 * 注意：
 *      1.在JDK 21 版本中推荐使用CGLib 3.3.0 或更高的版本
 *      2.必须在 VM options 中添加 --add-opens java.base/java.lang=ALL-UNNAMED   不然在new Enhancer(); 报错
 *
 * @author Incool
 * @data 2025/9/25 11:11
 */
public class OrderServiceCglibProxy implements MethodInterceptor {

    private final Object target;
    private final boolean isAdmin;

    public OrderServiceCglibProxy(Object target, boolean isAdmin) {
        this.target = target;
        this.isAdmin = isAdmin;
    }

    /**
     * 创建代理对象.
     */
    public static Object createProxy(Object target, boolean isAdmin) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass()); // 继承被代理类
        enhancer.setCallback(new OrderServiceCglibProxy(target, isAdmin));
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();

        // 1. 权限校验
        if (!isAdmin) {
            System.out.println("CGLIB代理 - 权限不足，无法执行: " + methodName);
            return null;
        }

        // 2. 日志 - 前
        System.out.println("[CGLIB动态代理日志] 准备执行: " + methodName + "，参数: " + (objects != null ? objects[0] : "无"));

        // 3. 调用真实方法
        Object result = methodProxy.invoke(target, objects);

        // 4. 日志 - 后
        System.out.println("[CGLIB动态代理日志] 执行完成: " + methodName);

        return result;
    }
}
