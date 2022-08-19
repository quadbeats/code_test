from collections import deque

def solution(queue1, queue2):
    answer = -2
    
    quesum = (sum(queue1) + sum(queue2))
    target = quesum//2
    
    que1_sum = sum(queue1)
   
    que1 = deque(queue1)
    que2 = deque(queue2)
    cnt = 0
    
   #print(quesum)
    
    if quesum%2 == 1:
        
        return -1
    
    while que1 and que2 and cnt<=4*len(queue1):
        
        if que1_sum> target:
            temp = que1.popleft()
            que1_sum -= temp
            que2.append(temp)
            cnt += 1
            
        elif que1_sum< target:
            temp = que2.popleft()
            que1_sum += temp
            que1.append(temp)
            cnt += 1
        else :
            return cnt
           
    
    else:
        return -1 
        
            
    #print
    
    
    #return answer
