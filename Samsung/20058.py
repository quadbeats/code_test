from collections import deque


N, Q = map(int, input().split())
board = [list(map(int, input().split()))for _ in range(2**N)]
Listt = list(map(int, input().split()))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


for L in Listt:
    poL = 2**L
    temp = [[0] * (2**L) for _ in range(2**L)]

    for i in range(0, 2**N, 2**L):
        for j in range(0, 2**N, 2**L):

            for x in range(2**L):
                for y in range(2**L):
                    temp[y][x] = board[i+x][j+y]

            for i2 in range(2**L):
                temp[i2].reverse()
            for x in range(2**L):
                for y in range(2**L):
                    board[i+x][j+y] = temp[x][y]

    for x in range(2**N):
        for y in range(2**N):
            count = 0

            for i in range(4):

                nx = x+dx[i]
                ny = y+dy[i]

                if 0 <= nx < 2**N and 0 <= ny < 2**N:
                    if board[nx][ny] > 0:
                        count += 1

            if not count >= 3:
                board[x][y] -= 1


def BFS(mat, r, c):

    queue = deque()
    queue.append((r, c))
    cnt = 1
    while queue:

        x, y = queue.popleft()
        for i in range(4):

            nx = x+dx[i]
            ny = y+dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if mat[nx][ny] > 0:
                    cnt += 1
                    queue.append((nx, ny))
    return cnt


sum = 0
answ = 0
for i in range(2**N):
    for j in range(2**N):
        sum += board[i][j]
        anstemp = BFS(board, i, j)
        answ = max(answ, anstemp)


print(sum, answ)
