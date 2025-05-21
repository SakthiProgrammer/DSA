package LinkedList;

import Utility.MethodCall;

public class LinkedListCall implements MethodCall {

    @Override
    public void call() {
        LinkedLists linkedLists = new LinkedLists();

        /* ============================================== P: 1 */
        // 1. Middle of the Linked List
        /* ============================================== */
        ListNode head = createList(1, 2, 3, 4, 5);
        ListNode middle = linkedLists.middleNode(head);
        System.out.print("Middle of Linked List: ");
        printList(middle); // Output: 3->4->5

        head = createList(1, 2, 3, 4, 5, 6);
        middle = linkedLists.middleNode(head);
        System.out.print("Middle of Linked List: ");
        printList(middle); // Output: 4->5->6

        /* ============================================== P: 2 */
        // 2. Linked List Cycle
        /* ============================================== */
        // Example 1: head = [3,2,0,-4], pos = 1 (cycle at node with value 2)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle here
        boolean hasCycle = linkedLists.hasCycle(node1);
        System.out.println("Has Cycle: " + hasCycle); // true

        // Example 2: head = [1,2], pos = 0 (cycle at node with value 1)
        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1; // cycle here
        hasCycle = linkedLists.hasCycle(node1);
        System.out.println("Has Cycle: " + hasCycle); // true

        // Example 3: head = [1], pos = -1 (no cycle)
        node1 = new ListNode(1);
        hasCycle = linkedLists.hasCycle(node1);
        System.out.println("Has Cycle: " + hasCycle); // false
    }

    /**
     * Utility method to create a linked list from given values.
     */
    private ListNode createList(int... values) {
        if (values.length == 0)
            return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Utility method to print a linked list.
     */
    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null)
                System.out.print("->");
            node = node.next;
        }
        System.out.println();
    }
}
