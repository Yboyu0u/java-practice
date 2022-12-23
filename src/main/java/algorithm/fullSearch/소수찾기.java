package algorithm.fullSearch;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    private static boolean[] check;
    private static Set<Integer> set = new HashSet<>();
    private static int count = 0;

    public int solution(String numbers) {
        // numbers: 각 종이 조각에 적힌 숫자가 적힌 문자열
        // 종이 조각으로 만들 수 있는 소수가 몇 개인지 return
        check = new boolean[numbers.length()];
        search("", numbers);
        return count;
    }

    private void search(String s, String numbers) {
        if (!s.equals("")) {
            int n = Integer.parseInt(s);
            if (!set.contains(n) && isPrime(n)) {
                set.add(n);
                count++;
            }
        }
        if (s.length() == numbers.length()) {
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                search(s + numbers.charAt(i), numbers);
                check[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number == 1 || number == 0) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
