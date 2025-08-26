package com.handlestring.service.impl;

import com.handlestring.service.strategy.DeleteStrategy;
import com.handlestring.service.strategy.ReplaceStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 字符处理业务单元测试.
 *
 * @author Incool
 */
@ExtendWith(MockitoExtension.class)
class StringProcessServiceImplTest {

    @InjectMocks
    private StringProcessServiceImpl stringProcessService;

    private DeleteStrategy deleteStrategy = new DeleteStrategy();

    private ReplaceStrategy replaceStrategy = new ReplaceStrategy();

    /**
     * 删除策略测试.
     */
    @Test
    void handle_DeleteStrategy_Test() {
        //非法参数-包含数字
        String inputContainNum = "aabccc123bbad";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputContainNum, deleteStrategy);
        });
        //非法参数-包含大写字符串
        String inputContainUperStr = "aabcccABCbbad";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputContainUperStr, deleteStrategy);
        });
        //非法参数-包含特殊字符
        String inputContainSpecStr = "aabccc@bbad";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputContainSpecStr, deleteStrategy);
        });
        //非法参数-空字符串
        String inputSpecStr = "";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputSpecStr, deleteStrategy);
        });
        //非法参数-null
        String inputNull = null;
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputNull, deleteStrategy);
        });

        //正常参数
        String input = "aabcccbbad";
        String expected = "d";
        String result = stringProcessService.handle(input, deleteStrategy);
        assertEquals(expected, result);

        input = "abc";
        expected = "abc";
        result = stringProcessService.handle(input, deleteStrategy);
        assertEquals(expected, result);
    }

    /**
     * 替换策略测试.
     */
    @Test
    void handle_ReplaceStrategy_Test() {
        //非法参数-包含数字
        String inputContainNum = "aabccc123bbad";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputContainNum, replaceStrategy);
        });
        //非法参数-包含大写字符串
        String inputContainUperStr = "aabcccABCbbad";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputContainUperStr, replaceStrategy);
        });
        //非法参数-包含特殊字符
        String inputContainSpecStr = "aabccc@bbad";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputContainSpecStr, replaceStrategy);
        });
        //非法参数-空字符串
        String inputSpecStr = "";
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputSpecStr, replaceStrategy);
        });
        //非法参数-null
        String inputNull = null;
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessService.handle(inputNull, replaceStrategy);
        });

        //正常参数
        String input = "abcccbad";
        String expected = "d";
        String result = stringProcessService.handle(input, replaceStrategy);
        assertEquals(expected, result);

        input = "abc";
        expected = "abc";
        result = stringProcessService.handle(input, replaceStrategy);
        assertEquals(expected, result);
    }
}