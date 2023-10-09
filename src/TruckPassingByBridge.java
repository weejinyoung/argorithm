
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TruckPassingByBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0;

        List<Integer> truckList = new ArrayList<>();

        for (int truck: truck_weights) {
            truckList.add(truck);
        }

        Queue<Integer> bridgeQueue = new LinkedList<>();
        Queue<Integer> truckReadyQueue = new LinkedList<>(truckList);
        Queue<Integer> truckEndQueue = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.add(0);
        }

        while (truckEndQueue.size() != truck_weights.length) {
            int polledThing = bridgeQueue.poll();
            if (polledThing > 0) {
                currentWeight = currentWeight - polledThing;
                truckEndQueue.add(polledThing);
            }
            if (truckReadyQueue.peek() <= (weight - currentWeight)) {
                int truck = truckReadyQueue.poll();
                truckReadyQueue.add(0);
                bridgeQueue.add(truck);
                currentWeight += truck;
            } else {
                bridgeQueue.add(0);
            }
            time++;
        }

        return time;

    }
}
