package org.example.solutions;

import java.util.*;

public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length - 1; i++) {
            // Two Sum
            int temp = nums[i];
            if (i > 0 && temp == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = temp + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++;
                    while (nums[l] == nums[l-1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    public static void main( String[] args ) {
        Solution0015 sol = new Solution0015();
        List<List<Integer>> list = sol.threeSum(new int[]{-1,0,1,2,-1,-4});

        for(List<Integer> e : list)  {
            for (int i : e) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        List<List<Integer>> list1 = sol.threeSum(new int[]{0,0,0,0});

        for(List<Integer> e : list1)  {
            for (int i : e) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
