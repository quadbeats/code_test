N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]
movement= [list(map(int,input().split())) for _ in range(M)]
# d는 1부터
dx = [0,0,-1,-1,-1,0,1,1,1]
dy = [0,-1,-1,0,1,1,1,0,-1]
ans = 0

# ddx = [-1,]
# ddy = [-1]
#######
clouds = [(N-2,0),(N-2,1),(N-1,0),(N-1,1)]
newclouds = [] #temporry

#구름 위치 이동

def move(x,y,d,s):
    nx = (x + dx[d]*s)%N
    ny = (y + dy[d]*s)%N
    newclouds.append((nx,ny)) #이동한 구름들의 좌표

def rain(x,y):
    board[x][y] += 1

#def copywater(x,y):



for i in range(M):
    d,s = movement[i]
   
    #print(clouds,"cLOUDS")
    num =len(clouds)
    for j in range(num):
        x,y = clouds.pop(0)
        #print(x,y,d,s)
        move(x,y,d,s)
        x,y = newclouds[j]
        
        rain(x,y)
        #print(board,"sdfsdf")
    for e in range(num):
        x,y = newclouds[e]
        for z in range(1,5):
            nx = x + dx[2*z]
            ny = y + dy[2*z]
            
            if 0<=nx<N and 0<=ny<N:
                if board[nx][ny] > 0:
                    
                    board[x][y] += 1


    for r in range(N):
        for c in range(N):
           
            if (r,c) in newclouds:
                
                continue
            else:
                if board[r][c] >= 2:
                    board[r][c] -= 2
                    #print()
                    #print(board[i][j])
                    clouds.append((r,c))
    newclouds.clear()

for i in range(N):
    ans += (sum(board[i]))

print(ans)
