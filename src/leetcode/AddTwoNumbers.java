package leetcode;

import utils.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(3)));
        ListNode node2 =
                new ListNode(5,
                        new ListNode(6,
                                new ListNode(4)));

        System.out.println(addTwoNumbersOptimized(node1, node2));


        ListNode node3 =
                new ListNode(9);


        ListNode node4 =
                new ListNode(1,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9,
                                                                        new ListNode(9,
                                                                                new ListNode(9,
                                                                                        new ListNode(9))))))))));


        System.out.println(addTwoNumbersOptimized(node3, node4));
    }

    // first solution
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum1 = 0;
        long sum2 = 0;
        long multiplier = 1;

        while (l1 != null) {
            sum1 = sum1 + l1.val * multiplier;
            multiplier *= 10;
            l1 = l1.next;
        }
        multiplier = 1;
        while (l2 != null) {
            sum2 = sum2 + l2.val * multiplier;
            multiplier *= 10;
            l2 = l2.next;
        }

        var total = sum1 + sum2;

        var dummy = new ListNode();
        var head = dummy;

        while (total > 0) {
            var digit = total % 10;
            dummy.next = new ListNode((int) digit);
            dummy = dummy.next;
            total /= 10;

        }
        return head.next != null ? head.next : new ListNode();
    }

    public static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
