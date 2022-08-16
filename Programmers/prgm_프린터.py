

def solution(priorities, location):
    answer = 0
    cnt = 0
    pair = [(i,p) for i,p in enumerate(priorities)]
    
    
    while pair:
        check=pair.pop(0)
        
        print(check)
        if any(check[1] < other[1] for other in pair):
            pair.append((check[0],check[1]))
            #print(pair)
        else:
            cnt += 1
            if location == check[0]:
                #print(cnt)
                break
   
    #rint(pair)
    return cnt
