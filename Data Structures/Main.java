import LinkedList.java.*;

class Main {
    public static void main(String[] args) {

        /* =========== Linked List =========== */
        System.out.println("\n======== SinglyLinkedList =========");
        SinglyLinkedList head = new SinglyLinkedList(1);

        System.out.println(head.val);

        SinglyLinkedList ll2 = new SinglyLinkedList(2);
        head.next = ll2;

        SinglyLinkedList ll3 = new SinglyLinkedList(3);
        ll2.next = ll3;

        SinglyLinkedList ll4 = new SinglyLinkedList(4);
        ll3.next = ll4;

        SinglyLinkedList ll5 = new SinglyLinkedList(5);
        ll4.next = ll5;

        // Traverse Elements Time - O(n)
        head.print();

        // insert At end Time - O(n)
        head.insertAtEnd(6);
        head.insertAtEnd(7);

        head.insertAtEnd(8);
        head.insertAtEnd(9);

        // insert At beginning Time - O(1)
        SinglyLinkedList newhead = SinglyLinkedList.insertAtBeginning(head, 0);
        newhead.print();

        // insert At Nth position Time - O(n)
        newhead.insertAtNthPosition(10, 5);
        newhead.print();

        // remove At Nth position Time - O(n)
        newhead.removeElement(10);
        newhead.print();

        newhead.removeAtNthPosition(0);
        newhead.print();

        newhead.insertAtEnd(5);
        newhead.insertAtEnd(5);
        newhead.insertAtNthPosition(5, 3);
        newhead.print();

        // leetcode question
        SinglyLinkedList newhead2 = SinglyLinkedList.removeElements(newhead, 5);
        newhead2.print();
    }
}