package algorithm.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        // 1. priorities를 돌면서 (위치, 중요도) 객체 queue로 만든다.
        Queue<Print> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Print(i, priorities[i]));
        }
        // 2. 인쇄 작업 수행, 인쇄 되는 객체 ansList에 넣는다.
        int order = 0;
        while (!queue.isEmpty()) {
            Print peek = queue.poll();
            int maxPriority = queue.stream()
                    .map(print -> print.priority)
                    .reduce(Integer::max)
                    .orElse(0);
            if (peek.priority >= maxPriority) {
                order++;
                if (peek.location == location) {
                    return order;
                }
                continue;
            }
            queue.add(peek);
        }
        return order;
    }

    private class Print {
        private final int location;
        private final int priority;

        public Print(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
