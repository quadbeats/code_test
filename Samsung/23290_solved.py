from collections import deque
import copy
M, S = map(int,input().split())
fishes = [list(map(int,input().split())) for _ in range(M)]
shark_x, shark_y = map(int,input().split())
shark_pos =(shark_x-1,shark_y-1)


dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]
sdx = [-1, 0, 1, 0]
sdy = [0, -1, 0, 1]

ans = 0


board = [[deque() for _ in range(4)] for _ in range(4)]
smell = [[0]*4 for _ in range(4)]
oldboard = [[deque() for _ in range(4)] for _ in range(4)]


for i in range(M):
    x,y,d = tuple(fishes[i])
    board[x-1][y-1].append(d-1)
    #oldboard[x - 1][y - 1].append(d-1)

def fishmove():

    res = [[deque() for _ in range(4)] for _ in range(4)]
    for i in range(4):
        for j in range(4):
            while temp[i][j]:
                d = temp[i][j].popleft()
                for z in range(d,d-8,-1):
                    z = z % 8
                    nx = i + dx[z]
                    ny = j + dy[z]

                    if 0<=nx<4 and 0<=ny<4 and smell[nx][ny] == 0 and (nx,ny) != shark_pos:
                        res[nx][ny].append(z)
                        break
                else:
                    res[i][j].append(d)


    return res

def sharkmove(x,y,cnt,eat,visit):
    global maxeat,shark_pos,wayofshark
    if cnt == 3:
        if maxeat < eat:
            maxeat = eat
            shark_pos=(x,y)
            wayofshark= copy.deepcopy(visit)
        return

    for i in range(4):
        nx = x + sdx[i]
        ny = y + sdy[i]

        if 0<=nx<4 and 0<= ny < 4:
            if (nx,ny) not in visit:
                visit.append((nx,ny))
                sharkmove(nx,ny,cnt+1,eat+len(temp[nx][ny]),visit)
                visit.pop()
            else:
                sharkmove(nx,ny,cnt+1,eat,visit)



def delsmell(smellboard):
    for i in range(4):
        for j in range(4):
            if smellboard[i][j]:
                smellboard[i][j] -= 1



for _ in range(S):
    wayofshark = deque()
    maxeat = -99
    temp = copy.deepcopy(board)
    temp=fishmove()
    sharkmove(shark_pos[0],shark_pos[1],0,0,deque())

    for x,y in wayofshark:
        if temp[x][y]:
            temp[x][y].clear()
            smell[x][y] = 3

    delsmell(smell)

    for i in range(4):
        for j in range(4):
            board[i][j] += temp[i][j]



#print(shark_pos,maxeat,wayofshark)

for i in range(4):
    for j in range(4):
        ans = ans + len(board[i][j])
print(ans)
