import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Solution0014 { // EASY
    public static String longestCommonPrefix(String[] strs) {
        // get the shortest entry inside of the array
        String shortest = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).orElse(null);

        // get the array without the shortest entry
        strs = Arrays.stream(strs).filter(s1 -> !s1.equals(shortest)).toArray(String[]::new);
        StringBuilder sb = new StringBuilder();

        // if the shortest entry of the original array is "" it can directly be returned
        if (Objects.equals(shortest, "")) {
            return "";
        } else {
            int counter = 0;
            for (int i = 0; i < Objects.requireNonNull(shortest).length(); i++) {
                counter = 0;
                char c1 = shortest.charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    char c2 = strs[j].charAt(i);
                    if (c1 == c2) {
                        counter++;
                    } else {
                        break;
                    }
                }
                if (counter == strs.length) {
                    sb.append(shortest.charAt(i));
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
