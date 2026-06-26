class Solution:
    def longestPalindrome(self, s: str) -> str:
        start, end = 0, 1
        
        for i in range(0, len(s)):

            for j in range(2):

                low, high = i, i+j

                while low >= 0 and high < len(s) and s[low] == s[high]:

                    length = high - low + 1
                    if length > end:
                        start = low
                        end = length
                    low -= 1
                    high += 1

        return s[start:start + end]
            

class Solution1:
    def longestPalindrome(self, s: str) -> str:
        result = ""
        longest = 0
        for i in range(0, len(s)):
            if len(s) - i > longest:
                for j in range(i, len(s)):
                    if j - i + 1 > longest:
                        sstr = s[i:j+1]
                        if self.isPalindrome(sstr) and len(sstr) > longest:
                            result = sstr
                            longest = len(sstr)
        return result


    def isPalindrome(self, s: str) -> bool:
        l = 0
        r = len(s) - 1
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

def main():
    sol: Solution = Solution()
    #print(sol.longestPalindrome("a"))
    #print(sol.longestPalindrome("cbbd"))
    #print(sol.longestPalindrome("aaaabaaa"))
    print(sol.longestPalindrome("bb"))

if __name__ == "__main__":
    main()