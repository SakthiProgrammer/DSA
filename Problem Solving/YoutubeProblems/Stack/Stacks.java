package Stack;

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
}
