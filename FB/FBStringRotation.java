package FB;

/*
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.

input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678

 String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);
 */

class Main {


    String rotationalCipher(String input, int rotationFactor) {


        int remainderForCharacter = rotationFactor % 26;
        int remainderForDigit = rotationFactor % 10;
        StringBuilder output = new StringBuilder("");

        int aValue = Integer.valueOf('a');
        int zValue = Integer.valueOf('z');

        int capAValue = Integer.valueOf('A');
        int capZValue = Integer.valueOf('Z');

        int zeroVal = Integer.valueOf('0');
        int nineVal = Integer.valueOf('9');

        for (char val : input.toCharArray()) {

            int intVal = Integer.valueOf(val);

            if (intVal >= aValue && intVal <= zValue) {

                int itsPositionInAlphabet = intVal - aValue;

                int nextAlphabetValue = (itsPositionInAlphabet + remainderForCharacter) % 26;

                char nextVal = (char) (aValue + nextAlphabetValue);
                output.append(nextVal);
            } else if (intVal >= capAValue && intVal <= capZValue) {

                int itsPositionInAlphabet = intVal - capAValue;

                int nextAlphabetValue = (itsPositionInAlphabet + remainderForCharacter) % 26;

                char nextVal = (char) (capAValue + nextAlphabetValue);
                output.append(nextVal);
            } else if (intVal >= zeroVal && intVal <= nineVal) {

                int itsPositionInAlphabet = intVal - zeroVal;

                int nextAlphabetValue = (itsPositionInAlphabet + remainderForDigit) % 10;

                char nextVal = (char) (zeroVal + nextAlphabetValue);
                output.append(nextVal);
            } else {

                output.append(val);
            }
        }

        return output.toString();

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}