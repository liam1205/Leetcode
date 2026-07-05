from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1 for i in range(0, len(nums))]
        suffix = [1 for i in range(0, len(nums))]
        
        prev = 1
        for i, d in enumerate(nums):
            prefix[i] = prev
            prev *= d
        
        print("prefix: ", prefix)

        suf = 1
        i = len(nums) - 1
        while i >= 0:
            d = nums[i]
            suffix[i] = suf
            suf *= d
            i -= 1

        print("suffix: ", suffix)

        
        return [prefix[i] * suffix[i] for i in range(0, len(nums))]

def main():
    sol: Solution = Solution()
    print(sol.productExceptSelf([1,2,3,4]))

if __name__ == "__main__":
    main()

# nums = [1,2,3,4]