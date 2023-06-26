def solution(k, tangerine):
    answer = 0
    a=[]
    temp=k
    big = max(tangerine)+1
    
    for i in range(big):
        a.append(0)
    for i in range(len(tangerine)):
        a[tangerine[i]] += 1 
    
    a.sort(reverse=True)
    
    for i in range(len(a)):
        if temp<=0:
            
            return i
        else:
            temp -= a[i]
            
    
    
