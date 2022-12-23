package algorithm.codility;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int preIdx = i;
            int nextIdx = i + 1;
            if (i == A.length - 1) {
                nextIdx = 0;
            }
            calculateSumIsEven(A, preIdx, nextIdx);
        }
        return map.size();
    }

    private void calculateSumIsEven(int[] A, int preIdx, int nextIdx) {
        if ((A[preIdx] + A[nextIdx]) % 2 == 0 && isAddableInMap(preIdx, nextIdx)) {
            map.put(preIdx, nextIdx);
        }
    }

    private boolean isAddableInMap(int preIdx, int nextIdx) {
        if (nextIdx == 0 && map.containsKey(0)) {
            return false;
        }
        if (preIdx > 0 && map.containsKey(preIdx - 1)) {
            return false;
        }
        return true;
    }
}
