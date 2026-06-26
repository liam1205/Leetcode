class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        result = [[] for _ in range(numRows)]
        down = True
        r = 0
        for c in s:
            result[r].append(c)

            if r == numRows - 1:
                down = False
            elif r == 0:
                down = True

            if down:
                r += 1
            else:
                r -=1
        
        toReturn = []
        for row in result:
            toReturn.append(''.join(row))
        
        return ''.join(toReturn)
            
            
        
def main():
    sol: Solution = Solution()
    print(sol.convert("PAYPALISHIRING", 3))

if __name__ == "__main__":
    main()