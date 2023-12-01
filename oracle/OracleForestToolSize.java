package oracle;/*

find the max tool size to cut the tree, so that the tree remaining we get sum up to the required wood

ex: if toolHeight = 5 and treeHeight = 8 , then after cutting the tree, we will get 3 wood
 */

public class OracleForestToolSize {

    public static void main(String args[]) {
        int forestTreeHeight[] = {20, 15, 10, 16};
        int woodRequried = 7;
        int maxToolSize = searchToolSize(forestTreeHeight, 0, 20, 7, 0);
        System.out.println(maxToolSize);
    }


    private static int searchToolSize(int[] forestArray, int startToolRange, int endToolRange, int woodRequired, int toolSizeWoodCollected) {

        if(startToolRange > endToolRange) {
            return -1;
        }
        int midToolSize = (startToolRange + endToolRange) / 2;

        int amountWoodCollected = getWoodCollectedFromGivenToolSize(forestArray, midToolSize);

        if (amountWoodCollected == woodRequired) {
            return midToolSize;
        }

        int toolSizeFound = -1;
        if (amountWoodCollected > woodRequired) {
            toolSizeWoodCollected = midToolSize;
            toolSizeFound =  searchToolSize(forestArray, midToolSize + 1, endToolRange, woodRequired, toolSizeWoodCollected);
        } else {
            toolSizeFound =  searchToolSize(forestArray, startToolRange, midToolSize - 1, woodRequired, toolSizeWoodCollected);
        }

        if(toolSizeFound == -1) {
            return toolSizeWoodCollected;
        }

        return toolSizeFound;
    }

    private static int getWoodCollectedFromGivenToolSize(int[] forestArray, int toolSize) {
        int woodCollected = 0;
        for(int treeHeight : forestArray) {
            woodCollected+= (treeHeight-toolSize) >=0 ? treeHeight-toolSize : 0;
        }

        return woodCollected;
    }
}
