package algorithm.bfsDfs;

public class 타겟_넘버_re {
    private static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        new 타겟_넘버_re().solution(numbers, target);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int current, int index) {
        if (index >= numbers.length) {
            if (current == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, current + numbers[index], index + 1);
        dfs(numbers, target, current - numbers[index], index + 1);
    }
}
