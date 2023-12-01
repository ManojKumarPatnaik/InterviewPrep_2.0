package salesforce;

//https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
//https://www.youtube.com/watch?v=nyR8K63F2KY

public class MaxNumberOfAs {

    private static int maxNumberOfA(int N, int[] memoArray) {

        if(N <=6) {

            return N;
        }

        if(memoArray[N] != -1) {
            return memoArray[N];
        }

        for(int i = 7; i<=N; i++) {

            int multiply = 2;

            for(int j= i-3; j>0; j--) {

                memoArray[j] = maxNumberOfA(j, memoArray);

                int val= multiply*memoArray[j];
                if(val > memoArray[i]) {
                    memoArray[i] = val;
                }

                multiply++;
            }
        }

        return memoArray[N];
    }

    public static void main(String args[]) {

        int n =35;
        int[] memoArray = new int[n+1];
        for(int i=0; i<n+1; i++) {
            memoArray[i] = -1;
        }
        System.out.println(maxNumberOfA(n, memoArray));
        System.out.println(findoptimal(n));

    }

    static int findoptimal(int N)
    {
        // The optimal string length is N
        // when N is smaller than 7
        if (N <= 6)
            return N;

        // An array to store result
        // of subproblems
        int screen[] = new int[N];

        int b; // To pick a breakpoint

        // Initializing the optimal lengths
        // array for until 6 input strokes
        int n;
        for (n = 1; n <= 6; n++)
            screen[n - 1] = n;

        // Solve all subproblems in bottom manner
        for (n = 7; n <= N; n++) {
            // Initialize length of optimal
            // string for n keystrokes
            screen[n - 1] = 0;

            // For any keystroke n, we need
            // to loop from n-3 keystrokes
            // back to 1 keystroke to find
            // a breakpoint 'b' after which we
            // will have ctrl-a, ctrl-c and
            // then only ctrl-v all the way.
            for (b = n - 3; b >= 1; b--) {
                // if the breakpoint is
                // at b'th keystroke then
                // the optimal string would
                // have length
                // (n-b-1)*screen[b-1];
                int curr = (n - b - 1) * screen[b - 1];
                if (curr > screen[n - 1])
                    screen[n - 1] = curr;
            }
        }

        return screen[N - 1];
    }
}
