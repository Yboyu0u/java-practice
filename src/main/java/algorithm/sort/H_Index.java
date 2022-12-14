package algorithm.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {10, 10, 10, 10, 10};
        System.out.println(new H_Index().solution(citations) + "ans");
    }

    public int solution(int[] citations) {
        List<Integer> citationsList = Arrays.stream(citations)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int answer = 0;
        int h = 0;
        while (h <= citationsList.get(citationsList.size() - 1)) {
            int finalH = h;
            long count = citationsList.stream()
                    .filter(citation -> citation >= finalH)
                    .count();
            if (count >= h) {
                answer = Integer.max(h, answer);
            }
            h++;
        }
        return answer;
    }
}
