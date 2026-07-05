from itertools import permutations
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        for s in strs:
            sorted_string = "".join(sorted(s))
            if anagrams.get(sorted_string) is None:
                anagrams[sorted_string] = [s]
            else:
                anagrams[sorted_string].append(s)
        print(anagrams)
        result = []
        for l in anagrams:
            result.append(anagrams[l])
        print(result)
        
def main():
    sol: Solution = Solution()
    print(sol.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
    print(sol.groupAnagrams(["",""]))

if __name__ == "__main__":
    main()