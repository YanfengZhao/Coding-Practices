class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        if len(A) == 0:
            A = B
        elif len(B) == 0:
            pass
        else:
            spaceNeed = m+n
            pointerA = m-1
            pointerB = n-1
            for i in reversed(range(0,spaceNeed)):
                if pointerA == -1:
                    A[i]=B[pointerB]
                    pointerB-=1
                elif pointerB == -1:
                    A[i]=A[pointerA]
                    pointerA-=1
                else:
                    if A[pointerA]>= B[pointerB]:
                        A[i] = A[pointerA]
                        pointerA-=1
                    else:
                        A[i] = B[pointerB]
                        pointerB-=1
