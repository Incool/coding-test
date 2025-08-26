package com.handlestring.service.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 替换测试.
 *
 * @author Incool
 */
@ExtendWith(MockitoExtension.class)
class ReplaceStrategyTest {

    private final ReplaceStrategy replaceStrategy = new ReplaceStrategy();

    @Test
    void handle() {
        String input = "abcccbad";
        String expected = "d";
        String result = replaceStrategy.handle(input);
        assertEquals(expected, result);

        input = "";
        expected = "";
        result = replaceStrategy.handle(input);
        assertEquals(expected, result);

        input = null;
        expected = null;
        result = replaceStrategy.handle(input);
        assertEquals(expected, result);
    }
}