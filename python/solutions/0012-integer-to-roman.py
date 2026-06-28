import math

class Solution:
    symbol = { 1: "I", 4: "IV", 5: "V", 9: "IX", 10: "X", 40: "XL", 50: "L", 90: "XC", 100: "C", 400: "CD", 500: "D", 900: "CM", 1000: "M"}
    def intToRoman(self, num: int) -> str:
        result = []
        for k in reversed(self.symbol.keys()):
            amount = math.floor(num / k)
            num -= amount * k
            while amount > 0:
                result.append(self.symbol[k])
                amount -= 1
        return "".join(result)


def main():
    sol: Solution = Solution()
    print(sol.intToRoman(3749))
    print(sol.intToRoman(58))
    print(sol.intToRoman(1994))

if __name__ == "__main__":
    main()