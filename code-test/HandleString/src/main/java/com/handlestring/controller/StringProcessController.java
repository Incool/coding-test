package com.handlestring.controller;

import com.handlestring.service.StringProcessService;
import com.handlestring.service.strategy.ReplaceStrategy;
import com.handlestring.service.strategy.DeleteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字符串处理API.
 *
 * @author Incool
 */
@RestController
@RequestMapping("/api/v1/processor")
public class StringProcessController {

    @Autowired
    private StringProcessService stringProcessService;

    /**
     * 删除字符串.
     */
    @GetMapping("/deleteHandle")
    public String deleteHandle(String input) {
        return stringProcessService.handle(input, new DeleteStrategy());
    }

    /**
     * 替换字符串.
     */
    @GetMapping("/replaceHandle")
    public String replaceHandle(String input) {
        return stringProcessService.handle(input, new ReplaceStrategy());
    }
}
