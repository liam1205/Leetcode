class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        right = 0
        map = {}
        result = 0
        while right < len(s):
            if map.get(s[right]) is not None and map.get(s[right]) > 0:
                del map[s[left]]
                left += 1
            else:
                map[s[right]] = 1
                right += 1

            if right - left >= result:
                result = right - left

        return result