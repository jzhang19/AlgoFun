class Solution:
    # Brute Force
    def pageination(self, currPage, total, maxVisible):
        
        output = []
        if total <= maxVisible:    
            for i in range(1, total + 1):
                output.append(i)
            for i in range(len(output)):
                if output[i] == currPage:
                    output[i] = "[" + str(output[i]) + "]"
                else:
                    output[i] = str(output[i])
        else:
            center = []
            centerVisible = maxVisible - 2
            leftVisible = (centerVisible - 1) // 2
            leftGap, rightGap = False, False
            
            if currPage == 1:
                center = [i + 2 for i in range(centerVisible)]
            elif currPage > 1 and currPage - leftVisible <= 2:
                center = [i + 2 for i in range(centerVisible)]
            else:
                leftBound = currPage - leftVisible
                remaining = centerVisible - leftVisible
                center = [i for i in range(leftBound, currPage + remaining)]
                
            while center[-1] >= total:
                center = [center[0] - 1] + center
                center.pop()
                
            if center[0] != 2:
                leftGap = True
            if center[-1] != total - 1:
                rightGap = True
                
            output = [1] + ([-1] if leftGap else []) + center + ([-1] if rightGap else []) + [total]
            
            for i in range(len(output)):
                if output[i] == -1:
                    output[i] = " ... "
                elif output[i] == currPage:
                    output[i] = "[" + str(output[i]) + "]"
                else:
                    output[i] = str(output[i])

        return " ".join(output)
    
    # TODO: Thinking about using sliding window
    def pageination(self, currPage, total, maxVisible):
        
        pages = [i for i in range(1, total + 1)]
        half = (maxVisible - 1) // 2
        leftBound, rightBound = currPage - half, currPage + half 
        
        # 3 7 11
        # 


    def main(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # [1] 2 3 4  ...  9
        print(self.pageination(1, 9, 5))
        # [1] 2 3 4 5 6 7 8 9 10 11
        print(self.pageination(1, 11, 11))
        # [1] 2 3 4 5 6 7 8 9 10  ...  30
        print(self.pageination(1, 30, 11))
        # 1 2 3 4 5 [6] 7 8 9 10  ...  30
        print(self.pageination(6, 30, 11))
        # 1  ...  3 4 5 6 [7] 8 9 10 11  ...  30
        print(self.pageination(7, 30, 11))
        # 1  ...  21 22 23 24 25 26 27 28 29 [30]
        print(self.pageination(30, 30, 11))
        # 1  ...  19 20 21 22 [23] 24 25 26 27  ...  30
        print(self.pageination(23, 30, 11))
        # 1  ...  21 22 23 24 25 26 27 28 [29] 30
        print(self.pageination(29, 30, 11))
