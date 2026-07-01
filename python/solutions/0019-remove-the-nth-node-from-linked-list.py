from typing import Optional

from ListNode import ListNode

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        previous = None
        current = head
        next = head.next
        size = 1

        while current.next is not None:
            previous = current
            current = current.next
            next = current.next
            size += 1

        print("size: ", size)

        previous = None
        current = head
        next = head.next
        i = 0
        stop = size - n
        print("stop: ", stop)
        while i <= stop:
            if i == stop:
                if previous is not None and next is not None:
                    previous.next = next
                elif previous is None:
                    current = current.next
                    head = current
                else: 
                    previous.next = None
                    
                break
            else:
                previous = current
                current = current.next
                next = current.next
                i += 1

        return head
            

        
def main1():
    sol: Solution = Solution()
    head = ListNode(1)
    cur = head
    for i in range(2, 6):
        cur.next = ListNode(i)
        cur = cur.next
    result = sol.removeNthFromEnd(head, 2)
    while result is not None:
        print(result.val)
        result = result.next

def main2():
    sol: Solution = Solution()
    head = ListNode(1)
    result = sol.removeNthFromEnd(head, 1)
    while result is not None:
        print(result.val)
        result = result.next

def main3():
    sol: Solution = Solution()
    head = ListNode(1)
    cur = head
    for i in range(2, 3):
        cur.next = ListNode(i)
        cur = cur.next
    result = sol.removeNthFromEnd(head, 2)
    while result is not None:
        print(result.val)
        result = result.next

if __name__ == "__main__":
    main2()