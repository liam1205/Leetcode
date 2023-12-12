public class Solution0013 { // EASY
    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();

        int result = 0;

        for (int i = 0; i < chars.length; i++){
            result += giveValue(chars, i);
        }

        return result;
    }

    private static int giveValue(char[] chars, int i) {
        switch (chars[i]) {
            case 'I':
                if((i+1) < chars.length) {
                    if(chars[i+1] == 'V' || chars[i+1] == 'X') {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            case 'V':
                return 5;
            case 'X':
                if((i+1) < chars.length) {
                    if(chars[i+1] == 'L' || chars[i+1] == 'C') {
                        return -10;
                    } else {
                        return 10;
                    }
                } else {
                    return 10;
                }
            case 'L':
                return 50;
            case 'C':
                if((i+1) < chars.length) {
                    if(chars[i+1] == 'D' || chars[i+1] == 'M') {
                        return -100;
                    } else {
                        return 100;
                    }
                } else {
                    return 100;
                }
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
