/*

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

---
Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5
---

Note:
You may assume that the given expression is always valid.

Do not use the eval built-in library function.


3+2*2

3*2+2


6 2     +

8
STACK:  

3 4+

7

3+5-2/2

351    -  + 
34   +
7
*/

import java.util.Stack;

public class PayPayCalculator {
    public static void main(String[] args) {


        String input = " 3/2 ";

        int output = computeValue(input);
        System.out.println(output);

    }

    private static int computeValue(String expression) {


        //define the stack
        Stack<Character> digitStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (char value : expression.toCharArray()) {


            //if its space coming, we dont have to do anything
            if (value == ' ') {
                continue;
            }


            if (value >= '0' && value <= '9') {


                //check the opertorStack and if opertorstack top value is * or / (high priority)
                //take the top value from digitStack compute and insert back the computed value

                if(operatorStack.isEmpty()) {
                    digitStack.push(value);
                }
                else {
                    char operator = operatorStack.peek();
                    if (operator == '*' || operator == '/') {

                        operator = operatorStack.pop();
                        int digit = digitStack.pop() - '0';

                        int newVaule = operator == '*' ? (value - '0') * digit : digit/ (value - '0') ;
                        digitStack.push(Character.forDigit(newVaule,10));


                    } else {
                        digitStack.push(value);
                    }
                }

            } else {

                //its a operator, simply insert it
                operatorStack.push(value);
            }

        }

        if (!operatorStack.isEmpty()) {

            char operator = operatorStack.pop();
            int digit1 = digitStack.pop() - '0';
            int digit2 = digitStack.pop() - '0';

            int newValue = operator == '+' ? (digit2) + digit1 : (digit2) - digit1;
            digitStack.push(Character.forDigit(newValue,10));

        }


        return digitStack.pop()-'0';
    }


}