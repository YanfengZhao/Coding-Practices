class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        #remove trailing white spaces
        s = s.rstrip()
        if len(s)==0:
            return 0
        #split the string
        wordList = s.split(' ')
        lolw = len(wordList[-1])
        return lolw
