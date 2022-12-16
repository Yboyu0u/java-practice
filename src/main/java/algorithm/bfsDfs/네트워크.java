package algorithm.bfsDfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new 네트워크().solution(n, computers));
    }
    private static int[][] check;

    public int solution(int n, int[][] computers) {
        check = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], -1);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 1 && check[i][i] == -1) {
                bfs(n, computers, i);
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int n, int[][] computers, int start) {
        Queue<Integer> queue = new LinkedList<>();
        check[start][start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int y = queue.poll();

            for (int i = 0; i < n; i++) {
                if(computers[y][i] == 1 && check[y][i] == -1) {
                    check[y][i] = 0;
                    check[i][y] = 0;
                    queue.add(i);
                }
            }
        }
    }
}
