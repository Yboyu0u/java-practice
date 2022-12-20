package algorithm.lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> userMap = new LinkedHashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (String id : id_list) {
            userMap.put(id, new HashSet<>());
        }
        for (String rep : report) {
            String[] split = rep.split(" ");
            String a = split[0];
            String b = split[1];

            if (!userMap.get(a).contains(b)) {
                countMap.put(b, countMap.getOrDefault(b, 0) + 1);
            }
            userMap.get(a).add(b);
        }
        int[] answer = new int[id_list.length];
        int idx = 0;
        for (Set value : userMap.values()) {
            answer[idx++] = (int) value.stream()
                    .filter(id -> countMap.containsKey(id) && countMap.get(id) >= k)
                    .count();
        }
        return answer;
    }
}
