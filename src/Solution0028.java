class Solution0028 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            try {
                if (haystack.startsWith(needle, i)) {
                    return i;
                }
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution0028 s = new Solution0028();

        // input: haystack = "sadbutsad", needle = "sad"
        // output: 0
        s.test("sadbutsad", "sad", 0);

        // input: haystack = "leetcode", needle = "leeto"
        // output: -1
        s.test("leetcode", "leeto", -1);
    }

    private void test(String haystack, String needle, int expected) {
        System.out.print("haystack: " + "'" + haystack + "', ");
        System.out.println("needle: " + "'" + needle + "'");
        if (strStr(haystack, needle) == expected) {
            System.out.println("-> PASSED");
        } else {
            System.out.println("-> FAILED: " + strStr(haystack, needle) + " should be " + expected);
        }
    }
}