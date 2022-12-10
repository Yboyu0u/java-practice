package algorithm.hash;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 폰켓몬 {
    public int solution(int[] nums) {
        // 같은 종류의 폰켓몬은 같은 번호를 갖는다.
        // N 마리의 폰켓몬 중에서 N/2 마리를 가질 수 있다.
        // 같은 종류의 폰켓몬을 가질 수있는 방법은 한 개
        // nums: N마리 폰켓몬의 종류 번호가 담긴 배열, 짝수
        // N/2 마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법 return

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
}
