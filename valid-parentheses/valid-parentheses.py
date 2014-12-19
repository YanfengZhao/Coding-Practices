class Solution:
    # @return a boolean
    def isValid(self, s):
        stack = []
        topOfStack = -1
        for c in s:
            if c == "(" or c == "{" or c == "[":
                stack.append(c)
                topOfStack += 1
            elif c == ")":
                if topOfStack != -1:
                    if stack[topOfStack] != "(":
                        return False
                    else:
                        topOfStack-=1
                        stack.pop()
                else:
                    return False
            elif c == "]":
                if topOfStack != -1:
                    if stack[topOfStack] != "[":
                        return False
                    else:
                        topOfStack-=1
                        stack.pop()
                else:
                    return False
            elif c == "}":
                if topOfStack != -1:
                    if stack[topOfStack] != "{":
                        return False
                    else:
                        topOfStack-=1
                        stack.pop()
                else:
                    return False
        if topOfStack == -1:
            return True
        else:
            return False
