package algorithm.stackQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터_re {
    public int solution(int[] priorities, int location) {
        Queue<Print> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Print(i, priorities[i]));
        }

        int order = 0;
        while (!queue.isEmpty()) {
            Print current = queue.poll();

            Iterator<Print> iterator = queue.iterator();
            boolean check = true;
            while (iterator.hasNext()) {
                Print next = iterator.next();
                if (next.priority > current.priority) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                queue.add(current);
                continue;
            }
            order++;
            if (current.location == location) {
                return order;
            }
        }
        return order;
    }

    private class Print {
        private int location;
        private int priority;

        public Print(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
