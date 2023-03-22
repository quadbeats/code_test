def solution(food):
    answer = '0'
    
    for i in range(len(food)-1,0,-1):
        if food[i] == 1:
            continue
        else:
            perfood = food[i] //2
            temp = ''
            # print("tt",temp)
            # temp = temp + '%d'% i
            # print("TT",temp)
            for j in range(perfood):
                temp = temp + '%d'% i
            answer = temp + answer + temp
            
      
    
    print(answer)
    return answer
