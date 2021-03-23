package com.arthur.leetcode;

import java.util.List;

/**
 * @title: No341_NestedInteger
 * @Author ArthurJi
 * @Date: 2021/3/23 9:41
 * @Version 1.0
 */
public interface No341_NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<No341_NestedInteger> getList();
}
