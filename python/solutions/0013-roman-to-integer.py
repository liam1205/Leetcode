class Solution:
    symbol = {"I": 1, "IV": 4, "V": 5,  "IX": 9, "X": 10, "XL": 40 , "L": 50, "XC": 90, "C": 100, "CD": 400, "D": 500, "CM": 900, "M": 1000}
    
    def romanToInt(self, s: str) -> int:
        result = 0
        i = 0
        while i < len(s):
            cur = s[i]
            num = self.symbol[cur]
            if len(s) - i > 1:
                nextCur = s[i+1]
                nextNum = self.symbol[nextCur]
                if num < nextNum:
                    result += self.symbol[f"{cur}{nextCur}"]
                    i += 2
                else:
                    result += self.symbol[cur]
                    i += 1
            else:
                result += self.symbol[cur]
                i += 1
        return result

class Solution1:
    symbol = {"I": 1, "IV": 4, "V": 5,  "IX": 9, "X": 10, "XL": 40 , "L": 50, "XC": 90, "C": 100, "CD": 400, "D": 500, "CM": 900, "M": 1000}
    
    def romanToInt(self, s: str) -> int:
        result = 0
        i = len(s) - 1
        while i >= 0:
            sym = ""
            sstr = s[i-1:i+1]
            if i > 0:
                keys = self.symbol.keys()
                if keys.__contains__(sstr):
                    sym = sstr
                else:
                    sym = s[i]
            else:
                sym = s[i]
            
            value = self.symbol[sym]
            result += value

            if len(sym) > 1:
                i -= 2
            else:
                i -= 1
        return result

def main():
    sol: Solution = Solution()
    print(sol.romanToInt("III"))
    print(sol.romanToInt("LVIII"))
    print(sol.romanToInt("MCMXCIV"))
    print(sol.romanToInt("IV"))

if __name__ == "__main__":
    main()