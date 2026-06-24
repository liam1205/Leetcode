package org.example.solutions;

public class Solution0007 {
    public int reverse(int x) {
        if(x == 0) {
            return x;
        }
        int abs = Math.abs(x);
        try {
            int res = Integer.parseInt(new StringBuilder(Integer.toString(abs)).reverse().toString());
            if (x < 0) {
                res = res * -1;
            }
            return res;
        } catch(Exception e) {
            return 0;
        }
    }
}
