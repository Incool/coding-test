package com.handlestring.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 字符串匹配单元测试.
 */
@ExtendWith(MockitoExtension.class)
public class StringMatcherTest {

    @Test
    void testContains_WhenInitializedWithList_ShouldReturnCorrectBoolean() {
        // 准备数据
        List<String> initData = Arrays.asList("cat", "dog", "bird", "blur");
        StringMatcher matcher = new StringMatcher();
        matcher.init(initData);

        // 验证 contains 的返回结果
        assertTrue(matcher.contains("cat"));
        assertFalse(matcher.contains("human"));
    }

    @Test
    public void testContains_WithWildcard_ShouldMatchCorrectly() {
        // 准备数据
        List<String> initData = Arrays.asList("cat", "dog", "bird", "blur");
        StringMatcher matcher = new StringMatcher();
        matcher.init(initData);

        // 2. 验证带通配符的场景
        assertTrue(matcher.contains("*at"));
        assertFalse(matcher.contains("b*t"));
        assertTrue(matcher.contains("d*g"));
        assertFalse(matcher.contains("*xy"));
    }
}
