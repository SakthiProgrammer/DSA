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
    // ===========

    /*
     * 2073. Time Needed to Buy Tickets
     * ==============================================
     * DSA: Queue, Array, Simulation
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * There are n people in a line queuing to buy tickets, where the 0th person is
     * at the front of the line and the (n - 1)th person is at the back of the line.
     * You are given a 0-indexed integer array tickets of length n where the number
     * of tickets that the ith person would like to buy is tickets[i].
     * Each person takes exactly 1 second to buy a ticket. A person can only buy 1
     * ticket at a time and has to go back to the end of the line (which happens
     * instantaneously) in order to buy more tickets.
     * If a person does not have any tickets left to buy, the person will leave the
     * line.
     * Return the time taken for the person initially at position k (0-indexed) to
     * finish buying tickets.
     * 
     * Example 1:
     * Input: tickets = [2,3,2], k = 2
     * Output: 6
     * Explanation:
     * The queue starts as [2,3,2], where the kth person is underlined.
     * After the person at the front has bought a ticket, the queue becomes [3,2,1]
     * at 1 second.
     * Continuing this process, the queue becomes [2,1,2] at 2 seconds.
     * Continuing this process, the queue becomes [1,2,1] at 3 seconds.
     * Continuing this process, the queue becomes [2,1] at 4 seconds. Note: the
     * person at the front left the queue.
     * Continuing this process, the queue becomes [1,1] at 5 seconds.
     * Continuing this process, the queue becomes [1] at 6 seconds. The kth person
     * has bought all their tickets, so return 6.
     * 
     * Example 2:
     * Input: tickets = [5,1,1,1], k = 0
     * Output: 8
     * Explanation:
     * The queue starts as [5,1,1,1], where the kth person is underlined.
     * After the person at the front has bought a ticket, the queue becomes
     * [1,1,1,4] at 1 second.
     * Continuing this process for 3 seconds, the queue becomes [4] at 4 seconds.
     * Continuing this process for 4 seconds, the queue becomes [] at 8 seconds. The
     * kth person has bought all their tickets, so return 8.
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                totalTime += Math.min(tickets[i], tickets[k]);
            } else {
                totalTime += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return totalTime;
    }
}
