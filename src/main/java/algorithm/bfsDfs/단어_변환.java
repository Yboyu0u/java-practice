package algorithm.bfsDfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        new 단어_변환().solution(begin, target, words);
    }

    public int solution(String begin, String target, String[] words) {
        // 최소 단계의 과정을 거쳐 begin을 target으로 변환할 수 있느지 return
        /*
            1. 한 번에 한 개의 알파벳만 바꿀 수 있다.
            2. words에 있는 단어로만 변환할 수 있다.
         */
        int[] check = new int[words.length + 1];
        Arrays.fill(check, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1);
        while (!queue.isEmpty()) {
            int currentIdx = queue.poll();
            int count = 0;
            String currentWord = begin;
            if (currentIdx != -1) {
                currentWord = words[currentIdx];
                count = check[currentIdx];
            }

            for (int i = 0; i < words.length; i++) {
                if (isEqualToExceptOne(words[i], currentWord) && check[i] == 0) {
                    if (words[i].equals(target)) {
                        return count + 1;
                    }
                    check[i] += count + 1;
                    queue.add(i);
                }
            }
        }
        return 0;
    }

    private boolean isEqualToExceptOne(String word, String currentWord) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != currentWord.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
