package algorithm.fullSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] currentIdx = {0, 0, 0};
        int[] maxIdx = {one.length - 1, two.length - 1, three.length - 1};

        int[] countingAnsArr = {0, 0, 0};
        for (int ans : answers) {
            for (int i = 0; i < currentIdx.length; i++) {
                if (currentIdx[i] > maxIdx[i]) {
                    currentIdx[i] = 0;
                }
            }

            if (one[currentIdx[0]] == ans) {
                countingAnsArr[0]++;
            }
            if (two[currentIdx[1]] == ans) {
                countingAnsArr[1]++;
            }
            if (three[currentIdx[2]] == ans) {
                countingAnsArr[2]++;
            }
            currentIdx[0]++;
            currentIdx[1]++;
            currentIdx[2]++;
        }

        int maxCount = Arrays.stream(countingAnsArr)
                .boxed()
                .reduce(Integer::max)
                .get();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < countingAnsArr.length; i++) {
            if(countingAnsArr[i] == maxCount) {
                answer.add(i+1);
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
