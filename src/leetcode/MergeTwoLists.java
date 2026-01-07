package leetcode;

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode secondNode1 = new ListNode(1);
        ListNode secondNode2 = new ListNode(3);
        ListNode secondNode3 = new ListNode(4);
        secondNode1.next = secondNode2;
        secondNode2.next = secondNode3;

        System.out.println(mergeTwoLists(node1, secondNode1));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var ref = new ListNode();
        var curr = ref;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
        }

        curr.next = list1 != null ? list1 : list2;

        return ref.next;
    }

}
