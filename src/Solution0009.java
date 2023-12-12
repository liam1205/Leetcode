public class Solution0009 { // EASY
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            String xRev = Integer.toString(x);
            StringBuilder sb = new StringBuilder(xRev);
            sb.reverse();
            return xRev.contentEquals(sb);
        }
    }

    public static void main (String[] args) {
        Solution0009 s = new Solution0009();
        System.out.println(s.isPalindrome(121));
    }
}
