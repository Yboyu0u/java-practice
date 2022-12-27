package algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 베스트_앨범 {
    public int[] solution(String[] genres, int[] plays) {
        // 1. map에 장르와 노래들을 넣는다.
        Map<String, List<Music>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.get(genres[i]).add(new Music(genres[i], i, plays[i]));
                continue;
            }
            map.put(genres[i], new ArrayList<>(Arrays.asList(new Music(genres[i], i, plays[i]))));
        }

        // 2. Music의 횟수 sum 순으로 오름차순 정렬
        List<List<Music>> musics = map.values().stream()
                .sorted((a, b) ->
                        b.stream().mapToInt(i -> i.count).reduce(Integer::sum).orElse(0)
                                - a.stream().mapToInt(i -> i.count).reduce(Integer::sum).orElse(0))
                .collect(Collectors.toList());

        // 3. 최대 2개 까지만 베스트 엘범에 넣는다.
        // Music을 재생 횟수순으로 오름 차순 정렬 + 재생 횟수가 같으면 고유 번호 순으로 내림 차순
        List<Integer> answer = new ArrayList<>();
        for (List<Music> musicsForGenre : musics) {
            Collections.sort(musicsForGenre);
            for (int i = 0; i < musicsForGenre.size(); i++) {
                answer.add(musicsForGenre.get(i).seq);
                if (i == 1) {
                    break;
                }
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private class Music implements Comparable<Music> {

        private final String genre;
        private final int seq;
        private final int count;

        public Music(String genre, int seq, int count) {
            this.genre = genre;
            this.seq = seq;
            this.count = count;
        }

        @Override
        public int compareTo(Music o) {
            if (o.count == this.count) {
                return this.seq - o.seq;
            }
            return o.count - this.count;
        }
    }
}
