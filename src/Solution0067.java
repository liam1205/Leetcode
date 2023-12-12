public class Solution0067 {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String app = "0";
            b = app.repeat(a.length() - b.length()) +
                    b;
        } else if (a.length() < b.length()) {
            String app = "0";
            a = app.repeat(b.length() - a.length()) +
                    a;
        }

        StringBuilder sb = new StringBuilder();
        boolean ubertrag = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (ubertrag) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                ubertrag = false;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0' || a.charAt(i) == '0' && b.charAt(i) == '1') {
                if (ubertrag) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1'){
                if (ubertrag) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                ubertrag = true;
            }
        }
        if (ubertrag) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution0067 s = new Solution0067();

        /*
        Input: a = "11", b = "1"
        Output: "100"
         */
        s.test("11", "1", "100");

        /*
        Input: a = "1010", b = "1011"
        Output: "10101"
         */
        s.test("1010", "1011", "10101");

        /*
        Input: a = "1", b = "111"
        Output: "1000"
         */
        s.test("1", "111", "1000");
    }

    private void test(String a, String b, String expected) {
        System.out.println("a: " + a + ", b: " + b);
        String result = addBinary(a, b);

        if (expected.equals(result)) {
            System.out.println("-> PASSED: '" + result + "'");
        } else {
            System.out.print("-> FAILED: ");
            System.out.println("'" + result + "' when it should be '" + expected + "'");
        }
    }
}
