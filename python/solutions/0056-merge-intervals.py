from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # sort
        intervals.sort(key = lambda x: x[0])
        print(f"Sorted: {intervals}")

        # walk through
        i = 1
        while i < len(intervals):
            left_i = intervals[i - 1][0] if intervals[i - 1][0] <= intervals[i - 1][1] else intervals[i - 1][1]
            right_i = intervals[i - 1][0] if intervals[i - 1][0] > intervals[i - 1][1] else intervals[i - 1][1]
            left_j = intervals[i][0] if intervals[i][0] <= intervals[i][1] else intervals[i][1]
            right_j = intervals[i][0] if intervals[i][0] > intervals[i][1] else intervals[i][1]
            if right_i >= left_j:
                smallest = left_j if left_j <= left_i else left_i
                largest = right_j if right_j >= right_i else right_i
                intervals[i - 1] = [smallest, largest]
                del intervals[i]
            else:
                i += 1

        return intervals


    def mergeUnoptimized(self, intervals: List[List[int]]) -> List[List[int]]:
        i = 0
        while i < len(intervals):
            j = i + 1
            while j > i and j < len(intervals):
                if i != j:
                    print(f"Comparing {intervals[i]} with {intervals[j]}")
                    leftI = intervals[i][0] if intervals[i][0] <= intervals[i][1] else intervals[i][1]
                    rightI = intervals[i][0] if intervals[i][0] > intervals[i][1] else intervals[i][1]
                    leftJ = intervals[j][0] if intervals[j][0] <= intervals[j][1] else intervals[j][1]
                    rightJ = intervals[j][0] if intervals[j][0] > intervals[j][1] else intervals[j][1]
                    # merge
                    if (rightI >= leftJ and rightJ >= leftI) or ( rightJ >= leftI and rightI >= leftJ):
                        smallest = leftJ if leftJ <= leftI else leftI
                        largest = rightJ if rightJ >= rightI else rightI
                        intervals[i] = [smallest, largest]
                        del intervals[j]
                        i = 0
                        j = i + 1
                    else: 
                        j += 1
            i += 1
        return intervals

def main():
    sol: Solution = Solution()
    print(sol.merge([[1,3],[2,6],[8,10],[15,18]]))
    print(sol.merge([[1,4],[4,5]]))
    print(sol.merge([[4,7],[1,4]]))
    print(sol.merge([[1,1],[1,1]]))
    print(sol.merge([[4,7]]))
    print(sol.merge([[1,4],[0,2],[3,5]]))
    print(sol.merge([[2,3],[4,5],[6,7],[8,9],[1,10]]))
    print(sol.merge([[1,4],[5,6]]))

if __name__ == "__main__":
    main()