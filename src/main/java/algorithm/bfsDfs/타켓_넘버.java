package algorithm.bfsDfs;

public class 타켓_넘버 {
    private static int answer = 0;

    public int solution(int[] numbers, int target) {
        search(numbers, target, 0, 0);
        return answer;
    }

    private void search(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        search(numbers, target, idx + 1, sum + numbers[idx]);
        search(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
