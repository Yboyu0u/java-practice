package algorithm.stackQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_rre {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 기다르는 트럭 큐와 다리를 건너는 트럭 큐를 만든다.
        Queue<Integer> watingQueue = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            watingQueue.add(truckWeight);
        }
        Queue<Truck> taskQueue = new LinkedList<>();
        if (!watingQueue.isEmpty()) {
            taskQueue.add(new Truck(bridge_length, watingQueue.poll()));
        }

        // 2. 1초에 트럭은 한대만 올라 갈 수 있다.
        int answer = 1;
        while (!taskQueue.isEmpty()) {
            answer++;

            // queue의 모든 트럭의 life를 감소시킨다.
            Iterator<Truck> iterator = taskQueue.iterator();
            while (iterator.hasNext()) {
                Truck truck = iterator.next();
                truck.decreaseLife();
            }

            //  제일 앞 트럭의 life가 0이면 queue에서 뺀다.
            if (taskQueue.peek().isDone()) {
                taskQueue.poll();
            }

            // queue 트럭의 전체 무게 + 다음 트럭이 <= weight && queue.size() < bridge_length 면 트럭을 다리에 올린다.
            int sum = taskQueue.stream().mapToInt(truck -> truck.weight).sum();
            if ((!watingQueue.isEmpty() && sum + watingQueue.peek() <= weight)
                    && (taskQueue.size() < bridge_length)) {
                taskQueue.add(new Truck(bridge_length, watingQueue.poll()));
            }
        }
        return answer;
    }

    private class Truck {
        private int life;
        private int weight;

        public Truck(int life, int weight) {
            this.life = life;
            this.weight = weight;
        }

        public void decreaseLife() {
            life--;
        }

        public boolean isDone() {
            return life == 0;
        }
    }
}
