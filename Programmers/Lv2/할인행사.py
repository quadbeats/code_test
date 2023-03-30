
def solution(want, number, discount):
    answer = 0
    arr = []
    # shop = dict(zip(want,number))
    # print(shop)
    for i in range(len(number)):
        temp = 1
        while temp<=number[i]:
            arr.append(want[i])
            temp +=1
    #print(sorted(arr))
    print(arr,"arr")
    
    for i in range(len(discount)-9):

        #print((discount[i:i+10]))
        if  sorted(discount[i:i+10]) == sorted(arr):
            answer += 1
        
    
    # for i range(len(number)):
    #     arr.append()
        
            
                
        
    
    
    
    
    return answer
