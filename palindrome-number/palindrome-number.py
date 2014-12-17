class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0:
            return False
        stringx = str(x)
        reversex = stringx[::-1]
        if stringx == reversex:
            return True
        else:
            return False
