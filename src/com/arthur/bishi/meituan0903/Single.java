package com.arthur.bishi.meituan0903;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/29 16:14
 * @modifiedBy：
 * @version: 1.0
 */
public class Single {
    private volatile Single single;

    public Single getSingle() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

    private Single() {
    }
}
