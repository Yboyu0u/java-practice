package algorithm.lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 주차_요금_계산 {
    private static final String OUT = "OUT";

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        new 주차_요금_계산().solution(fees, records);
    }

    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> infoMap = new HashMap<>();
        Map<Integer, Integer> timeMap = new TreeMap<>();
        for (String record : records) {
            String[] strRecord = record.split(" ");
            String time = strRecord[0];
            int carNumber = Integer.parseInt(strRecord[1]);
            String inOrOut = strRecord[2];
            int minutes = (Integer.parseInt(time.substring(0, 2)) * 60) + (Integer.parseInt(time.substring(3)));
            if (inOrOut.equals(OUT) && infoMap.containsKey(carNumber)) {
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + minutes - infoMap.get(carNumber));
                infoMap.remove(carNumber);
                continue;
            }

            infoMap.put(carNumber, minutes);
        }
        int endTime = 23 * 60 + 59;
        for (int carNumber : infoMap.keySet()) {
            int totalTime = endTime - infoMap.get(carNumber);
            timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + totalTime);
        }
        int[] answer = new int[timeMap.size()];
        int idx = 0;
        int baseFee = fees[1];
        int unitTime = fees[2];
        int baseTime = fees[0];
        for (int totalTime : timeMap.values()) {
            if (totalTime <= baseTime) {
                answer[idx++] = baseFee;
                continue;
            }

            int calculatedFee = (totalTime - baseTime) / unitTime;
            if (((totalTime - baseTime) % unitTime) != 0) {
                calculatedFee++;
            }
            int totalFee = baseFee + calculatedFee * fees[3];
            answer[idx++] = totalFee;
        }
        return answer;
    }
}
