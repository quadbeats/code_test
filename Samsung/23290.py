
from collections import deque
import copy


M, S = map(int, input().split())


Smell = [[0]*4 for _ in range(4)]
Board = [[[] for _ in range(4)] for _ in range(4)]


dx = [0, -1, -1, -1, 0, 1, 1, 1]       # <- 부터 시계방향
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

# for _ in range(M):
#     x, y, d = map(int, input().split())
#     Board[x-1][y-1].append(d-1)
fish = [list(map(int, input().split())) for _ in range(M)]
for x, y, d in fish:
    Board[x - 1][y - 1].append(d - 1)

shark_x, shark_y = map(int, input().split())
shark_x -= 1
shark_y -= 1


def shark(x, y, cnt, history, eat):  # history는 상어가 움직인 자취queue
    global max_eat, visit, shark_x, shark_y
    if cnt == 3:
        if max_eat < eat:
            max_eat = eat
            shark_x, shark_y = x, y
            visit = copy.copy(history)
        return

    for d in [2, 0, 6, 4]:  # 상 좌 하 우
        nx = x + dx[d]
        ny = y + dy[d]

        if -1 < nx < 4 and -1 < ny < 4:  # 보드 내부이고
            if (nx, ny) not in history:  # 처음 간 길이면 ??
                history.append((nx, ny))
                shark(nx, ny, cnt+1, history, eat+len(temp[nx][ny]))
                history.pop()
            # else:
            #     shark(nx, ny, cnt+1, history, eat)


def fish_move(board):

    res = [[[] for _ in range(4)] for _ in range(4)]
    temp_fish = copy.deepcopy(board)

    for i in range(4):
        for j in range(4):

            while temp_fish[i][j]:
                d = temp_fish[i][j].pop(0)

                flag = 0
                nx = i+dx[d]
                ny = j+dy[d]

                for q in range(8):

                    if -1 < nx < 4 and -1 < ny < 4:  # 보드의 내부이고 , 상어가 없고, 냄새가 없으면 ㅇㅋ
                        if not (nx == shark_x and ny == shark_y):
                            if Smell[nx][ny] == 0:
                                res[nx][ny].append(d)
                                flag = 1
                                break

                    d = (d+7) % 8
                    nx = i+dx[d]
                    ny = j+dy[d]

                if flag == 0:  # 아무곳도 갈수 없으면
                    res[i][j].append(d)  # 원래 자리 i,j에다가 d
    return res


for _ in range(S):
    visit = deque()
    max_eat = -1
    temp = fish_move(Board)

    shark(shark_x, shark_y, 0, deque(), 0)
    # print(temp)
    for i, j in visit:
        if temp[i][j]:
            temp[i][j] = []
            Smell[i][j] = 3

    for i in range(4):
        for j in range(4):
            if Smell[i][j]:
                Smell[i][j] -= 1

    for i in range(4):
        for j in range(4):
            Board[i][j] += temp[i][j]

    #print(Fish, temp)


ans = 0
for i in range(4):
    for j in range(4):
        ans += len(Board[i][j])

print(ans)
