package algorithm.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"};
        new 할인_행사().solution(want, number, discount);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int end= 10 + i;
            if(end >= discount.length) {
                end = discount.length;
            }
            for (String prod : Arrays.copyOfRange(discount, i, end)) {
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }

            boolean isBuyable = true;
            for (int j = 0; j < want.length; j++) {
                if(!isBuyable) {
                    break;
                }
                String w = want[j];
                if (map.containsKey(w) && map.get(w) >= number[j]) {
                    continue;
                }
                isBuyable = false;
            }
            if (isBuyable) {
                answer++;
            }
        }
        return answer;
    }
}
