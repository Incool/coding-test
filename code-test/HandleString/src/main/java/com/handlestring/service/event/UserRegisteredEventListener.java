package com.handlestring.service.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器.
 * 不推荐：一个类只能监听一种事件（若要监听多个事件，需要实现多个接口或使用组合）
 *
 * @author Incool
 * @data 2025/9/24 10:45
 */
@Component
public class UserRegisteredEventListener implements ApplicationListener<UserRegisteredEvent> {

    @Override
    public void onApplicationEvent(UserRegisteredEvent event) {
        System.out.println("【监听器1】收到用户注册事件，用户名：" + event.getUserName());
        // 可以在这里执行后续逻辑，比如发送欢迎邮件、记录日志等
    }
}
