package algorithm.stackQueue;

import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        new 같은_숫자는_싫어().solution(arr);
    }

    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.empty()) {
                stack.add(num);
            } else if (!stack.empty() && stack.peek() != num) {
                stack.add(num);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
