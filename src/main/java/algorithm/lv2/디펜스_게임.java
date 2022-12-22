package algorithm.lv2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스_게임 {

    private static int answer = 0;

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        new 디펜스_게임().solution(n, k, enemy);
    }

    public int solution(int n, int k, int[] enemy) {
        // n: 준호가 처음 가지고 있는 병사의 수
        // k: 사용 가능한 무적권의 횟수
        // enemy: 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열
        // n-라운드 적의 수 = 남은 병사
        // 무적권: 병사의 소모없이 한 라운드의 공격을 막을 수 있다. 최대 k번 사용 가능
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                    continue;
                }
                return i;
            }
        }

        return answer;
    }
}
