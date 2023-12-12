import java.lang.reflect.Array;
import java.util.ArrayList;

public class SolutionMicro1 {

    public static int solution(String S) {
        ArrayList<Integer> reds = new ArrayList<>();
        int swaps = 0;
        int firstRed = 0;

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'R') {
                reds.add(i);
                if (reds.size() == 1) {
                    firstRed = i;
                }
            }
        }
        int redBalls = reds.size();
        if(redBalls == 0) {
            return 0;
        }
        if(redBalls == S.length()) {
            return 0;
        }
        if(S.length() == 2) {
            return -1;
        }
        swaps = S.length() - redBalls - firstRed;

        if (swaps >= 100000) {
            return -1;
        }

        return swaps;
    }

    private static void swap(String string, int i, int j) {
        char temp = string.charAt(i);
        string = string.substring(0, i) + string.charAt(j) + string.substring(i + 1);
        string = string.substring(0, j) + temp + string.substring(j + 1);
    }

    public static void main (String[] args) {
        SolutionMicro1 s = new SolutionMicro1();
        System.out.println("'WRRWWR': " + (s.solution("WRRWWR") == 2 ? "passed" : ("failed -> " + s.solution("WRRWWR"))));
        System.out.println("'WWRWWWRWR': " + (s.solution("WWRWWWRWR") == 4 ? "passed" : ("failed -> " + s.solution("WWRWWWRWR"))));
        System.out.println("'WWW': " + (s.solution("WWW") == 0 ? "passed" : ("failed -> " + s.solution("WRRWWR"))));
        System.out.println("'RW': " + (s.solution("RW") == -1 ? "passed" : ("failed -> " + s.solution("RW"))));
        System.out.println("'WR': " + (s.solution("RW") == -1 ? "passed" : ("failed -> " + s.solution("RW"))));
        System.out.println("'WRR': " + (s.solution("WRR") == 0 ? "passed" : ("failed -> " + s.solution("WRR"))));
        System.out.println("'RRW': " + (s.solution("RRW") == 0 ? "passed" : ("failed -> " + s.solution("RRW"))));
        System.out.println("'RRRRWRRRR': " + (s.solution("RRRRWRRRR") == 4 ? "passed" : ("failed -> " + s.solution("RRRRWRRRR"))));
        System.out.println("'RRRRRRRWR': " + (s.solution("RRRRRRRWR") == 1 ? "passed" : ("failed -> " + s.solution("RRRRRRRWR"))));
        System.out.println("'RRWRR': " + (s.solution("RRWRR") == 2 ? "passed" : ("failed -> " + s.solution("RRWRR"))));
    }

}
