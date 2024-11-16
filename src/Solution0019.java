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
}
class Solution0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode res = head;
        while(true) {
            if (i + 1 == n) {
                ListNode temp = head.next;
                if (temp.next == null) {
                    head.next = null;
                } else {
                    head.next = temp.next;
                }
                break;
            }
            i++;
            head = head.next;
        }
        return res;
    }
}
