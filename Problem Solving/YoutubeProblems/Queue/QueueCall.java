package Queue;

import Utility.MethodCall;

public class QueueCall implements MethodCall {

    @Override
    public void call() {

        Queue queue = new Queue();

        /* ============================================== P: 33 */
        // 1. Implement Stack using Queues (MyStack)
        /* ============================================== */

        Queue.MyStack myStack = queue.new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("MyStack top: " + myStack.top()); // 2
        System.out.println("MyStack pop: " + myStack.pop()); // 2
        System.out.println("MyStack empty: " + myStack.empty()); // false

        /* ============================================== P: 34 */
        // 2. Time Needed to Buy Tickets
        /* ============================================== */

        int[] tickets1 = { 2, 3, 2 };
        int k1 = 2;
        int time1 = queue.timeRequiredToBuy(tickets1, k1);
        System.out.println("Time Needed to Buy Tickets : " + time1); // 6

        int[] tickets2 = { 5, 1, 1, 1 };
        int k2 = 0;
        int time2 = queue.timeRequiredToBuy(tickets2, k2);
        System.out.println("Time Needed to Buy Tickets : " + time2); // 8

        /* ============================================== P: 35 */
        // 3. Reverse First k Element in Queue (Pending)
        /* ============================================== */

    }

}
