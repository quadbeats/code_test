def solution(keymap, targets):
    answer = []
    keydics = {}
    for key in keymap:
        for index, value in enumerate(key):
            
            if (value in keydics):
                #print("HH",keydics[value],value,index)
                if keydics[value]> index +1:
                    keydics[value] = index +1
            else:
                keydics[value]= index+1
            
            #print(keydics)
    for target in targets:
        temp = 0 
        for t in target:
            
            if t in keydics:
                #print(keydics[t])
                temp += keydics[t]
            else:
                temp = -1
                break
        
        answer.append(temp)
            
            
    return answer
