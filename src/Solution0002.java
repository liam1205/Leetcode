public class Solution0002 { // MEDIUM
    public class ListNode {
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ln = new ListNode();
            ListNode firstElement = new ListNode();

            int counter = 0;
            int temp = 0;
            while (true) {
                temp += l1.val;
                temp += l2.val;

                boolean bigger = false;
                if (temp >= 10) {
                    temp -= 10;
                    bigger = true;
                }

                ListNode newElement = new ListNode(temp);
                if (counter == 0) {
                    firstElement = newElement;
                }
                ln.next = newElement;
                ln = newElement;

                counter++;

                if (l1.next == null && l2.next == null) {
                    if (bigger) {
                        ln.next = new ListNode(1);
                    }
                    break;
                }

                if (l1.next != null) {
                    l1 = l1.next;
                } else {
                    l1.val = 0;
                }

                if (l2.next != null) {
                    l2 = l2.next;
                } else {
                    l2.val = 0;
                }

                if (bigger) {
                    temp = 0;
                    temp += 1;
                } else {
                    temp = 0;
                }
            }

            return firstElement;
        }
    }
}