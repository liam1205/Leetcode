import java.util.Arrays;

public class Solution0058 {
    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean wordStarted = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (wordStarted) {
                    break;
                }
            } else {
                wordStarted = true;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0058 s = new Solution0058();

        /*
        Input: s = "Hello World"
        Output: 5
         */
        s.test("Hello World", 5);

        /*
        Input: s = "   fly me   to   the moon  "
        Output: 4
         */
        s.test("   fly me   to   the moon  ", 4);

        /*
        Input: s = "luffy is still joyboy"
        Output: 6
         */
        s.test("luffy is still joyboy", 6);
    }

    private void test(String s, int expected) {
        int result = lengthOfLastWord(s);

        System.out.println("Input: " + s);

        if ( result == expected ) {
            System.out.println("-> PASSED");
        } else {
            System.out.println("-> FAILED: " + result + " when it should be " + expected);
        }

    }
}
