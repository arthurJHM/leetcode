package com.arthur.bishi.youzan;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 11:10
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public boolean isMatch (String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if(matchs(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if(matchs(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
        // write code here
    }

    private boolean matchs(String s, String p, int i, int j) {
        if(i == 0) {
            return false;
        }
        if(p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
