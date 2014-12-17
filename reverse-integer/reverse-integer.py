class Solution:
    # @return an integer
    def reverse(self, x):
        absx = abs(x)
        result = int(str(absx)[::-1])
        if x < 0:
            result *= -1
        if abs(result) > 2147483642:
            return 0
        
        # strx = str(x)
        # result = ""
        # if x < 0:
        #     result += '-'
        #     strx = strx[1:]
        # integerPart = ""
        # for s in strx:
        #     integerPart = s + integerPart
        # result = result+integerPart
        # result = int(result)
        return result
