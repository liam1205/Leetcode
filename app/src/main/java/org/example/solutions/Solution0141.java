package org.example.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution0141 {

    // not optimized
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        while (head.next != null) {
            if (map.containsKey(head.next)) {
                return true;
            } else {
                map.put(head.next, 1);
                head = head.next;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution0141 solver = new Solution0141();
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(0);
        second.next = third;
        ListNode fourth = new ListNode(4);
        fourth.next = second;
        System.out.println(solver.hasCycle(first));
    }
}
