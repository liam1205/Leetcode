import java.util.ArrayList;
import java.util.Arrays;

class SolutionDemo1 {
    public int solution(int[] A) {
            // Implement your solution here
            A = Arrays.stream(A).sorted().toArray();
            int current = 0;
            for(int i = 0; i < A.length; i++) {
                if(A[i] > 0) {
                    if (A[i] - current > 1) {
                        return current + 1;
                    } else {
                        current = A[i];
                    }
                }
            }
            return current + 1;
    }

    public static void main(String[] args) {
        SolutionDemo1 s = new SolutionDemo1();
        // [1, 3, 6, 4, 1, 2]
        System.out.println("[1, 3, 6, 4, 1, 2]: " + ((s.solution(new int []{1, 3, 6, 4, 1, 2})==5) ? "PASSED" : ("FAILED " + s.solution(new int []{1, 3, 6, 4, 1, 2})) ));
        // [1, 2, 3],
        System.out.println("[1, 2, 3]: " + ((s.solution(new int []{1, 2, 3})==4) ? "PASSED" : ("FAILED " + s.solution(new int []{1, 2, 3})) ));
        // [-1, -3]
        System.out.println("[-1, -3]: " + ((s.solution(new int []{-1, -3})==1) ? "PASSED" : ("FAILED " + s.solution(new int []{-1, -3})) ));
        // [0]
        System.out.println("[0]: " + ((s.solution(new int []{0})==1) ? "PASSED" : ("FAILED " + s.solution(new int []{0})) ));
        // []
        System.out.println("[]: " + ((s.solution(new int []{})==1) ? "PASSED" : ("FAILED " + s.solution(new int []{})) ));
        // [4,3,2,1]
        System.out.println("[4,3,2,1]: " + ((s.solution(new int []{4,3,2,1})==5) ? "PASSED" : ("FAILED " + s.solution(new int []{4,3,2,1})) ));
    }
}
