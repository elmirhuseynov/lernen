package leetcode.easy;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        var list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(7))));
        var mergeTwoLists = mergeTwoLists(list1, list2);

        System.out.println(mergeTwoLists);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
