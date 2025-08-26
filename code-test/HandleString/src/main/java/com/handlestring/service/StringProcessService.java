package com.handlestring.service;

import com.handlestring.service.strategy.HandleStrategy;

/**
 * 字符串处理.
 *
 * @author Incool
 */
public interface StringProcessService {
    /**
     * 返回处理后的字符串.
     *
     * @param input 输入要处理的字符串.
     * @param handleStrategy 处理策略
     * @return 返回处理后的字符串.
     */
    String handle(String input, HandleStrategy handleStrategy);
}
