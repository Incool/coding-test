package com.handlestring.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件.
 *
 * @author Incool
 * @data 2025/9/24 10:30
 */
public class UserRegisteredEvent extends ApplicationEvent {

    private final String userName;

    public UserRegisteredEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
