import java.util.Stack;

public class Solution0020 { // EASY
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            /* if the next character is "(", push a ")" to the stack */
            if (c == '(') {
                stack.push(')');
            }
            /* if the next character is "{", push a ")" to the stack */
            else if (c == '{') {
                stack.push('}');
            }
            /* if the next character is "[", push a ")" to the stack */
            else if (c == '[') {
                stack.push(']');
            }
            /* if ( only opening braces until now OR the item on top of the stack is not the current character in line)*/
            else if (stack.empty() || stack.pop() != c){
                return false;
            }
        }
        return stack.empty();
    }
}
