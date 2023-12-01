import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Initially, all the bulbs are turned off. At moment K (for K from 0 to N−1), we turn on the A[K]-th bulb. A bulb shines if it is on and all the previous bulbs are turned on too.
1. Given A=[2, 1, 3, 5, 4], the function should return 3.
At the 0th moment only the 2nd bulb is turned on, but it does not shine because the previous one is not on.
At the 1st moment two bulbs are turned on (1st and 2nd) and both of them shine.
At the 2nd moment three bulbs are turned on (1st, 2nd and 3rd) and all of them shine.
At the 3rd moment four bulbs are turned on (1st, 2nd, 3rd and 5th), but the 5th bulb does not shine because the previous one is not turned on.
At the 4th moment five bulbs are turned on (1st, 2nd, 3rd, 4th and 5th) and all five of them shine.
 */

public class CanAllBulbStart {

    public int solution(int[] A) {

        int output = 0;

        Map<Integer, Boolean> bulbStatusMap = new HashMap<>();
        PriorityQueue offBulbMinPriorityQueue = new PriorityQueue();

        //first update the bulbstatusMap for each buld as off
        for (int bulbNumber : A) {
            bulbStatusMap.put(bulbNumber, false);
        }

        for (int bulbNumber : A) {


            int previousBulb = bulbNumber - 1;

            //check if prev build is On, mean this build can be turned on too
            if (previousBulb == 0 ||
                    (bulbStatusMap.containsKey(previousBulb) && bulbStatusMap.get(previousBulb))) {

                bulbStatusMap.put(bulbNumber, true);
                boolean ifNextBuldIsTurnedOn = false;
                int nextBulbNumber = bulbNumber;

                //if this build is turned on, update the bulb status of all previous builds which are off and now can be turned on, till priroty queue is not empty or bulb cannot be started
                do {

                    //if PriorityQueue is empty, means all bulb are turned on and we will increase the output
                    if (offBulbMinPriorityQueue.isEmpty()) {
                        output++;
                        break;
                    }
                    Integer bulbCanBeTurnedOn = (Integer) offBulbMinPriorityQueue.peek();
                    if (bulbCanBeTurnedOn == nextBulbNumber + 1) {

                        bulbStatusMap.put(bulbCanBeTurnedOn, true);
                        offBulbMinPriorityQueue.poll();
                        ifNextBuldIsTurnedOn = true;
                        nextBulbNumber = bulbCanBeTurnedOn;

                    } else {
                        ifNextBuldIsTurnedOn = false;
                    }
                } while (ifNextBuldIsTurnedOn);
            } else {
                offBulbMinPriorityQueue.offer(bulbNumber);
            }

        }

        return output;
    }

}

