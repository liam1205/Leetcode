package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(binomial(i, j));
            }
            list.add(temp);
        }
        return list;
    }

    private int binomial(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        int result = 1;
        for (int i = 1, m = n; i <= k; i++, m--)
            result = result * m / i;
        return result;
    }

    public static void main(String[] args) {
        Solution0118 solver = new Solution0118();
        List<List<Integer>> first = solver.generate(14);
        for (List<Integer> list : first) {
            for (int e : list) {
                System.out.print(e + " ");
            }
            System.out.print("\n");
        }
        System.out.println(solver.binomial(13, 1));
    }
}
