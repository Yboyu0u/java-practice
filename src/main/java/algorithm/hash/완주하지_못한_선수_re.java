package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수_re {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String par : participant) {
            map.put(par, map.getOrDefault(par, 0) + 1);
        }
        for (String com : completion) {
            map.put(com, map.getOrDefault(com, 0) - 1);
        }
        for (String answer : map.keySet()) {
            if (map.get(answer) > 0) {
                return answer;
            }
        }
        return "";
    }
}
