class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        returnList = []
        strDigits = ''
        for c in digits:
            strDigits += str(c)
        intDigits = int(strDigits)
        intDigits+=1
        strDigits = str(intDigits)
        for c in strDigits:
            returnList.append(int(c))
        return returnList
