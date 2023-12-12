class Solution0083 {
    public static class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        ListNode prev = head;
        if(head == null || head.next == null) {
            return first;
        }
        head = head.next;
        while (head != null) {
            if (head.val == prev.val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head  = head.next;
        }
        return first;
    }

    public static void main(String[] args) {
        Solution0083 s = new Solution0083();

        // list1 = [1,2,2,4]
        Solution0083.ListNode node111 = new Solution0083.ListNode(1);
        Solution0083.ListNode node112 = new Solution0083.ListNode(2);
        node111.next = node112;
        Solution0083.ListNode node113 = new Solution0083.ListNode(2);
        node112.next = node113;
        Solution0083.ListNode node114 = new Solution0083.ListNode(4);
        node113.next = node114;

        Solution0083.ListNode list1 = s.deleteDuplicates(node111);
        System.out.println("list = [1,2,2,4]");
        while (list1 != null) {
            System.out.print(list1.val + " ");
            list1 = list1.next;
        }
        System.out.println();

        // list1 = []
        Solution0083.ListNode node211 = new Solution0083.ListNode();

        Solution0083.ListNode list2 = s.deleteDuplicates(node211);
        System.out.println("list = []");
        while (list2 != null) {
            System.out.print(list2.val + " ");
            list2 = list2.next;
        }
        System.out.println();

        // list1 = [2,2,2,2]
        Solution0083.ListNode node311 = new Solution0083.ListNode(2);
        Solution0083.ListNode node312 = new Solution0083.ListNode(2);
        node311.next = node312;
        Solution0083.ListNode node313 = new Solution0083.ListNode(2);
        node312.next = node313;
        Solution0083.ListNode node314 = new Solution0083.ListNode(2);
        node313.next = node314;

        Solution0083.ListNode list3 = s.deleteDuplicates(node311);
        System.out.println("list = [2,2,2,2]");
        while (list3 != null) {
            System.out.print(list3.val + " ");
            list3 = list3.next;
        }
        System.out.println();
    }
}