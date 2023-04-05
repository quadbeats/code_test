from collections import deque

N,M,K = map(int,input().split())
ans = 0

balls = [list(map(int,input().split())) for _ in range(M)]

dx=[-1,-1,0,1,1,1,0,-1]
dy=[0,1,1,1,0,-1,-1,-1]

board = [[deque() for _ in range(N)]for _ in range(N)]
newboard =[[deque() for _ in range(N)]for _ in range(N)]


def setballs(x,y,m,s,d):

    board[x][y].append((m,s,d))

def move(x,y):

    while board[x][y]:
        m,s,d = board[x][y].popleft()
        nx = (x + dx[d] * s) % N
        ny = (y + dy[d] * s) % N
        newboard[nx][ny].append((m,s,d))



def splitball(x,y):
    cnt = len(board[x][y])
    oddcnt,evencnt=0,0
    sm,ss,sd = 0 ,0,0
    while board[x][y]:
        m,s,d = board[x][y].popleft()
        sm += m
        ss += s
        sd += d
        if d%2:
            oddcnt += 1
        else:
            evencnt += 1

    sm = sm//5
    ss = ss//cnt
    if sm > 0:
        for i in range(4):
            if oddcnt == cnt or evencnt==cnt:
                # 1, 3 , 5, 7
                board[x][y].append((sm,ss,2*i))
            else:
                board[x][y].append((sm, ss, 2 * i+1))



######0. 초기세팅
for x,y,m,s,d in balls:
    setballs(x-1,y-1,m,s,d)


for _ in range(K):

    ##### 2. 이동
    # move(0,0,5,2,2)
    # splitball(0,2)
    for i in range(N):
        for j in range(N):
            if board[i][j]:
                move(i,j)

    newboard,board = board,newboard
    ## 3.
    for i in range(N):
        for j in range(N):
            if len(board[i][j])>=2:
                splitball(i,j)


for i in range(N):
    for j in range(N):
        if board[i][j]:
            while board[i][j]:
                m,s,d=board[i][j].popleft()
                ans += m
    #print(board[i])
print(ans)

