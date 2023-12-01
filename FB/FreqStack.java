package FB;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/maximum-frequency-stack/ 
public class FreqStack {

    Map<Integer,Integer> valFrequency ;
    Map<Integer, Stack<Integer>> freqWiseStack;
    int maxFrequency = 0;

    public FreqStack() {
        valFrequency = new HashMap<>();
        freqWiseStack = new HashMap<>();
    }

    public void push(int val) {

        int newFreq = valFrequency.getOrDefault(val, 0) + 1;
        if(newFreq > maxFrequency) {
            maxFrequency = newFreq;
        }
        valFrequency.put(val, newFreq);

        Stack<Integer> valStack;
        if(freqWiseStack.containsKey(newFreq)) {
          valStack = freqWiseStack.get(newFreq);
        }  else {
            valStack = new Stack<>();
            freqWiseStack.put(newFreq, valStack);
        }
        valStack.push(val);
    }

    public int pop() {

        Stack<Integer> stack = freqWiseStack.get(maxFrequency);
        int valRemoved = stack.pop();
        valFrequency.put(valRemoved, valFrequency.get(valRemoved)-1);
        if(stack.isEmpty()) {
            maxFrequency--;
        }
        return valRemoved;
    }


    public static void main(String args[]) {

        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);

        int param_2 = obj.pop();

    }
}
