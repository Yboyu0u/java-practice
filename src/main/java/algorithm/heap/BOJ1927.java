package algorithm.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        // 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거
        // 자연수: 배열에 자연수를 넣는다.
        // 0: 배열에서 가장 작은 값 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num > 0) {
                    priorityQueue.add(num);
                    continue;
                }
                if (!priorityQueue.isEmpty()) {
                    System.out.println(priorityQueue.poll());
                    continue;
                }
                System.out.println(0);
            }
        }
    }
