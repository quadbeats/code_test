def solution(s):
    answer = []
    letterbox={}
    for index, letter in enumerate(s):
        print(index,letter)
        if letter not in letterbox:
            letterbox[letter]=index
            answer.append(-1)
        else:
            prev = letterbox[letter]
            
            letterbox[letter]=index
            answer.append(index-prev)
        
    return answer
