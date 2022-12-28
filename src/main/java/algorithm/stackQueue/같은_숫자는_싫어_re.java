package algorithm.stackQueue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class 같은_숫자는_싫어_re {
    public int[] solution(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int num : arr) {
            if (!deque.isEmpty() && deque.peekLast() == num) {
                continue;
            }
            deque.add(num);
        }

        Iterator<Integer> iterator = deque.iterator();
        int[] answer = new int[deque.size()];
        int idx = 0;
        while(iterator.hasNext()) {
            answer[idx ++] = deque.pollFirst();
        }
        return answer;
    }
}
