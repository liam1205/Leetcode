from typing import List

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        result = []
        nums.sort()
        i = 0

        while i < len(nums):
            if i > 0 and nums[i] == nums[i - 1]:
                i += 1
                continue
            j = i + 1
            while j < len(nums):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    j += 1
                    continue
                left, right = j + 1, len(nums) - 1
                
                while left < right:
                    sum = nums[i] + nums[j] + nums[left] + nums[right]
                    if sum == target:
                        result.append([nums[i], nums[j], nums[left], nums[right]])
                        while left < right and nums[left] == nums[left + 1]: left += 1
                        while left < right and nums[right] == nums[right - 1]: right -= 1
                        left, right = left + 1, right - 1
                    elif sum > target:
                        right -= 1
                    else:
                        left += 1
                j += 1
                
            i += 1
        return result
        
def main():
    sol: Solution = Solution()
    print(sol.fourSum([1,0,-1,0,-2,2], 0))
    print(sol.fourSum([2,2,2,2,2], 8))

if __name__ == "__main__":
    main()