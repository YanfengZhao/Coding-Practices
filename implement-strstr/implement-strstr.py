class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        if len(needle) > len(haystack):
            return -1
        if len(needle)==0 or len(haystack)== 0:
            return 0
        for i in range(0,len(haystack)):
            if needle[0]==haystack[i]:
                temp = haystack[i:i+len(needle)]
                if needle == temp:
                    return i
        return -1
