package algorithm.stackQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_re {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTruckWeights = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            waitingTruckWeights.add(truckWeight);
        }

        int time = 1;
        Queue<Truck> crossingTrucks = new LinkedList<>();
        if (!waitingTruckWeights.isEmpty()) {
            crossingTrucks.add(new Truck(waitingTruckWeights.poll(), bridge_length));
            while (!crossingTrucks.isEmpty()) {
                // 다리를 건너는 모든 트럭의 카운트를 -1한다.
                // -1했을 때 count가 0이면 queue에서 뺀다.
                Iterator<Truck> iterator = crossingTrucks.iterator();
                while(iterator.hasNext()) {
                    Truck truck = iterator.next();
                    truck.minusCount();
                    if(truck.count == 0) {
                        iterator.remove();
                    }
                }

                time++;

                // 다리의 무게 - 다리를 건너는 트럭들의 총 무게 <= 다음 트럭 무게면 트럭을 다리에 올린다.
                int totalWeight = crossingTrucks.stream()
                        .mapToInt(i -> i.weight)
                        .reduce(Integer::sum)
                        .orElse(0);
                if (!waitingTruckWeights.isEmpty() && weight - totalWeight >= waitingTruckWeights.peek()) {
                    crossingTrucks.add(new Truck(waitingTruckWeights.poll(), bridge_length));
                }
            }
        }
        return time;
    }

    class Truck {
        int weight;
        int count;

        public Truck(int weight, int count) {
            this.weight = weight;
            this.count = count;
        }

        public void minusCount() {
            count--;
        }
    }
}
