# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        nodeValList = []
        if head == None:
            return head
        nodeValList.append(head.val)
        prevNode = head
        currNode = head.next
        
        while currNode != None:
            if currNode.val in nodeValList:
                prevNode.next = currNode.next
                currNode = currNode.next
            else:
                prevNode = currNode
                nodeValList.append(currNode.val)
                currNode = currNode.next
        return head
