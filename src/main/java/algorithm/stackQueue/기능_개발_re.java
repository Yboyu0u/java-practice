package algorithm.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능_개발_re {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int completeDay = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) {
                completeDay++;
            }

            if (!queue.isEmpty() && queue.peek() < completeDay) {
                answer.add(queue.size());
                queue.clear();
            }
            queue.add(completeDay);
        }
        answer.add(queue.size());

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
