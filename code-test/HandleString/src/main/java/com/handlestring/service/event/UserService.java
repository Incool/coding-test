package com.handlestring.service.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 事件发布者.
 *
 * @author Incool
 * @data 2025/9/24 10:38
 */
@Service
public class UserService {

    private final ApplicationEventPublisher eventPublisher;

    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void registerUser(String userName) {
        // 业务逻辑：比如保存用户到数据库
        System.out.println("用户注册：" + userName);

        // 发布用户注册事件
        UserRegisteredEvent event = new UserRegisteredEvent(this, userName);
        eventPublisher.publishEvent(event);
    }
}
