package algorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10828 {
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n + 1; i++) {
            command(scanner.nextLine());
        }
    }

    private static void command(String order) {
        if (order.startsWith("push")) {
            int number = Integer.parseInt(order.substring(5));
            stack.add(number);
        }
        else if (order.startsWith("top")) {
            if(stack.empty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.peek());
        }
        else if (order.startsWith("pop")) {
            if(stack.empty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.pop());
        }
        else if (order.startsWith("size")) {
            System.out.println(stack.size());
        }
        else if (order.startsWith("empty")) {
            if(stack.empty()) {
                System.out.println(1);
                return;
            }
            System.out.println(0);
        }
    }
}
