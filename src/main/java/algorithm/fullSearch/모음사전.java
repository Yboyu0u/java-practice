package algorithm.fullSearch;

public class 모음사전 {
    private static final String[] wordings = {"A", "E", "I", "O", "U"};
    private static int count = 0;
    private static int answer = 0;

    public static void main(String[] args) {
        new 모음사전().solution("AAAE");
    }

    public int solution(String word) {
        // word가 몇 번째 단어인지 return
        find(word, "");
        return answer;
    }

    private void find(String word, String temp) {
        if (temp.equals(word)) {
            answer = count;
            return;
        }
        if (temp.length() >= wordings.length) {
            return;
        }
        for (int i = 0; i < wordings.length; i++) {
            count ++;
            find(word, temp + wordings[i]);
        }
    }
}
