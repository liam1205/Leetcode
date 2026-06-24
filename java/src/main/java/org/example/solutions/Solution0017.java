package org.example.solutions;

import java.util.*;

public class Solution0017 {

    Map<Character, String> mapping = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    char[] arr;
    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        this.arr = digits.toCharArray();
        Stack<Character> stack = new Stack<>();
        helper(stack, 0);
        return res;
    }

    private void helper(Stack<Character> stack, int i) {
        if(i == arr.length) {
            res.add(convertStackToString(stack));
            return;
        }

        String curString = mapping.get(arr[i]);

        for(char cur: curString.toCharArray()) {
            stack.add(cur);
            helper(stack, i + 1);
            stack.pop();
        }
    }

    private String convertStackToString(Stack<Character> stack) {
        Iterator it = stack.iterator();
        StringBuilder str = new StringBuilder();
        while (it.hasNext()) {
            str.append(it.next());
        }
        return str.toString();
    }
}
