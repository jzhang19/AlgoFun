class Aggregator:
    
    def combine(self, arr1, arr2):
        
        newArray, a, b = [], 0, 0        
        while a < len(arr1) and b < len(arr2):
            ax, ay = arr1[a] # if a < len(arr1) else (arr2[b][0], 0)
            bx, by = arr2[b] # if b < len(arr2) else (arr1[a][0], 0)
            
            if ax == bx:
                newArray.append(tuple([ax, ay + by]))
                a += 1
                b += 1
            elif ax < bx:
                newArray.append(tuple([ax, ay + by]))
                a += 1 
            else:
                newArray.append(tuple([bx, ay + by]))
                b += 1 
            
        if a < len(arr1):
            newArray.extend(arr1[a:])
        if b < len(arr2):
            newArray.extend(arr2[b:])
        return newArray
    
aggregator = Aggregator()

test1Arr1 = [(1, 3), (3, 1), (5, 3), (6, 2), (10, 1)]
test1Arr2 = [(2, 3), (4, 2), (6, 1), (11, 1)]

test1 = aggregator.combine(test1Arr1, test1Arr2)
print(test1)

"""
case 0 
arr1 = [(1, 1), (2, 2)]
arr2 = [(1, 1), (2, 1)]
result = [(1, 2), (2, 3)]

case 1 
arr1 = [(1, 1), (2, 2), (3, 2)]
arr2 = [(1, 1), (2, 1)]
result = [(1, 2), (2, 1), (3, 2)]

case 2
arr1 = [(1, 1), (3, 2)]
arr2 = [(1, 1), (4, 1)]
result = [(1, 2), (3, 3), (4, 1)]

case 3
arr1 = [(1, 1), (3, 2), (100000, 2)]
arr2 = [(1, 1), (3, 5), (4, 1)]
result = [(1, 2), (3, 7), (4, 3), (100000, 2)]

case 4 
arr1 = [(2, 1), (1, 2), (3, 2)]
arr2 = [(1, 1), (2, 1)]
result = [(1, 2), (2, 1), (3, 2)]


Time: len(a1) + len(a2)
head of a1 vs head of a2 using while loop 

tuple = (x, y)
# Case 1: if x in arr1 and x in arr2, I care
# Case 2: if x not in arr1 and x not in arr2, I don't care
                continue
# Case 3: For all other cases where (x in a1 but not in a2) or （x in a2 but not in a1)


# Case 0
test0Arr1 = [(1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6)]
test0Arr2 = [(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1)]
result    = [(1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7)]
test0 = aggregator.combine(test0Arr1, test0Arr2)
print(test0)

# Case 1
test1Arr1 = [(1, 3), (3, 1), (5, 3), (6, 2), (10, 1)]
test1Arr2 = [(2, 3), (4, 2), (6, 1), (11, 1)]

test1 = aggregator.combine(test1Arr1, test1Arr2)
print(test1)

"""
