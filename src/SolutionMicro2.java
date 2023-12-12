import java.util.HashSet;
import java.util.Set;

public class SolutionMicro2 {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        // A first shop
        // B second shop
        int goldCoins = A.length / 2;
        int silverCoins = B.length / 2;

        Set<Integer> entriesA = new HashSet<>();
        for (int element : A) {
            entriesA.add(element);
        }
        int differentCandyA = entriesA.size();

        Set<Integer> entriesB = new HashSet<>();
        for (int element : B) {
            entriesB.add(element);
        }
        int differentCandyB = entriesB.size();

        int boughtA = Math.min(differentCandyA, goldCoins);
        int boughtB = Math.min(differentCandyB, silverCoins);

        return boughtA + boughtB;
    }

    public static void main(String[] args) {
        SolutionMicro2 s = new SolutionMicro2();
        int[] A = new int[]{1,2,3,4};
        int[] B = new int[]{3,3,3,7};
        int sol = s.solution(A, B);
        System.out.println("A=[1,2,3,4] and B=[1,2,3,4]: " + (sol == 4 ? "passed" : ("failed -> " + sol)));
        A = new int[]{2,2,2,2,2,2};
        B = new int[]{7,4,2,5,1,2};
        sol = s.solution(A, B);
        System.out.println("A=[2,2,2,2,2,2] and B=[7,4,2,5,1,2]: " + (sol == 4 ? "passed" : ("failed -> " + sol)));
        A = new int[]{};
        B = new int[]{};
        sol = s.solution(A, B);
        System.out.println("A=[] and B=[]: " + (sol == 0 ? "passed" : ("failed -> " + sol)));
        A = new int[]{2,2};
        B = new int[]{7,4};
        sol = s.solution(A, B);
        System.out.println("A=[2,2] and B=[7,4]: " + (sol == 2 ? "passed" : ("failed -> " + sol)));
        A = new int[]{2,2,2,2,2,2};
        B = new int[]{7,7,7,7,7,7};
        sol = s.solution(A, B);
        System.out.println("A=[2,2,2,2,2,2] and B=[7,7,7,7,7,7]: " + (sol == 2 ? "passed" : ("failed -> " + sol)));
        A = new int[]{1,2,3,4,5,6,7,8,9,10};
        B = new int[]{1,2,3,4,5,6,7,8,9,10};
        sol = s.solution(A, B);
        System.out.println("A=[1,2,3,4,5,6,7,8,9,10] and B=[1,2,3,4,5,6,7,8,9,10]: " + (sol == 10 ? "passed" : ("failed -> " + sol)));
    }
}
