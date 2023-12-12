import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution0026 {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return result.size();
    }

    public static void main(String[] args) {
        Solution0026 s = new Solution0026();

        // input: nums = [1,1,2]
        // output: 2, nums = [1,2,_]
        s.test(new int[]{1, 1, 2}, new int[]{1, 2}, 2);

        // input: nums = [0,0,1,1,1,2,2,3,3,4]
        // output: [0,1,2,3,4]
        s.test(new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0,1,2,3,4}, 5);
    }

    private void test(int [] nums, int[] expectedNums, int expectedK) {
        int k = removeDuplicates(nums);
        System.out.println("k: " + k + " -> " + (k == expectedNums.length));

        boolean check = true;
        System.out.print("nums: [");
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                System.out.print(nums[i]);
            } else  {
                System.out.print(nums[i] + ", ");
            }
            check = nums[i] == expectedNums[i];
        }
        System.out.println("] -> " + check);
    }
}