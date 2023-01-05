package algorithm.bfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환_re {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(0, begin));
        while (!queue.isEmpty()) {
            Word current = queue.poll();
            int curCount = current.count;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isAddable(words[i], current.value)) {
                    if (words[i].equals(target)) {
                        return curCount + 1;
                    }
                    queue.add(new Word(curCount + 1, words[i]));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

    private static class Word {
        private int count;
        private String value;

        public Word(int count, String value) {
            this.count = count;
            this.value = value;
        }
    }

    private boolean isAddable(String next, String current) {
        int count = 0;
        for (int j = 0; j < next.length(); j++) {
            if (next.charAt(j) != current.charAt(j)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
