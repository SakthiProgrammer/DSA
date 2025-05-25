package Stack;

import Utility.MethodCall;

public class StackCall implements MethodCall {

    @Override
    public void call() {

        Stacks stack = new Stacks();
        /* ============================================== P: 30 */
        // 1. Valid Parantheses
        /* ============================================== */

        String inpStr = "({})";
        boolean resBool = stack.isValid(inpStr);
        System.out.println("Valid Parantheses: " + resBool);// true

        inpStr = "()[]{}";
        resBool = stack.isValid(inpStr);
        System.out.println("Valid Parantheses: " + resBool);// true

        inpStr = "(]";
        resBool = stack.isValid(inpStr);
        System.out.println("Valid Parantheses: " + resBool);// false

        inpStr = "([])";
        resBool = stack.isValid(inpStr);
        System.out.println("Valid Parantheses: " + resBool);// true

        /* ============================================== P: 31 */
        // 2. Evaluate Reverse Polish Notation
        /* ============================================== */

        String[] tokens1 = { "2", "1", "+", "3", "*" };
        int result1 = stack.evalRPN(tokens1);
        System.out.println("Eval RPN [2 1 + 3 *]: " + result1); // 9

        String[] tokens2 = { "4", "13", "5", "/", "+" };
        int result2 = stack.evalRPN(tokens2);
        System.out.println("Eval RPN [4 13 5 / +]: " + result2); // 6

        String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        int result3 = stack.evalRPN(tokens3);
        System.out.println("Eval RPN [10 6 9 3 + -11 * / * 17 + 5 +]: " + result3); // 22

    }

}
