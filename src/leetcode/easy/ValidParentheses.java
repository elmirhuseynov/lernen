package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        var s = "()[]{}"; // {()}
        var isValid = isValid(s);

        System.out.println(isValid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
