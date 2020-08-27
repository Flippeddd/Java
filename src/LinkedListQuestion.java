import java.util.NoSuchElementException;

public class LinkedListQuestion {

    public LinkedListQuestion() {}

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseListNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public ListNode reverseListNode2(ListNode head) {
        ListNode prev = new ListNode(0);
        reverseRecurrsive(head, prev);
        return prev;
    }

    private void reverseRecurrsive(ListNode curr, ListNode prev) {
        if (curr == null) {
            return;
        }
        ListNode tmp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = tmp;
        reverseRecurrsive(curr, prev);
    }

    public ListNode deleteNode(ListNode head, int target) {
        ListNode prev = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            if (head.val != target) {
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        throw new NoSuchElementException("");
    }

    public ListNode findNthNode(ListNode head, int n) {
        while (head != null &&  n > 0) {
            if (n == 0) {
                return head;
            }
            head = head.next;
            n--;
        }
        throw new IndexOutOfBoundsException("");
    }

    public boolean checkLoop(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        while (slowPtr != fastPtr) {
            if (fastPtr == null || fastPtr.next == null) {
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return true;
    }
}




