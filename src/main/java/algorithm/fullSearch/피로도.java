package algorithm.fullSearch;

public class 피로도 {
    private static boolean[] check;
    private static int max = 0;

    public static void main(String[] args) {
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int k = 80;
        System.out.println("result" + new 피로도().solution(k, dungeons));
    }
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        explore(k, 0, dungeons);
        return max;
    }

    private void explore(int k, int count, int[][] dungeons) {
        if(count > dungeons.length) {
            return;
        }
        max = Integer.max(count, max);
        if(count == dungeons.length) {
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            int requiredK = dungeons[i][0];
            int damagedK = dungeons[i][1];
            if(!check[i] && k >= requiredK) {
                check[i] = true;
                explore(k - damagedK, count + 1, dungeons);
                check[i] = false;
            }
        }
    }
}
