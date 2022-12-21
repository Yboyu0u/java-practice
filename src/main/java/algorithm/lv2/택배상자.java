package algorithm.lv2;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        new 택배상자().solution(order);
    }

    public int solution(int[] order) {
        int currentBox = 1;
        int orderIdx = 0;
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        while (currentBox < order.length + 1 || !stack.isEmpty()) {
            if (orderIdx >= order.length) {
                break;
            }
            if (stack.peek() == order[orderIdx]) {
                stack.pop();
                orderIdx++;
                answer++;
                continue;
            }
            if (currentBox != order[orderIdx]) {
                stack.push(currentBox);
            }
            if (currentBox == order[orderIdx]) {
                orderIdx++;
                answer++;
            }
            currentBox++;
            if (currentBox > order.length && stack.peek() != order[orderIdx]) {
                break;
            }
        }
        return answer;
    }
}
