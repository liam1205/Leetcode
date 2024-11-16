import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution0003 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set set = new HashSet();
        int len = 0;
        int l = 0;
        int r = 0;

        for (r=0;r < s.length(); r++) {
            if (!set.contains(s.charAt(r))) {
                len = (r - l + 1 > len) ? r - l + 1 : len;
                set.add(s.charAt(r));
            }
            else {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
            }
        }
        return len;
    }
}
