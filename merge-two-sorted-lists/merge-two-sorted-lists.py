# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        head = l1
        if l1.val < l2.val:
            head = l1
            l1 = l1.next
        else:
            head = l2
            l2 = l2.next
        curr = head
        while l1 != None or l2 != None:
            if l1 != None and l2 != None:
                if l1.val <= l2.val:
                    curr.next = l1
                    curr = curr.next
                    l1 = l1.next
                elif l1.val > l2.val:
                    curr.next = l2
                    curr = curr.next
                    l2 = l2.next
            elif l1 == None:
                curr.next = l2
                curr = curr.next
                l2 = l2.next
            elif l2 == None:
                curr.next = l1
                curr = curr.next
                l1 = l1.next
            
        return head
