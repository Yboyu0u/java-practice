package algorithm.laundryGo;

public class Task2 {
    public static void main(String[] args) {
        String[] strings = {"zzzz", "ferz", "zdsr", "fgtd"};
        new Task2().solution(strings);
    }

    public int[] solution(String[] S) {
       int n = S.length;
        int m = S[0].length();
        for (int i = 0; i < n - 1; i++) {
            String first = S[i];
            for (int j = i + 1; j < n; j++) {
                String second = S[j];

                for (int k = 0; k < m; k++) {
                    if (first.charAt(k) == second.charAt(k)) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return new int[0];
    }
}
