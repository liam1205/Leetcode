public class Solution0001 { // EASY
    public int[] twoSum(int[] nums, int target) {
        int[] toReturn = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 3 mal
            for (int j = i + 1; j < nums.length; ++j) {
                // 3 mal
                if(nums[i] + nums[j] == target){
                    toReturn[0] = i;
                    toReturn[1] = j;
                    return toReturn;
                }
            }
        }
        return toReturn;
    }
}
