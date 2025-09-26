package com.handlestring.service.event;

import org.springframework.stereotype.Component;
//import org.springframework.transaction.event.TransactionPhase;
//import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 事务绑定事件.
 *
 * @author Incool
 * @data 2025/9/24 10:52
 */
@Component
public class TransactionalUserEventListener {

//    /**
//     * 事务提交后触发.
//     * 其它阶段：BEFORE_COMMIT、AFTER_ROLLBACK、AFTER_COMPLETION
//     */
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    public void afterUserRegisteredCommit(UserRegisteredEvent event) {
//        System.out.println("事务已提交，用户 [" + event.getUserName() + "] 注册成功，执行后续逻辑");
//    }
}
