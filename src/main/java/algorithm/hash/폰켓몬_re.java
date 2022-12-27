package algorithm.hash;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 폰켓몬_re {
    public int solution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
}
