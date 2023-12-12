import java.util.Arrays;

public class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = Arrays.copyOf(nums1, m+n);
        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < m + n; i++) {
            if (pointer2 < n && pointer1 < m) {
                if (newNums1[pointer1] < nums2[pointer2]) {
                    nums1[i] = newNums1[pointer1];
                    pointer1++;
                } else {
                    nums1[i] = nums2[pointer2];
                    pointer2++;
                }
            } else if (pointer2 < n) { // pointer1 >= m
                nums1[i] = nums2[pointer2];
                pointer2++;
            } else if (pointer1 < m) { // pointer 2 >= n
                nums1[i] = newNums1[pointer1];
                pointer1++;
            }
        }
    }



    public static void main(String[] args) {
        Solution0088 s = new Solution0088();

        /*
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
         */
        s.test(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6});

        /*
        Input: nums1 = [1], m = 1, nums2 = [], n = 0
        Output: [1]
         */
        s.test(new int[]{1}, 1, new int[]{}, 0, new int[]{1});

        /*
        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
         */
        s.test(new int[]{0}, 0, new int[]{1}, 1, new int[]{1});
    }

    private void test(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        merge(nums1, m, nums2, n);

        if (expected.length != nums1.length) {
            System.out.print("-> FAILED: ");
            printArray(nums1);
            System.out.print(" does not equal ");
            printArray(expected);
            System.out.println();
            return;
        }

        boolean passed = false;
        for (int i = 0; i < nums1.length; i++) {
            if (expected[i] != nums1[i]) {
                passed = false;
                break;
            } else {
                passed = true;
            }
        }

        if (passed) {
            System.out.println("-> PASSED: ");
            printArray(nums1);
            System.out.println();
        } else {
            System.out.print("-> FAILED: ");
            printArray(nums1);
            System.out.print(" does not equal ");
            printArray(expected);
            System.out.println();
        }
    }

    private void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }

        System.out.print("]");
    }
}
