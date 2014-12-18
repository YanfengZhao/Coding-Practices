# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        # get the length of the linkedList
        if head.next == None or n < 1:
             return None
        currNode = head
        counter = 0
        nthNode = head
        prev = nthNode
        timesNIncreases = 0
        while currNode.next != None:
            counter+=1
            if counter >= n:
                nthNode = nthNode.next
                timesNIncreases+=1
                if timesNIncreases > 1:
                    prev = prev.next
            currNode = currNode.next
        if counter>=n:
            prev.next = nthNode.next
            return head
        if counter == n-1:
            return nthNode.next
        
        return None
