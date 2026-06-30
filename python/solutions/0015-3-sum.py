class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        result = []
        nums.sort()
        i = 0
        while i < len(nums):
            if i > 0 and nums[i] == nums[i-1]:
                i += 1
                continue
            j, k = i + 1, len(nums) - 1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if s == 0:
                    result.append([nums[i], nums[j], nums[k]])
                    while j < k and nums[j] == nums[j+1]: j += 1
                    while j < k and nums[k] == nums[k-1]: k -= 1
                    j += 1; k -= 1
                elif s < 0:
                    j += 1
                else:
                    k -= 1
            i += 1
        return result
    
class SolutionUnoptimized:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        triples = set()
        result = []
        for i, num1 in enumerate(nums):
            for j, num2 in enumerate(nums):
                if i != j:
                    for k, num3 in enumerate(nums):
                        if j != k and i != k:
                            if num1 + num2 + num3 == 0:
                                numbers = [f"{num1}", f"{num2}", f"{num3}"] 
                                numbers.sort()
                                before = len(triples)
                                triples.add(f"{",".join(numbers)}")
                                after = len(triples)
                                if before < after:
                                    result.append([num1, num2, num3])
        return result
        
def main():
    sol: Solution = Solution()
    print(sol.threeSum([-1,0,1,2,-1,-4]))
    print(sol.threeSum([0,1,1]))
    print(sol.threeSum([0,0,0]))

if __name__ == "__main__":
    main()