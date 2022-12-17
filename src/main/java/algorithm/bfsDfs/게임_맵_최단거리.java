package algorithm.bfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] check = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        check[0][0] = true;
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int y = point[0];
            int x = point[1];
            int count = point[2];

            for (int[] direction : directions) {
                int nextY = y + direction[0];
                int nextX = x + direction[1];

                if(nextY == n-1 && nextX == m-1) {
                    return count + 1;
                }

                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                    if (maps[nextY][nextX] == 1 && !check[nextY][nextX]) {
                        check[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}
