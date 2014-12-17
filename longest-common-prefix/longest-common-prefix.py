class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        count = 0
        if len(strs) == 0:
            return ""
        for word in strs:
            if word == "":
                return ""
        firstString = strs[0]

        # compare the first string with other strings
        
        foundFalse = False
        for chars in range(0,len(firstString)):
            for word in strs:
                if firstString[0:chars+1] != word[0:chars+1]:
                    foundFalse = True
            if foundFalse == True:
                return strs[0][0:count]
            else:
                count+=1

        return firstString
