package microsoft;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/push-dominoes/
public class PushDominos {

    private static char STANDING = '.';
    private static char PUSHED_LEFT = 'L';
    private static char PUSHED_RIGHT = 'R';

    class Direction {
        char pushDirection;
        int index;
    }

    public String pushDominoes(String dominoes) {
        char[] outputArr = new char[dominoes.length()];

        //all are standing initially
        for (int i = 0; i < outputArr.length; i++) {
            outputArr[i] = STANDING;
        }

        List<Direction> pushList = new ArrayList<>();
        //keeping the list of push direction with index at which push has made
        int index = 0;
        for (char dominoStatus : dominoes.toCharArray()) {
            if (dominoStatus == STANDING) {
                index++;
                continue;
            }
            Direction pushDir = new Direction();
            pushDir.pushDirection = dominoStatus;
            pushDir.index = index;
            pushList.add(pushDir);
            index++;
        }

        for (int i = 0; i < pushList.size(); i++) {

            if (pushList.get(i).pushDirection == PUSHED_LEFT) {
                pushLeft(outputArr, pushList.get(i).index);
            }
            else if (pushList.get(i).pushDirection == PUSHED_RIGHT) {

                if (i == (pushList.size() - 1)) {
                    pushRigh(outputArr, pushList.get(i).index, outputArr.length);
                }
                else if (pushList.get(i + 1).pushDirection == PUSHED_RIGHT) {
                    pushRigh(outputArr, pushList.get(i).index, pushList.get(i + 1).index);
                }
                else if (pushList.get(i + 1).pushDirection == PUSHED_LEFT) {
                    pushLeftRight(outputArr, pushList.get(i).index, pushList.get(i + 1).index);
                    i = i + 1;
                }
            }
        }

        StringBuilder output = new StringBuilder("");
        for (char finalState : outputArr) {
            output.append(finalState);
        }

        return output.toString();
    }

    private void pushLeft(char[] outputArr, int pushLeftIndex) {
        for (int i = pushLeftIndex; i >= 0 && outputArr[i] == STANDING; i--) {
            outputArr[i] = PUSHED_LEFT;
        }
    }

    private void pushRigh(char[] outputArr, int pushRightIndex, int pushRightTillIndex) {
        for (int i = pushRightIndex; i < pushRightTillIndex; i++) {
            outputArr[i] = PUSHED_RIGHT;
        }
    }

    private void pushLeftRight(char[] outputArr, int pushRightIndex, int pushLeftIndex) {

        int rightIndex = pushRightIndex;
        int leftIndex = pushLeftIndex;
        while (rightIndex < leftIndex) {
            outputArr[rightIndex] = PUSHED_RIGHT;
            outputArr[leftIndex] = PUSHED_LEFT;
            rightIndex++;
            leftIndex--;
        }
    }

    public static void main(String args[]) {

        String dominoes1 = "RR.L";
        String dominoes2 = ".L.R...LR..L..";
        PushDominos obj = new PushDominos();
        System.out.println(obj.pushDominoes(dominoes2));

    }
}