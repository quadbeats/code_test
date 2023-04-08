from collections import deque
from itertools import count

N, M, K = map(int,input().split())

board = [[[] for _ in range(N)]for _ in range(N)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]
otherplayerpos =[]
for i in range(N):
    temp = list(map(int,input().split()))
    for j in range(N):
        #print(temp[j])
        if temp[j] != 0:
            board[i][j].append(temp[j])

player = []
score=[]
for _ in range(M):

    score.append(0)
for i in range(M):
    x,y,d,s = tuple(map(int,input().split()))
    #print(x,y,d,s)
    player.append((x-1,y-1,d,s,0))
    otherplayerpos.append((x-1,y-1))

def moveplayer(x,y,d):

    for z in range(d,d+2):
        nx = x +dx[d]
        ny = y +dy[d]

        if 0<= nx <N and 0<=ny<N:
            break
    else:
        d = (d + 2) % 4
        nx = x + dx[d]
        ny = y + dy[d]

    return nx,ny,d

def playercheck(x,y,q):
    
    for i in range(q+1,q+M):
        i = i % M
        px,py,pd,ps,pg = player[i]

        if px == x and py == y:
            return True
    else:
        return False

def guncheck(x,y,g):

    if board[x][y]:
        #자리에 총이 있고
        board[x][y].sort(reverse=True)
        if g ==0 :
            #총 미소유면
            g = board[x][y][0]
            del(board[x][y][0])
        else:
            #총 이미 소유면

            if board[x][y][0] > g:
                #바닥에 있는게 더 쌔면 swap
                g,board[x][y][0] = board[x][y][0],g

    return g

def fight(a,counter):
    
    x,y,d,s,g = player[a]
    cx,cy,cd,cs,cg = player[counter]

    playerstat = s+g
    counterstat = cs+cg

    if playerstat> counterstat:
        score[a] = score[a] + playerstat - counterstat
        loser(counter)
        winner(a)
    elif playerstat < counterstat:
        score[counter] = score[counter] + counterstat - playerstat
        loser(a)
        winner(counter)
    else:
        #두명의 스택이 같으면
        if s > cs:
            score[a] = score[a] + playerstat - counterstat
            loser(counter)
            winner(a)
        else:
            score[counter] = score[counter] + counterstat - playerstat
            loser(a)
            winner(counter)

        
def loser(loseplayer):
    
    x,y,d,s,g=player[loseplayer]
    if g != 0:
        board[x][y].append(g)
    #drop the gun
    for z in range(d,d+4):
        z = z %4
        nx = x + dx[z]
        ny = y + dy[z]
        
        # if nx<0 or nx >=N or ny < 0 or ny >=N:
        #     continue
        # if playercheck(nx,ny):
        #     continue
        if 0<= nx < N and 0<=ny < N:
            if not playercheck(nx,ny,loseplayer):
                temp=guncheck(nx,ny,0) 
                player[loseplayer]=(nx,ny,z,s,temp)
                otherplayerpos[loseplayer] = (nx,ny)
                break

def winner(winplayer):
    x,y,d,s,g = player[winplayer]
    g=guncheck(x,y,g)
    player[winplayer] = (x,y,d,s,g)
    otherplayerpos[winplayer] = (x,y)





for _ in range(K):

    for q in range(M):
        x,y,d,s,g = player[q]
        nx,ny,d = moveplayer(x,y,d)
        #otherplayerpos[q]=(-1,-1)
        #체크용
        player[q]= (nx,ny,d,s,g)
        if playercheck(nx,ny,q):
            #print("FIGHT!")
            counterp= -999
            for i in range(q+1,q+M):
                i = i%M
                if player[i][0] == nx and player[i][1] ==ny:
                    #print(i,"counter")
                    counterp = i
                    break
            
            #print(q,counterp,"FIGHT")
            fight(q,counterp)

        else:
            g=guncheck(nx,ny,g)
            player[q] = (nx,ny,d,s,g)

        #otherplayerpos에 마지막 다하고 자기자신 추가해둘것 !!!!!!!!!!!!!!
        #otherplayerpos[q]=(nx,ny)
        #otherplayerpos.insert(q,(nx,ny))



# print()
# print(player)
# print((otherplayerpos))
# for i in range(N):
#     print(board[i])
for i in range(len(score)):
    print(score[i], end=" ")
