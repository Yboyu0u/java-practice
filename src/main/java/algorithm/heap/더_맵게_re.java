package algorithm.heap;

import java.util.PriorityQueue;

public class 더_맵게_re {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : scoville) {
            queue.add(num);
        }

        int answer = 0;
        while (queue.size() >= 2) {
            if (queue.peek() >= K) {
                break;
            }
            int mixedNum = queue.poll() + queue.poll() * 2;
            queue.add(mixedNum);
            answer++;
        }

        if (!queue.isEmpty() && queue.peek() < K) {
            return -1;
        }
        return answer;
    }
}
