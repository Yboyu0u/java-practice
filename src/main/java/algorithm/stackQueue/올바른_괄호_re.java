package algorithm.stackQueue;

import java.util.Stack;

public class 올바른_괄호_re {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (!stack.isEmpty() && bracket == RIGHT_BRACKET) {
                stack.pop();
            } else if (bracket == LEFT_BRACKET) {
                stack.push(bracket);
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
