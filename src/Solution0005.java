public class Solution0005 {
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        int resL = 0;
        int resR = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resR - resL + 1) {
                    resL = l;
                    resR = r;
                }
                l--;
                r++;
            }

            // odd length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resR - resL + 1) {
                    resL = l;
                    resR = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(resL, resR + 1);
    }
}
