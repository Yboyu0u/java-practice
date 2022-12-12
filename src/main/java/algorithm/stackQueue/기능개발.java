package algorithm.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {85, 88, 87};
        int[] speeds = {1, 1, 1};
        final int[] solution = new 기능개발().solution(progresses, speeds);

        Arrays.stream(solution).boxed()
                .forEach(System.out::println);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 작업들의 작업 일자를 구한다.
        final ArrayList<Integer> completeDays = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = (100 - progress) / speed;
            if ((100 - progress) % speed != 0) {
                day++;
            }
            completeDays.add(day);
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        //2. stack 에 넣는다. 넣을 때 숫자가 peek 보다 크면 stack 사이즈를 List에 넣는다.
        for (int day : completeDays) {
            // 3. stack에서 가장 큰 값 구하기
            if (!stack.isEmpty()) {
                int max = stack.stream()
                        .reduce(Integer::max)
                        .get();
                if (day > max) {
                    answer.add(stack.size());
                    stack.clear();
                }

            }
            stack.add(day);
        }
        answer.add(stack.size());
        stack.clear();

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
