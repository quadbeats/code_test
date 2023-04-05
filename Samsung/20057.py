N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]
ans=0
x,y = N//2,N//2
# 중심으로 부터 날아가는 비율
# a 자리는 percent 값 -1
left =[(1,1,0.01),(1,0,0.07),(2,0,0.02),(1,-1,0.1),(0,-2,0.05),(-1,-1,0.1),(-1,0,0.07),(-1,1,0.01),(-2,0,0.02),(0,-1,-1)]
down = [(-1, -1, 0.01), (-1, 1, 0.01), (0, -2, 0.02), (0, 2, 0.02), (0, -1, 0.07), (0, 1, 0.07), (2, 0, 0.05), (1, -1, 0.1), (1, 1, 0.1), (1, 0, -1)]
right = [(-1, -1, 0.01), (1, -1, 0.01), (-2, 0, 0.02), (2, 0, 0.02), (-1, 0, 0.07), (1, 0, 0.07), (0, 2, 0.05), (-1, 1, 0.1), (1, 1, 0.1), (0, 1, -1)]
up = [(1, 1, 0.01), (1, -1, 0.01), (0, -2, 0.02), (0, 2, 0.02), (0, -1, 0.07), (0, 1, 0.07), (-2, 0, 0.05), (-1, -1, 0.1), (-1, 1, 0.1), (-1, 0, -1)]

def move(dx,dy,dir,step):
    global x,y,ans
    for _ in range(step):

        #중심점 이동
        x=x+dx
        y=y+dy
        if x <0 or y <0:
            break
        # 한 턴에서 움직인 모래의 양
        totalsand = 0
        #msand = 0
        # 모래이동
        for sdx,sdy,percent in dir:
            nx= x +sdx
            ny= y +sdy
            # a자리 모래 계산
            if percent == -1:
                msand = board[x][y]- totalsand
            else:
                msand = int(board[x][y] * percent)
                totalsand += msand

            #모래의 새로운 이동 좌표가 내부이면 ?
            if 0<=nx<N and 0<=ny <N:
                #비율만큼 곱해서 보드에 더함


                #print("INNER MSAND",msand)
                board[nx][ny] += msand

            else:
                #여기는 보드 벗어난 애들

                ans += msand


        board[x][y] = 0



for i in range(1,N+1):
    #좌랑 하 는 1부터 홀수 번째만
    if i % 2:
        move(0,-1,left,i)
        move(1,0,down,i)
        #print(i)
    else:
        move(0,1,right,i)
        move(-1,0,up,i)
        #print(i,"i")


print(ans)



