package leetcode;

import java.util.ArrayList;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

//        System.out.println(hasCycle(node1));
        System.out.println(hasCycleV2(node1));
    }

    public static boolean hasCycleV2(ListNode head) {
        var a = head;
        var z = head;
        while (z != null && z.next != null) {
            a = a.next;
            z = z.next.next;
            if (a == z) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        var list = new ArrayList<ListNode>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }


}

