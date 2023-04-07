from collections import deque

N ,M = map(int,input().split())

board = [list(map(int,input())) for _ in range(N)]

dx=[0,1,0,-1] # 우 하 좌 상
dy=[1,0,-1,0]

def BFS(x,y):

    queue = deque()
    queue.append((x,y))
    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]


            if 0<= nx <N and 0<= ny < M:
                if board[nx][ny] == 1:
                    board[nx][ny] = board[x][y] +1
                    queue.append((nx,ny))


    return board[N-1][M-1]

ans = BFS(0,0)
print(ans)

