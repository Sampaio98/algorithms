package bigOStudy;

import utils.ListNode;

public class MergeSort {

    void main() {
        ListNode node7 = new ListNode(7);
        ListNode node1 = new ListNode(1, node7);
        ListNode node3 = new ListNode(3, node1);
        ListNode node9 = new ListNode(9, node3);
        IO.println(mergeSort(node9));
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        var mid = findMiddle(head);
        var afterMid = mid.next;
        mid.next = null;

        var left = mergeSort(head);
        var right = mergeSort(afterMid);

        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        var head = new ListNode();
        var tail = head;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        tail.next = node1 != null ? node1 : node2;
        return head.next;
    }

    private ListNode findMiddle(ListNode head) {
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
