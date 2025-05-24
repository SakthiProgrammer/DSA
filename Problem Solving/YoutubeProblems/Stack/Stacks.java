package Stack;

import java.util.*;

public class Stacks {

    /*
     * 155. Min Stack
     * Medium
     * Topics
     * Companies
     * Hint
     * Design a stack that supports push, pop, top, and retrieving the minimum
     * element in constant time.
     * 
     * Implement the MinStack class:
     * 
     * MinStack() initializes the stack object.
     * void push(int val) pushes the element val onto the stack.
     * void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack.
     * int getMin() retrieves the minimum element in the stack.
     * You must implement a solution with O(1) time complexity for each function.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * 
     * Output
     * [null,null,null,null,-3,null,0,-2]
     * 
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top(); // return 0
     * minStack.getMin(); // return -2
     */
    class MinStack {
        private List<int[]> st;

        public MinStack() {
            st = new ArrayList<>();
        }

        public void push(int val) {
            int[] top = st.isEmpty() ? new int[] { val, val } : st.get(st.size() - 1);
            int min_val = top[1];
            if (min_val > val) {
                min_val = val;
            }
            st.add(new int[] { val, min_val });
        }

        public void pop() {
            st.remove(st.size() - 1);
        }

        public int top() {
            return st.isEmpty() ? -1 : st.get(st.size() - 1)[0];
        }

        public int getMin() {
            return st.isEmpty() ? -1 : st.get(st.size() - 1)[1];
        }
    }

    /*
     * 20. Valid Parentheses
     * ==============================================
     * DSA: Stack, String
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * 
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and
     * ']',
     * determine if the input string is valid.
     * 
     * An input string is valid if:
     * - Open brackets must be closed by the same type of brackets.
     * - Open brackets must be closed in the correct order.
     * - Every close bracket has a corresponding open bracket of the same type.
     * 
     * Example 1:
     * Input: s = "()"
     * Output: true
     * 
     * Example 2:
     * Input: s = "()[]{}"
     * Output: true
     * 
     * Example 3:
     * Input: s = "(]"
     * Output: false
     * 
     * Example 4:
     * Input: s = "([])"
     * Output: true
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0)
            return false;

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // "([}}])" for like this case
            }
        }

        return stack.isEmpty();
    }
}
