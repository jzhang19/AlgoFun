# Purchases are negative and sales are positive cash flows in the following equations. For example, if predicted prices over the next n = 6 minutes are prices = [3, 4, 5, 3, 5, 2], one way to the best outcome is to purchase a share in each of the first 2 minutes for cash flows -3 + -4 = -7, then sell them at the third minute for 2 * 5 = 10. Purchase a share in the 4th minute for 3 and sell it in the 5th minute for 5. Total profits are -3 - 4 + 10 - 3 + 5 = 5. 

# maximumProfit has the following parameter:
# price: an array of integers that denote the stock price at minutes 1 through n

# Constraints: 
# 1 <= t <= 10
# 1 <= n <= 5 * 10 ^ 5
# 1 <= prices[i] <= 10 ^ 5

'''
3, 4, 5, 3, 5, 2   
'''

class Solution:
    # dfs
    # def maximumProfit(self, price):
        
    #     maxProfit = [0]
    #     def dfs(idx, current, profit):
    
    #         if idx >= len(price):
    #             return
            
    #         dfs(idx + 1, current, profit)
    #         dfs(idx + 1, current + [price[idx]], profit)
        
    #         currProfit = 0
    #         if len(current) > 0:
    #             gain, cost = len(current) * price[idx], sum(current)
    #             currProfit = profit + (gain - cost)
    #             if currProfit > 0:
    #                 maxProfit[0] = max(maxProfit[0], currProfit)
    #                 dfs(idx + 1, [], currProfit)
    #     dfs(0, [], 0)
    #     return maxProfit[0]
    
    def maximumProfit(self, price):
        
        if len(price) < 2:
            return 0

        stack, currMax, maxProfit = [], price[-1], 0
        for i in range(len(price) - 2, -1, -1):
            
            if currMax >= price[i]:
                stack.append(price[i])
            else:
                cost, count = 0, 0
                while stack:
                    cost += stack.pop()
                    count += 1
                
                profit = currMax * count - cost 
                maxProfit += profit
                
                currMax = price[i]

        if len(stack) > 0:
            cost, count = 0, 0
            while stack:
                cost += stack.pop()
                count += 1
            
            profit = currMax * count - cost 
            maxProfit += profit
                
        return maxProfit
    
sol = Solution()
print(sol.maximumProfit([3, 4, 5, 3, 5, 2]))
        