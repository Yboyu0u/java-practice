package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {

        // 1. participant 을 Map 으로 만든다.
        // 같은 이름이 있으면 카운팅 +1
        // 2. completion 을 돌며 completion 에 이름이 있으면 value -1
        // 3. participant 의 value 가 0이 아닌 이름을 String 으로 출력한다.

        Map<String, Integer> participantMap = new HashMap<>();
        for (String player : participant) {
            participantMap.put(player, participantMap.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            participantMap.put(player, participantMap.get(player) - 1);
        }

        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) != 0) {
                return key;
            }
        }
        return "";
    }
}
