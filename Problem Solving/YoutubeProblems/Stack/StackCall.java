package Stack;

import Utility.MethodCall;

public class StackCall implements MethodCall {

    @Override
    public void call() {

        Stacks stack = new Stacks();
        /* ============================================== P: 16 */
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

    }

}
