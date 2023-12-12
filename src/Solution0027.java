import java.util.ArrayList;
import java.util.Set;

public class Solution0027 {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                result.add(nums[i]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return result.size();
    }

    public static void main(String[] args) {
        Solution0027 s = new Solution0027();

        // input: nums = [3,2,2,3], val = 3
        // output: 2, nums = [2,2,_,_]
        s.test(new int[]{3,2,2,3}, 3, new int[]{2,2}, 2);

        // input: nums = [0,1,2,2,3,0,4,2], val = 2
        // output: 5, nums = [0,1,3,0,4,_,_,_]
        s.test(new int[]{0,1,2,2,3,0,4,2}, 2, new int[]{0,1,3,0,4}, 5);
    }

    private void test(int [] nums, int val, int[] expectedNums, int expectedK) {
        int k = removeElement(nums, val);
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
