package algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장_큰_수_re {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));
        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}
