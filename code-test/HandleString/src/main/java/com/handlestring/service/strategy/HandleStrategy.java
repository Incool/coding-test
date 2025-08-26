package com.handlestring.service.strategy;

/**
 * 字符串处理策略接口.
 *
 * @author Incool
 */
public interface HandleStrategy {
    /**
     * 字符串应用处理规则.
     */
    String handle(String input);
}
