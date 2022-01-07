from itertools import combinations
def print(str):
    for i in range(0,len(str)+1):
        for el in combinations(str,i):
            print(''.join(el))
str=['a','b','c']
print(str) 
