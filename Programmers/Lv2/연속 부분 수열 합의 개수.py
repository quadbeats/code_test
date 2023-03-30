def solution(elements):
    answer = 0
    temp = []
  
    

    for i in range(1,len(elements)+1):
        for j in range(len(elements)):
            
            if (j+i)>= len(elements):
               
                temp.append(sum(elements[j:] + elements[:i+j-len(elements)]))
            else:
                #print("+++",elements[j:j+i])
                temp.append(sum(elements[j:j+i]))
    temp=set(temp)        
       
            
            
    return len(temp)
