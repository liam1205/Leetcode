from typing import List

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        sum = None
        nums.sort()
        i = 0
        while i < len(nums):
            if i > 0 and nums[i] == nums[i-1]:
                i += 1
                continue
            j, k = i + 1, len(nums) - 1
            while j < k:
                print(f"({i}{j}{k})")
                s = nums[i] + nums[j] + nums[k]
                if sum is None or abs(s - target) < abs(sum - target):
                    sum = s
                if s < target:
                    j += 1
                elif s > target:
                    k -= 1
                else:
                    return s
            i += 1
        return sum
        
def main():
    sol: Solution = Solution()
    print(sol.threeSumClosest([-1,2,1,-4], 1))

if __name__ == "__main__":
    main()