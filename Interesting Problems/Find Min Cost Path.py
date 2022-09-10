#     AAA —— DDD
#    /  \
# CCC   BBB

# Total = 2 steps

# {
#     "AAA": ["BBB", "CCC", "DDD"],
#     "BBB": ["AAA"],
#     "CCC": ["AAA"],
#     "DDD": ["AAA"]
    
# }
# [AAA] -> [CCC, BBB, DDD] 
# [CCC] -> [AAA] -> [BBB, DDD]
# [BBB] -> [AAA] -> [CCC, DDD]
# [DDD] -> [AAA] -> [BBB, CCC]


# Let N = Node
# Let E = Edges (Avg 2 edges per node)
# Let S = Steps

# Time： N * E ^ S


