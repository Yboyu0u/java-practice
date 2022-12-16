package algorithm.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
    private static boolean[][] check;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int height = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[][] painting = new int[height][length];
        for (int[] xs : painting) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < xs.length; i++) {
                xs[i] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[height][length];
        int max = 0;
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (painting[i][j] == 1 && !check[i][j]) {
                    count++;
                    max = Integer.max(max, bfs(painting, i, j));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(int[][] painting, int y, int x) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        check[y][x] = true;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int cy = point[0];
            int cx = point[1];
            check[cy][cx] = true;

            for (int[] direction : directions) {
                int nextY = cy + direction[0];
                int nextX = cx + direction[1];
                if (nextY >= 0 && nextX >= 0 && nextY < painting.length && nextX < painting[0].length) {
                    if (painting[nextY][nextX] == 1 && !check[nextY][nextX]) {
                        check[nextY][nextX] = true;
                        count++;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
        return count;
    }
}
