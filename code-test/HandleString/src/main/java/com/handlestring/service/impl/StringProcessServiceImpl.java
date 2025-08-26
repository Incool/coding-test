package com.handlestring.service.impl;

import com.handlestring.service.StringProcessService;
import com.handlestring.service.strategy.HandleStrategy;
import org.springframework.stereotype.Service;

/**
 * 字符串处理.
 *
 * @author Incool
 */
@Service
public class StringProcessServiceImpl implements StringProcessService {

    /**
     * 返回处理后的字符串.
     *
     * @param input 输入要处理的字符串.
     * @param handleStrategy 处理策略
     * @return 返回处理后的字符串.
     */
    public String handle(String input, HandleStrategy handleStrategy) {
        if (!isOnlyLowercaseLetters(input)) {
            throw new IllegalArgumentException("输入参数只能包含小写字母 a-z，不能包含其他字符");
        }
        return handleStrategy.handle(input);
    }

    /**
     * 校验字符串是否只包含 a-z 小写字母.
     */
    private boolean isOnlyLowercaseLetters(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return input.matches("^[a-z]+$");
    }
}
