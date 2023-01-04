package algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class K_번째수_re {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int o = 0; o < commands.length; o++) {
            int i = commands[o][0];
            int j = commands[o][1];
            int k = commands[o][2];

            answer[o] = Arrays.stream(array)
                    .boxed()
                    .skip(i - 1)
                    .limit(j + 1 - i)
                    .sorted()
                    .collect(Collectors.toList())
                    .get(k - 1);
        }
        return answer;
    }
}
