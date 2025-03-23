package LinkedList.java;

public class SinglyLinkedList {
    public int val;
    public SinglyLinkedList next;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int val) {
        this.val = val;
    }

    public SinglyLinkedList(int val, SinglyLinkedList next) {
        this.val = val;
        this.next = next;
    }

    // Insert at the beginning (returns new head)
    public static SinglyLinkedList insertAtBeginning(SinglyLinkedList head, int val) {
        SinglyLinkedList newNode = new SinglyLinkedList(val);
        newNode.next = head; // Point the new node to the old head
        return newNode; // Return the new head
    }

    public void insertAtNthPosition(int val, int position) {
        SinglyLinkedList ll = new SinglyLinkedList(val);
        SinglyLinkedList temp = this;
        int count = 1;
        while (temp != null) {
            if (count == position) {
                ll.next = temp.next;
                temp.next = ll;
                break;
            }
            count++;
            temp = temp.next;
        }
    }

    public void insertAtEnd(int val) {
        SinglyLinkedList ll = new SinglyLinkedList(val);

        if (this.next == null) {
            this.next = ll;
            return;
        }
        SinglyLinkedList temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = ll;
    }

    public void print() {
        SinglyLinkedList temp = this;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public void removeAtNthPosition(int position) {
        SinglyLinkedList temp = this;
        int count = 0;
        while (temp != null) {
            if (count == position) {
                temp.next = temp.next.next;
                break;
            }
            count++;
            temp = temp.next;
        }
    }

    public void removeElement(int val) {
        SinglyLinkedList temp = this;
        while (temp != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public static SinglyLinkedList removeElements(SinglyLinkedList head, int val) {

        if (head == null) {
            return null;
        }

        SinglyLinkedList res = new SinglyLinkedList(1, head);
        SinglyLinkedList temp = res;

        while (temp != null) {
            while (temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return res.next;
    }

}
