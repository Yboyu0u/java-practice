package algorithm.heap;

import java.util.PriorityQueue;

public class 더_맵게 {
    public static void main(String[] args) {
        int[] scovile = {1,2,3};
        int K = 11;
        System.out.println(new  더_맵게().solution(scovile, K));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int scov : scoville) {
            priorityQueue.add(scov);
        }

        int answer = 0;
        while (priorityQueue.peek() < K) {
            int first = priorityQueue.poll();

            if (priorityQueue.isEmpty() && first < K) {
                return -1;
            }

            int second = priorityQueue.poll();
            int mix = first + (second * 2);
            priorityQueue.add(mix);
            answer++;
        }

        return answer;
    }
}
