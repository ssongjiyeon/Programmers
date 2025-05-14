#어떻게 바꾸는데....
import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
M = [[] for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ans = 0
qShark = deque()

for i in range(N):
    M[i] = list(map(int, input().split()))
    for j in range(N):
        if M[i][j] == 9:
            qShark.append((i, j)) # 상어 x, y좌표

SharkSize = 2
fishCnt = 0
while qShark:
    SharkX, SharkY = qShark.popleft()
    qFish = deque()

    for i in range(N):
        for j in range(N):
            if M[i][j] < SharkSize and 1 <= M[i][j] <= 6:
                qFish.append((i, j))

    # print("shakr x = ", SharkX, "shark y=", SharkY)
    # print("qfish", qFish)

    smallDist = 1000000000
    smallX = -1
    smallY = -1
   

    while qFish:
        qFishmove = deque()
        FishX, FishY = qFish.pop()
        qFishmove.append((FishX, FishY, 0))
        visit = [[False for _ in range(N)] for _ in range(N)]
        visit[FishX][FishY] = True
         
        # print("fishx = ", FishX, "fishy = ", FishY)
        while qFishmove:
            # print("qfishmove", qFishmove)

            fishx, fishy, distf = qFishmove.popleft()

            if fishx == SharkX and fishy == SharkY:
                if distf <= smallDist:
                    smallDist = distf
                    smallX = FishX
                    smallY = FishY
                    # print("dist = ", distf, "x = ", smallX, "y = ", smallY)
                break
            
            for i in range(4):
                nx = fishx + dx[i]
                ny = fishy + dy[i]

                if 0 <= nx < N and 0 <= ny <N and (M[nx][ny] <= SharkSize or M[nx][ny] == 9) and not visit[nx][ny]:
                    visit[nx][ny] = True
                    qFishmove.append((nx, ny, distf+1))

    if smallX == -1 and smallY == -1:
        print(ans)
        break
    else:
        fishCnt += 1
        ans += smallDist
        if fishCnt >= SharkSize:
            fishCnt -= SharkSize
            SharkSize += 1
        M[smallX][smallY] = 0
        qShark.append((smallX, smallY))
        


































# size = 1
# qFish = deque()

# while ?

# for i in range(N):
#     for j in range(N):
#         if M[i][j] == size:
#             qFish.append((i, j)) #물고기 좌표

# fishCnt = 0
# while qFish:

#     fishX, fishY = qFish.popleft()
#     visit = [[False for _ in range(N)] for _ in range(N)]
#     check = False # 아기상어가 물고기를 먹었는지 안먹었는지
#     X = 0, Y = 0, SSize = 0 # 아기상어 원래 위치 저장하는 변수
#     while qShark:

#         sharkX, sharkY, sharkSize, dist = qShark.popleft()

#         if dist == 0:
#             X = sharkX, Y = sharkY, SSize = sharkSize

#         visit[sharkX][sharkY] = True

#         if sharkX == fishX and sharkY == fishY:
#             ans += dist
#             fishCnt += 1
#             qShark.clear()
#             qShark.append((sharkX, sharkY, sharkSize, 0))
#             break
        
#         for i in range(4):
#             sharkNX = sharkX + dx[i]
#             sharkNX = sharkX + dy[i]

#             if 0 <= sharkNX < N and 0 <= sharkNX <N:
#                 if (not visit[sharkNX][sharkNY]) and M[sharkNX][sharkNY] <= sharkSize:
#                     qShark.append((sharkNX, sharkNY, sharkSize, dist+1))

#     if not check:
#         qShark.append((X, Y, SSize, 0))


    



