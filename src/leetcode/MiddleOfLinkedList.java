package leetcode;

import utils.ListNode;

public class MiddleOfLinkedList {

    void main() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        IO.println(middleNode(node));
        IO.println(middleNode(node2));
    }

    public ListNode middleNode(ListNode head) {
        var slow = new ListNode(0, head);
        while (head != null && head.next != null) {
            slow = slow.next;
            head = head.next.next;
        }
        return slow.next;
    }
}
