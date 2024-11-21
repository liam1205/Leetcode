import java.util.ArrayList;
import java.util.List;

public class Solution0136 {

    /* O(1) -> XOR
        1 ^ 1 -> 0
        0 ^ 0 -> 0
        0 ^ 1 -> 1
        1 ^ 0 -> 1
    * */
    public int singleNumber(int[] nums) {
        int number = 0;
        String binary = Integer.toBinaryString(0);
        for (int num : nums) {
            number ^= num;
        }
        return number;
    }

    // O(n)
    public int singleNumberNotOptimized(int[] nums) {
        List<Integer> once = new ArrayList<>();
        for (int num : nums) {
            if (!once.contains(num)) {
                once.add(num);
            } else {
                once.remove(Integer.valueOf(num));
            }
        }
        return once.getFirst();
    }

    public static void main(String[] args) {
        Solution0136 solver = new Solution0136();
        System.out.println(solver.singleNumber(new int[]{2,2,1}));
        System.out.println(solver.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(solver.singleNumber(new int[]{1}));
    }
}
