from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
    
        def backtrack(currentString: str, open_count: int, close_count: int) -> List[str]:
            if len(currentString) == 2 * n:
                print(f"Current string: '{currentString}', open count: {open_count}, close count: {close_count}, next action: Append to result")
                print(f"------------------------------------------ NEXT ------------------------------------------")
                result.append(currentString)
                return
            if open_count < n:
                print(f"Current string: '{currentString}', open count: {open_count}, close count: {close_count}, next action: Append '('")
                backtrack(currentString + "(", open_count + 1, close_count )
            if close_count < open_count:
                print(f"Current string: '{currentString}', open count: {open_count}, close count: {close_count}, next action: Append ')'")
                backtrack(currentString + ")", open_count, close_count + 1)
        
        backtrack("", 0, 0)
        return result

        
def main():
    sol: Solution = Solution()
    # print(sol.generateParenthesis(3))
    print(sol.generateParenthesis(4))
    # print(sol.generateParenthesis(8))

if __name__ == "__main__":
    main()

# ()()