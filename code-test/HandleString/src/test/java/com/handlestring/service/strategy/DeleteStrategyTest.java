package com.handlestring.service.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 删除测试.
 *
 * @author Incool
 */
@ExtendWith(MockitoExtension.class)
class DeleteStrategyTest {

    private final DeleteStrategy deleteStrategy = new DeleteStrategy();

    @Test
    void handleTest() {
        String input = "aabcccbbad";
        String expected = "d";
        String result = deleteStrategy.handle(input);
        assertEquals(expected, result);

        input = "";
        expected = "";
        result = deleteStrategy.handle(input);
        assertEquals(expected, result);

        input = null;
        expected = null;
        result = deleteStrategy.handle(input);
        assertEquals(expected, result);
    }
}