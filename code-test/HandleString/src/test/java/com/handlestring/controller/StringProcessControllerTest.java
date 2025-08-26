package com.handlestring.controller;

import com.handlestring.service.StringProcessService;
import com.handlestring.service.strategy.DeleteStrategy;
import com.handlestring.service.strategy.ReplaceStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 字符处理API单元测试
 *
 * @author Incool
 */
@ExtendWith(MockitoExtension.class)
class StringProcessControllerTest {

    @Mock
    private StringProcessService stringProcessService;

    @InjectMocks
    private StringProcessController stringProcessController;


    @Test
    void deleteHandleTest() {
        String input = "aabcccbbad";
        String expected = "d";
        Mockito.when(stringProcessService.handle(Mockito.anyString(), Mockito.any(DeleteStrategy.class)))
                .thenReturn(expected);
        String result = stringProcessController.deleteHandle(input);
        assertEquals(expected, result);
    }

    @Test
    void replaceHandleTest() {
        String input = "abcccbad";
        String expected = "d";
        Mockito.when(stringProcessService.handle(Mockito.anyString(), Mockito.any(ReplaceStrategy.class)))
                .thenReturn(expected);
        String result = stringProcessController.replaceHandle(input);
        assertEquals(expected, result);
    }
}