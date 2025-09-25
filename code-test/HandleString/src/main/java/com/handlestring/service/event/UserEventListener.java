package com.handlestring.service.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听器.
 * 推荐.
 *
 * @author Incool
 * @data 2025/9/24 10:48
 */
@Component
public class UserEventListener {

    @Async
    //@EventListener
    @EventListener(condition = "#event.userName != 'admin'")
    public void handleUserRegisterEvent(UserRegisteredEvent event) {
        System.out.println("【@EventListener 监听器】用户 [" + event.getUserName() + "] 已注册，准备发送欢迎邮件！");
        // 例如：发送邮件、记录行为日志、触发下游服务等

    }

//    // 你还可以监听多个事件，写多个方法即可
//    @EventListener
//    public void handleOtherEvent(SomeOtherEvent event) {
//        // ...
//    }
}
