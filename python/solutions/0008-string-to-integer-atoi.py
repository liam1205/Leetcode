class Solution:
    INT_MAX = 2**31 - 1
    INT_MIN = -2**31
    def myAtoi(self, s: str) -> int:
        # Ignore any leading whitespaces
        first = 0
        sstr = s.lstrip(' ')

        if sstr == "":
            return 0

        # Determine the sign
        sign = 1
        if sstr[0] == "-":
            sign = -1
            sstr = sstr[1:len(sstr)]
        elif sstr[0] == "+":
            sstr = sstr[1:len(sstr)]
            

        result = 0
        for c in sstr:
            if not c.isnumeric():
                break
            result = result * 10 + int(c)
        
        result *= sign

        if result > self.INT_MAX:
            result = self.INT_MAX
        elif result < self.INT_MIN:
            result = self.INT_MIN
    
        return result
        
def main():
    sol: Solution = Solution()
    print(sol.myAtoi("42"))
    print(sol.myAtoi(" -042"))
    # print(sol.myAtoi("1337c0d3"))
    # print(sol.myAtoi("0-1"))
    # print(sol.myAtoi("words and 987"))
    # print(sol.myAtoi("4193 with words"))
    # print(sol.myAtoi("-91283472332"))
    # print(sol.myAtoi(" "))
    # print(sol.myAtoi(""))
    # print(sol.myAtoi("2147483648"))

if __name__ == "__main__":
    main()