import java.util.HashSet;
import java.util.Set;

class Solution0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int counter = 0;
        int l = 0;
        int r = 0;
        while (counter < nums.length){
            if (l < nums1.length && r < nums2.length) {
                if(nums1[l] > nums2[r]) {
                    nums[counter] = nums2[r];
                    r++;
                } else {
                    nums[counter] = nums1[l];
                    l++;
                }
            } else if (l == nums1.length) {
                nums[counter] = nums2[r];
                r++;
            } else if (r == nums2.length) {
                nums[counter] = nums1[l];
                l++;
            }
            counter++;
        }

        double res = 0;
        if (nums.length % 2 == 0) {
            res = ((double) nums[nums.length/2] + (double) nums[nums.length/2 -1]) / 2;
        } else {
            res = (double) nums[nums.length/2];
        }
        return res;
    }
}
