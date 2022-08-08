from collections import deque
def solution(progresses, speeds):
    answer = []
    count = 0
    queue=deque()
    for i in range(len(progresses)):
        cnt = 0
        while progresses[i] <100:
            progresses[i] += speeds[i]
            cnt += 1
        queue.append(cnt)
    
    #print(queue)
    piv = queue[0] 
    
    while queue:
        value = queue.popleft()
        #print(piv , value)
        if piv<value:       #다음이 기준보다 크면 ? 배포
            answer.append(count)
            count = 1
        else:
            count += 1        #처음은 자동 1부터 늘어남
        piv = max(piv,value)
        #print(piv, answer,count)
            
    answer.append(count)
    

            
        
    
    return answer
