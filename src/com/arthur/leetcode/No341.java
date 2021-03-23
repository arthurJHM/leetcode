package com.arthur.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @title: No341
 * @Author ArthurJi
 * @Date: 2021/3/23 9:36
 * @Version 1.0
 */
public class No341 implements Iterator<Integer> {

    ArrayDeque<Integer> list = new ArrayDeque<Integer>();

    public No341(List<No341_NestedInteger> nestedList) {
        dfs(nestedList);
    }

    private void dfs(List<No341_NestedInteger> nestedList) {
        if (!nestedList.isEmpty()) {
            for (int i = 0; i < nestedList.size(); i++) {
                No341_NestedInteger temp = nestedList.get(i);
                if(temp.isInteger()) {
                    list.offer(temp.getInteger());
                }else {
                    dfs(temp.getList());
                }
            }
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? list.pollFirst() : -1;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
