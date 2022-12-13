package algorithm.stackQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(new 다리를_지나는_트럭().solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitingTrucks = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            waitingTrucks.add(new Truck(truckWeight, bridge_length));
        }

        int answer = 1;
        Queue<Truck> crossingTrucks = new LinkedList<>();
        crossingTrucks.add(waitingTrucks.poll());
        while (!crossingTrucks.isEmpty()) {
            Iterator<Truck> iter = crossingTrucks.iterator();
            while (iter.hasNext()) {
                Truck crossingTruck = iter.next();
                crossingTruck.time--;
                if (crossingTruck.time == 0) {
                    iter.remove();
                }
            }
            answer++;

            int currentWeight = crossingTrucks.stream()
                    .map(truck -> truck.weight)
                    .reduce(Integer::sum)
                    .orElse(0);
            if (!waitingTrucks.isEmpty()) {
                Truck nextTruck = waitingTrucks.peek();
                if (currentWeight + nextTruck.weight <= weight) {
                    crossingTrucks.add(nextTruck);
                    waitingTrucks.poll();
                }
            }
        }
        return answer;
    }

    class Truck {
        private int weight;
        private int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}
