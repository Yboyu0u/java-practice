package algorithm.fullSearch;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기_re {

    public int solution(int n, int[][] wires) {
        // 1. 그래프를 표현하는 n+1 2차원 배열을 만들고 관계를 구성한다. 
        int[][] graph = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        // 2. 반복문을 돌며 연결관계에 있는 망을 하나 끊고 bfs()를 통해 연결된 전력망 개수를 구한다.
        boolean[][] check = new boolean[n + 1][n + 1];
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!check[i][j] && graph[i][j] == 1) {
                    check[i][j] = true;
                    check[j][i] = true;
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                    int count = bfs(graph, j, n);
                    answer = Math.min(Math.abs((n - count) - count), answer);
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        return answer;
    }

    private int bfs(int[][] graph, int number, int n) {
        boolean[][] check = new boolean[n + 1][n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int current = queue.poll();
            for (int i = 1; i < n + 1; i++) {
                if (graph[current][i] == 1 && !check[current][i]) {
                    check[current][i] = true;
                    check[i][current] = true;
                    queue.add(i);
                }
            }
        }
        return count;
    }
}
