package algorithm.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    private static boolean[][] check;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        // (1,1)에서 시작해서 (n,m)으로 이동할 수 있는 최소 칸 수를 구하라
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] miro = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                miro[i][j] = Integer.parseInt(String.valueOf(s.charAt(j - 1)));
            }
        }
        System.out.println(bfs(new int[]{n, m}, n + 1, m + 1, miro));
    }

    private static int bfs(int[] des, int yLength, int xLength, int[][] miro) {
        Queue<int[]> queue = new LinkedList<>();
        check[1][1] = true;
        queue.add(new int[]{1, 1, 1});
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int y = point[0];
            int x = point[1];
            int count = point[2];

            for (int[] direction : directions) {
                int nextY = y + direction[0];
                int nextX = x + direction[1];

                if (nextY == yLength - 1 && nextX == xLength - 1) {
                    return count + 1;
                }

                if (nextY > 0 && nextY < yLength && nextX > 0 && nextX < xLength) {
                    if (miro[nextY][nextX] == 1 && !check[nextY][nextX]) {
                        check[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX, count + 1});
                    }
                }
            }
            answer = count;
        }
        return answer;
    }
}
