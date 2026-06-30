from collections import deque
from typing import List

class Solution:
    mappings = { "2": ["a", "b", "c"], "3": ["d", "e", "f"], "4": ["g", "h", "i"], "5": ["j", "k", "l"], "6": ["m", "n", "o"], "7": ["p", "q", "r", "s"], "8": ["t", "u", "v"], "9": ["w", "x", "y", "z"]}
    def letterCombinations(self, digits: str) -> List[str]:

        result = []
        q = deque()
        q.append("")

        while q:
            prefix = q.popleft()

            if len(prefix) == len(digits):
                result.append(prefix)
            else: 
                digit = digits[len(prefix)]
                for letter in self.mappings[digit]:
                    q.append(prefix + letter)

        return result
        
def main():
    sol: Solution = Solution()
    print(sol.letterCombinations("23"))

if __name__ == "__main__":
    main()