package algorithm.lv2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 귤_고르기 {

    public int solution(int k, int[] tangerine) {
        // 1. (크기, 개수) map에 담기
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 2. values 내림차순 정렬하고 반복문 돌며 최솟값 찾기
        List<Integer> collect = map.values().stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        int total = 0;
        int answer = 0;
        for (int i : collect) {
            total += i;
            answer++;
            if (total >= k) {
                return answer;
            }
        }
        return answer;
    }
}
