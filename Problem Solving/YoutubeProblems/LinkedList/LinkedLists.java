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
     * DSA: Linked List, Two Pointer - (Fast and Slow Pointer)
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
     * DSA: Linked List, Two Pointer (Floyd's Tortoise and Hare) (Fast and Slow
     * Pointer)
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

    /*
     * 203. Remove Linked List Elements
     * ==============================================
     * DSA: Linked List
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: Use a dummy node to simplify edge cases (like removing the head).
     * Traverse the list and skip nodes whose value matches the target.
     *
     * Given the head of a linked list and an integer val, remove all the nodes of
     * the linked list that have Node.val == val, and return the new head.
     *
     * Example 1:
     * Input: head = [1,2,6,3,4,5,6], val = 6
     * Output: [1,2,3,4,5]
     *
     * Example 2:
     * Input: head = [], val = 1
     * Output: []
     *
     * Example 3:
     * Input: head = [7,7,7,7], val = 7
     * Output: []
     */

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode res = new ListNode(1, head);
        ListNode temp = res;

        while (temp != null) {
            while (temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return res.next;
    }

    /*
     * 92. Reverse Linked List II
     * ==============================================
     * DSA: Linked List
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Medium
     * ==============================================
     * Intuition: Use a dummy node to handle edge cases. Move a pointer to the node
     * before the 'left' position.
     * Then, iteratively reverse the sublist between 'left' and 'right' by adjusting
     * pointers.
     *
     * Given the head of a singly linked list and two integers left and right where
     * left <= right,
     * reverse the nodes of the list from position left to position right, and
     * return the reversed list.
     *
     * Example 1:
     * Input: head = [1,2,3,4,5], left = 2, right = 4
     * Output: [1,4,3,2,5]
     *
     * Example 2:
     * Input: head = [5], left = 1, right = 1
     * Output: [5]
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0); // created dummy node
        dummy.next = head;
        ListNode prev = dummy; // intialising prev pointer on dummy node

        for (int i = 0; i < left - 1; i++)
            prev = prev.next; // adjusting the prev pointer on it's actual index

        ListNode curr = prev.next; // curr pointer will be just after prev
        // reversing
        for (int i = 0; i < right - left; i++) {
            ListNode forw = curr.next; // forw pointer will be after curr
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummy.next;
    }

    /*
     * 234. Palindrome Linked List
     * ==============================================
     * DSA: Linked List, Two Pointer
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: Use two pointers to find the middle of the list. Reverse the
     * second half.
     * Then, compare the first and second halves node by node.
     *
     * Given the head of a singly linked list, return true if it is a palindrome or
     * false otherwise.
     *
     * Example 1:
     * Input: head = [1,2,2,1]
     * Output: true
     *
     * Example 2:
     * Input: head = [1,2]
     * Output: false
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /*
     * 21. Merge Two Sorted Lists
     * ==============================================
     * DSA: Linked List
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: Use a dummy node and a pointer to build the merged list.
     * Compare the heads of both lists and attach the smaller node to the merged
     * list.
     * Continue until one list is exhausted, then attach the remaining nodes from
     * the other list.
     *
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by splicing
     * together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     * Example 1:
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     *
     * Example 2:
     * Input: list1 = [], list2 = []
     * Output: []
     *
     * Example 3:
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

}
