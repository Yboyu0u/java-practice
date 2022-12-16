package algorithm.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    private static int MAX = 200001;
    private static boolean[] check = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        check[n] = true;
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int sec = point[1];

            for (int nextX : new int[]{x - 1, x + 1, x * 2}) {
                if (nextX >= 0 && nextX < MAX) {
                    if (!check[nextX]) {
                        if (nextX == k) {
                            System.out.println(sec + 1);
                            return;
                        }
                        check[nextX] = true;
                        queue.add(new int[]{nextX, sec + 1});
                    }
                }
            }
        }
        System.out.println(0);
    }
}
