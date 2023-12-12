public class Solution0070 {
    public static int climbStairs(int n) {
        if(n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int prevprev = 1;
        int prev = 1;
        int fib = prevprev + prev;
        for (int i = 2; i < n; i++) {
            prevprev = prev;
            prev = fib;
            fib = prev + prevprev;
        }
        return fib;
    }

    public static void main(String[] args) {
        Solution0070 s = new Solution0070();

        /*
        Input: 1
        Output: 1
         */
        s.test(1, 1);

        /*
        Input: 2
        Output: 2
         */
        s.test(2, 2);

        /*
        Input: 3
        Output: 3
         */
        s.test(3, 3);

        /*
        Input: 4
        Output: 5
         */
        s.test(4, 5);

        /*
        Input: 35
        Output: 14930352
         */
        s.test(35, 14930352);

        /*
        Input: 45
        Output: 14930352
         */
        s.test(45, 1836311903);
    }

    private void test(int n, int expected) {
        int result = climbStairs(n);

        if (result == expected) {
            System.out.println("-> PASSED: '" + result + "'");
        } else {
            System.out.print("-> FAILED: ");
            System.out.println("'" + result + "' when it should be '" + expected + "'");
        }
    }
}
