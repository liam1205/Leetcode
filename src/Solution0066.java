import java.util.Arrays;
import java.util.Stack;

public class Solution0066 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] == 9) {
            Stack<Integer> stack = new Stack<>();
            int overhead = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9 && overhead == 1) {
                    stack.push(0);
                    if (i == 0) {
                        stack.push(1);
                    }
                } else {
                    stack.push(digits[i] + overhead);
                    overhead = 0;
                }
            }
            int[] result = new int[stack.size()];
            result = Arrays.stream(result).map(s -> s = stack.pop()).toArray();
            return result;
        } else {
            digits[digits.length - 1]++;
            return digits;
        }
    }

    public static void main(String[] args) {
        Solution0066 s = new Solution0066();

        /*
Input: digits = [1,2,3]
Output: [1,2,4]
         */
        s.test(new int[]{1, 2, 3}, new int[]{1, 2, 4});

        /*
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
         */
        s.test(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2});

        /*
Input: digits = [9]
Output: [1,0]
         */
        s.test(new int[]{9}, new int[]{1, 0});

        /*
Input: digits = [9,8,9]
Output: [1,0,9,0]
         */
        s.test(new int[]{9,8,9}, new int[]{9,9,0});
    }

    private void test(int[] digits, int[] expected) {
        printArray(digits);
        System.out.print("\n");
        int[] result = plusOne(digits);

        boolean passed = true;
        try {
            for (int i = 0; i < expected.length; i++) {
                if (result[i] != expected[i]) {
                    passed = false;
                }
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            System.out.println("-> PASSED");
        } else {
            System.out.print("-> FAILED: ");
            printArray(result);
            System.out.print(" when it should be ");
            printArray(expected);
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
