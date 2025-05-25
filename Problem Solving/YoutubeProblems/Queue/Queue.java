package Queue;

import java.util.LinkedList;

public class Queue {
    /*
     * 225. Implement Stack using Queues
     * ==============================================
     * DSA: Stack, Queue
     * Time Complexity: O(1) for push, pop, top, and empty
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Implement a last-in-first-out (LIFO) stack using only two queues.
     * The implemented stack should support all the functions of a normal stack
     * (push, top, pop, and empty).
     * 
     * Implement the MyStack class:
     * - void push(int x): Pushes element x to the top of the stack.
     * - int pop(): Removes the element on the top of the stack and returns it.
     * - int top(): Returns the element on the top of the stack.
     * - boolean empty(): Returns true if the stack is empty, false otherwise.
     * 
     * Notes:
     * - You must use only standard operations of a queue, which means that only
     * push to back, peek/pop from front, size and is empty operations are valid.
     * - Depending on your language, the queue may not be supported natively. You
     * may simulate a queue using a list or deque (double-ended queue) as long as
     * you use only a queue's standard operations.
     * 
     * Example 1:
     * Input:
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * Output:
     * [null, null, null, 2, 2, false]
     * 
     * Explanation:
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // return 2
     * myStack.pop(); // return 2
     * myStack.empty(); // return false
     */
    class MyStack {

        LinkedList<Integer> stack;

        public MyStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            stack.addFirst(x);
        }

        public int pop() {
            return stack.pollFirst();
        }

        public int top() {
            return stack.peekFirst();
        }

        public boolean empty() {
            return stack.size() == 0;
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
