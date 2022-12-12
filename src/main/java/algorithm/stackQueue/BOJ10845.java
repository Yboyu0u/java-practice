package algorithm.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    private static final Queue<Integer> QUEUE = new LinkedList<>();
    private static int head = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();

        for (int i = 0; i < n + 1; i++) {
            command(br.readLine());
        }
    }

    private static void command(String order) {
        if (order.startsWith("push")) {
            int number = Integer.parseInt(order.substring(5));
            QUEUE.add(number);
            head = number;
        } else if (order.startsWith("front")) {
            if (QUEUE.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(QUEUE.peek());
        } else if (order.startsWith("back")) {
            if (QUEUE.isEmpty() || head == -1) {
                System.out.println(-1);
                return;
            }
            System.out.println(head);
        } else if (order.startsWith("pop")) {
            if (QUEUE.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(QUEUE.poll());
        } else if (order.startsWith("size")) {
            System.out.println(QUEUE.size());
        } else if (order.startsWith("empty")) {
            if (QUEUE.isEmpty()) {
                System.out.println(1);
                return;
            }
            System.out.println(0);
        }
    }
}
