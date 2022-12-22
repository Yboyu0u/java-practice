package algorithm.lv1;

public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int quantity = food[i];
            for (int j = 0; j < quantity / 2; j++) {
                answer.append(i);
            }
        }
        answer.append(0);
        String answerString = answer.toString();
        for (int i = answer.length() - 2; i >= 0; i--) {
            answer.append(answerString.charAt(i));
        }
        return answer.toString();
    }
}
