from collections import Counter

def solution(topping):
    answer = 0
    A = set()
    B = Counter(topping)
    a,b = 0, len(B)     #종류 개수
    for top in topping:
        B[top] -= 1 # 해당 topping 1개 제거
        
        if B[top] == 0:
            b -=1
            
        if top not in A:
            A.add(top)
            a +=1
        
        if a==b:
            answer +=1
        
        if a > b:
            break
            
    
    #print(B[])
           
    return answer
