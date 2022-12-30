package algorithm.laundryGo;

public class Task3 {
    public static void main(String[] args) {
        String S = "bytdag";
        int[] A = {4, 3, 0, 1, 2, 5};
        new Task3().solution(S, A);
    }

    public String solution(String S, int[] A) {
        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append(S.charAt(0));
        int order = A[0];
        while (order > 0) {
            answerBuilder.append(S.charAt(order));
            order = A[order];
        }
        return answerBuilder.toString();
    }
}
