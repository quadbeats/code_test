def solution(s, skip, index):
    answer = ''
    skipmap = dict()
    
    for skipword in skip:
        skipmap[skipword]= 1
    
    print(skipmap)
    print(skipmap.get('w'))
    
    
        
    for word in s:
        asciword = ord(word)
        cnt = 0
        
        while cnt< index:
            asciword += 1
            if asciword > ord('z'):
                asciword = ord('a')
            
            
            if skipmap.get(chr(asciword)) ==1:
                continue
            else:
                cnt += 1
        temp = chr(asciword)
        answer += temp
        print(answer,"asdf")
        
        #print(asciword)
        #if skipmap[word]== 1:
        
    
    #print(skipmap)
    
    
    
        
        
        
    
    return answer
