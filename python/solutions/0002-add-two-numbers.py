from typing import Optional
from ListNode import ListNode

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        n1 = self.getNumber(l1)
        n2 = self.getNumber(l2)
        n = n1 + n2
        numb = n.__str__()[::-1]
        start = ListNode(int(numb[0]))
        node = start
        for i in range(1, len(numb)):
            node.next = ListNode(int(numb[i]))
            node = node.next
        return start
    
    def getNumber(self, l: Optional[ListNode]):
        result = 0
        tens = 1
        while l is not None:
            result += l.val * tens
            l = l.next
            tens *= 10
        return result

def main():
    sol: Solution = Solution()
    l1: ListNode = ListNode(3, ListNode(4, ListNode(2)))
    l2: ListNode = ListNode(4, ListNode(6, ListNode(5)))
    result = sol.addTwoNumbers(l1, l2)
    while result is not None:
        print(result.val)
        result = result.next

if __name__ == "__main__":
    main()