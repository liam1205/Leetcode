public class Solution0069 {
    public int mySqrt(int x) {
        //
        double guess = (double) x / 2;
        //
        double tolerance = 0.01;

        // as long as ((guess)² - x) is bigger than the tolerance
        // e.g.,:
        // (1) -> x = 5 -> guess = 2.5 -> 2.5² = 6.25 -> 6.25 - 5 = 1.25 > 0.01
        // (2) -> x = 5 -> guess = 2.25 -> 2.25² = 5.0625 -> 5.0625 - 5 = 0.0625 > 0.01
        // (3) -> x = 5 -> guess = 2.11 -> 2.11² = 4.4568 -> 4.4568 - 5 = -0.5432 < 0.01
        while (Math.abs(guess * guess - x) > tolerance) {
            // new guess is (guess+(x/guess))/2)
            // e.g.,
            // (1) -> guess = (2.5 + 5/2.5)/2 = 2.25
            // (2) -> guess = (2.25 + 5/2.25)/2 = 2.11
            guess = (guess + x / guess) / 2;
        }

        // e.g.,
        // -> guess = 2.11 as double
        // -> guess = 2 as int

        return (int) guess;
    }
}
