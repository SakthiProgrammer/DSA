package Queue;

import Utility.MethodCall;

public class QueueCall implements MethodCall {

    @Override
    public void call() {

        Queue queue = new Queue();

        /* ============================================== */
        // 1. Implement Stack using Queues (MyStack)
        /* ============================================== */

        Queue.MyStack myStack = queue.new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("MyStack top: " + myStack.top()); // 2
        System.out.println("MyStack pop: " + myStack.pop()); // 2
        System.out.println("MyStack empty: " + myStack.empty()); // false

    }

}
