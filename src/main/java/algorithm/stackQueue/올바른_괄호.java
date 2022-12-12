package algorithm.stackQueue;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        // 1. s를 stack 에 넣으면서 짝이 맞으면 pop()
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && (stack.peek() == '(' && c == ')')) {
                stack.pop();
                continue;
            }
            stack.add(c);
        }

        return stack.isEmpty();
    }
}
