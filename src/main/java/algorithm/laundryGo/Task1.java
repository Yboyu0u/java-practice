package algorithm.laundryGo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        new Task1().solution("ervervige");
    }

    public int solution(String S) {
        // 1. map(문자, count)로 만든다.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        // 2. count가 2로 나누어 떨어지지 않는 것들을 골라낸다.
        List<Integer> counts = map.values().stream()
                .filter(count -> count % 2 != 0)
                .collect(Collectors.toList());
        // 3. 1인 것이 여러 개면 하나 빼고 다 지운다.
        // 나머지는 answer += count - 1한다.
        int answer = 0;
        boolean isOne = false;
        for (int count : counts) {
            if (!isOne && count == 1) {
                isOne = true;
                continue;
            }
            answer++;
        }
        return answer;
    }
}
