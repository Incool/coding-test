package com.handlestring.service.impl;

import java.util.List;

/**
 * 字符串匹配.
 */
public class StringMatcher {

    private List<String> dataList;

    /**
     * 初始化方法：接收一个字符串列表.
     */
    public void init(List<String> data) {
        this.dataList = data;
    }

    /**
     * 判断传入的字符串是否在初始化列表中.
     */
    public boolean contains(String word) {
        //return dataList.contains(word);
        for (String str : dataList) {
            if (isMatch(str, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(String str, String pattern) {
        if (str.length() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c1 = pattern.charAt(i);
            if (c1 != '*' && c1 != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
