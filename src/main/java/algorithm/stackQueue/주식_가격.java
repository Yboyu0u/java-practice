package algorithm.stackQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 주식_가격 {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }

        int[] answer = new int[prices.length];
        int idx = 0;
        while (!queue.isEmpty()) {
            int currentPrice = queue.poll();
            int count = 0;
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int nextPrice = iterator.next();
                count++;
                if (currentPrice > nextPrice) {
                    break;
                }
            }
            answer[idx++] = count;
        }
        return answer;
    }
}
