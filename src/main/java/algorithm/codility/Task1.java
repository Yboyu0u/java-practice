package algorithm.codility;

public class Task1 {

    public static void main(String[] args) {
        int x = 6;
        int y = 42;
        int[] a = {6, 42, 6, 7, 1, 42, 42};
        System.out.println(new Task1().solution(6, 42, a));
    }

    int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X) {
                nX += 1;
            }
            if (A[i] == Y) {
                nY += 1;
            }
            if (nX == nY) {
                result = i;
            }
        }
        return result;
    }
}
