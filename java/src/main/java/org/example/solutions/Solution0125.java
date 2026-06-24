package org.example.solutions;

import java.util.List;

public class Solution0125 {
    public boolean isPalindrome(String s) {
        String lowercase = removeNonPalindromeCharacters(s).toLowerCase();
        int left = 0;
        int right = lowercase.length() - 1;
        while (left < right) {
            if (lowercase.charAt(left) != lowercase.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeOptimized(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String removeNonPalindromeCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isAlphanumeric(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isAlphanumeric(char c) {
        return (Character.isAlphabetic(c) || Character.isDigit(c));
    }

    public static void main(String[] args) {
        Solution0125 solver = new Solution0125();
        System.out.println(solver.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solver.isPalindrome("race a car"));
        System.out.println(solver.isPalindrome(" "));
        System.out.println(solver.isPalindrome("0P"));
    }
}
