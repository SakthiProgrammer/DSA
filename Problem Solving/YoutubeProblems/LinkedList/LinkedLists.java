package LinkedList;

public class LinkedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /*
     * 876. Middle of the Linked List
     * ==============================================
     * DSA: Linked List, Two Pointer
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: Use two pointers, slow and fast. Move slow by 1 step and fast by 2
     * steps.
     * When fast reaches the end, slow will be at the middle.
     *
     * Given the head of a singly linked list, return the middle node of the linked
     * list.
     * If there are two middle nodes, return the second middle node.
     *
     * Example 1:
     * Input: head = [1,2,3,4,5]
     * Output: [3,4,5]
     * Explanation: The middle node of the list is node 3.
     *
     * Example 2:
     * Input: head = [1,2,3,4,5,6]
     * Output: [4,5,6]
     * Explanation: Since the list has two middle nodes with values 3 and 4, we
     * return the second one.
     */

    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;

        // Move slow by 1 and fast by 2 until fast reaches the end
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    /*
     * 141. Linked List Cycle
     * ==============================================
     * DSA: Linked List, Two Pointer (Floyd's Tortoise and Hare)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: Use two pointers (slow and fast). Move slow by 1 step and fast by
     * 2 steps.
     * If there is a cycle, the fast pointer will eventually meet the slow pointer.
     * If fast reaches the end (null), there is no cycle.
     *
     * Given head, the head of a linked list, determine if the linked list has a
     * cycle in it.
     * There is a cycle in a linked list if there is some node in the list that can
     * be reached again by continuously following the next pointer.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * Example 1:
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to
     * the 1st node (0-indexed).
     *
     * Example 2:
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to
     * the 0th node.
     *
     * Example 3:
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     */

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
