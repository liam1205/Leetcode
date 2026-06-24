package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add((int) binomial(rowIndex, i));
            System.out.printf("n: %s, k: %s -> %s%n", rowIndex, i, list.get(list.size() - 1));
        }
        return list;
    }

    private long binomial(long n, long k) {
        if (k > n || k < 0) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        long result = 1;
        for (long i = 1; i <= k; i++) {
            result *= (n - (i - 1));
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0119 solver = new Solution0119();
        List<Integer> list = solver.getRow(30);
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}
