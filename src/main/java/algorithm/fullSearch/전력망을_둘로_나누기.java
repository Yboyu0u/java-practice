package algorithm.fullSearch;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        new 전력망을_둘로_나누기().solution(n, wires);
    }

    public int solution(int n, int[][] wires) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            int y = wire[0];
            int x = wire[1];
            graph[y][x] = 1;
            graph[x][y] = 1;
        }

        int answer = Integer.MAX_VALUE;
        boolean[][] check = new boolean[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == 1 && (!check[i][j] || !check[j][i])) {
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                    check[i][j] = true;
                    check[j][i] = true;

                    int part1 = bfs(graph, n + 1, i);
                    int part2 = n - part1;
                    answer = Math.min(Math.abs(part1 - part2), answer);

                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        return answer;
    }

    private int bfs(int[][] graph, int n, int start) {
        boolean[] check = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        queue.add(start);
        int count = 1;

        while (!queue.isEmpty()) {
            int point = queue.poll();
            for (int i = 1; i < n; i++) {
                if (graph[point][i] == 1 && !check[i]) {
                    check[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        return count;
    }
}
