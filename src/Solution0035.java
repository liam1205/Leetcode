import java.util.Arrays;

class Solution0035 {
    public int searchInsert(int[] nums, int target) {
        int leftI = 0;
        int rightI = nums.length - 1;
        int middleI = (leftI + rightI) / 2;

        while (leftI <= rightI) {
            // if target equal to current middle value
            if (nums[middleI] == target) {
                return middleI;
            }
            // if target larger than current middle element
            else if (target > nums[middleI]) {
                leftI = middleI + 1;
            }
            // if target smaller than current middle element
            else {
                rightI = middleI - 1;
            }
            middleI = (leftI + rightI) / 2;
        }

        return rightI < 0 ? middleI : middleI + 1;
    }

    public static void main(String[] args) {
        Solution0035 s = new Solution0035();

        // Input: nums = [1,3,5,6], target = 5
        // Output: 2
        s.test(new int[]{1, 3, 5, 6}, 5, 2);

        // Input: nums = [1,3,5,6], target = 2
        // Output: 1
        s.test(new int[]{1, 3, 5, 6}, 2, 1);

        // Input: nums = [1,3,5,6], target = 7
        // Output: 4
        s.test(new int[]{1, 3, 5, 6}, 7, 4);

        // Input: nums = [1,3,5,6], target = 0
        // Output: 0
        s.test(new int[]{1, 3, 5, 6}, 0, 0);
    }

    private void test(int[] nums, int target, int expected) {
        int result = searchInsert(nums, target);

        System.out.print("nums: [");
        Arrays.stream(nums).forEach(s -> System.out.print(" " + s + " "));
        System.out.println("], target: " + target);
        if (result == expected) {
            System.out.println("-> PASSED");
        } else {
            System.out.println("-> FAILED: " + result + " should be " + expected);
        }
    }
}