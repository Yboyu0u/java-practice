package algorithm.lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크_자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 3, 1, 4};
        new 롤케이크_자르기().solution(topping);
    }

    public int solution(int[] topping) {
        // 1. (종류, 개수) map 에 추가
        // 2. 반복문을 돌며 set에 topping 하나 추가하고 map에서는 제거
        // value가 0이되면 제거
        // set의 개수와 map의 개수가 같아지면 count ++
        Map<Integer, Integer> brothers = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            brothers.put(topping[i], brothers.getOrDefault(topping[i], 0) + 1);
        }
        int count = 0;
        Set<Object> my = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            int type = topping[i];
            my.add(type);

            if (brothers.get(type) == 1) {
                brothers.remove(type);
            } else {
                brothers.put(type, brothers.get(type) - 1);
            }
            if (my.size() == brothers.size()) {
                count++;
            }
        }
        return count;
    }
}
