package algorithm.sort;

import java.util.Arrays;

public class K_번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        new K_번째수().solution(array, commands);
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2] - 1;

            int[] tempArr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(tempArr);
            answer[idx++] = tempArr[k];
        }

        return answer;
    }
}
