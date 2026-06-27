class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        x = abs(x)
        result = int(str(x)[::-1])
        if result > 2 ** 31:
            return 0
        return result * sign
    
class SolutionNotOptimized:
    def reverse(self, x: int) -> int:
        negative = True if x < 0 else False
        if negative:
            x *= -1
        result: float = int(x.__str__()[::-1])
        if result > 2 ** 31:
            return 0
        return result * (-1) if negative else result

def main():
    sol: Solution = Solution()
    print(sol.reverse(123))
    print(sol.reverse(-123))
    print(sol.reverse(1534236469))
    print(sol.reverse(1534236469))

if __name__ == "__main__":
    main()