package algorithm.sort;

import java.util.Arrays;

public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(new 가장_큰_수().solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer =  Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .reduce("", (total, n) -> total + n);

        if(answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}
