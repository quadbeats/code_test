def solution(record):
    answer = []
    y = dict()
    for sen in record:
        if sen.split()[0] =='Enter' or sen.split()[0]=='Change':
            y[sen.split()[1]] = sen.split()[2] 
        #print(sen.split()[0])
        #print(y)
    
    for res in record:
        if res.split()[0] =='Enter':
            answer.append("%s님이 들어왔습니다."%y[res.split()[1]])
        elif res.split()[0] =='Leave':
            answer.append("%s님이 나갔습니다."%y[res.split()[1]])
    
    #print(answer)
        
    
    
    return answer
