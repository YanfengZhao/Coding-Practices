class Solution:
    # @return an integer
    def atoi(self, str):
        negativeNum = False
        startingWhiteSpaces = 0
        integerBuf = ''
        intList = ['0','1','2','3','4','5','6','7','8','9']
        if len(str) == 0:
            return 0
        # count white spaces
        while str[startingWhiteSpaces] == ' ':
            startingWhiteSpaces+=1
        string = str[startingWhiteSpaces:]
        
        # check if all white spaces
        if len(string) == 0:
            return 0
        
        # check if a sign is present
        if string[0] == "+":
            string = string[1:]
        elif string[0] == "-":
            negativeNum = True
            string = string[1:]
        
        # collect as many numbers as possible
        for s in string:
            if s in intList:
                integerBuf += s
            else:
                break
            
        result = 0
        if len(integerBuf)<1:
            return 0
            
        elif negativeNum == True:
            result = int(integerBuf) * -1
        else:
            result = int(integerBuf)
        
        # check overflow    
        if result >2147483647:
            return 2147483647
        if result<-2147483648:
            return -2147483648
            
        return result
