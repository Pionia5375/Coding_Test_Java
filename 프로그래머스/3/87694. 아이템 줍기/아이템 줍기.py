from collections import deque


def solution(rectangle, characterX, characterY, itemX, itemY):
    board = [[0] * 102 for _ in range(102)]

    # 1) 좌표 2배 확대 후 테두리(1) / 내부(2) 칠하기
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                if x in (x1, x2) or y in (y1, y2):
                    if board[x][y] != 2:      # 이미 지워진 칸은 되살리지 않음
                        board[x][y] = 1
                else:
                    board[x][y] = 2           # 내부는 영구 삭제

    # 2) 테두리 위에서 BFS
    start = (characterX * 2, characterY * 2)
    target = (itemX * 2, itemY * 2)
    q = deque([(start[0], start[1], 0)])
    visited = {start}

    while q:
        x, y, dist = q.popleft()
        if (x, y) == target:
            return dist // 2
        for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            nx, ny = x + dx, y + dy
            if board[nx][ny] == 1 and (nx, ny) not in visited:
                visited.add((nx, ny))
                q.append((nx, ny, dist + 1))

# 구하고자 하는 것 - 캐릭터가 아이템을 줍기 위해 이동하애 하는 가장 짧은 거리
# 입출력 - 서로 겹친 직사각형 꼭짓점 좌표 x1, y1, x2, y2 시작 좌표 x, y 타겟 좌표 x, y, 출력: 최단 거리 정수
# 접근
# 1. 최단 경로 구하기? -> 탐색, BFS (최단 경로 보장)
# 2. 전체 지도를 어떻게 구할 것인가?
# BFS를 쓰기 위해 필요한 것 - 인접 리스트 / 인접 행렬
# 범위 겹친다는 것 - 안쪽으로 겹친다? (교집합) - 해당 범위 잘라내기?
# rectangle의 각 요소별로 배열 하나씩 생성, 해당 범위 위의 모든 좌표를 담은 배열 생성
# 테두리 안의 좌표를 어떻게 지울 것인가?
# 테두리의 교차지점 -> 같은 좌표
# 겹치는 좌표의 한 요소를 기준으로, 해당 x / y 좌표를 고정한 채 다른 한 좌표의 겹치는 좌표를 모두 삭제
# 인접 노드 - x 혹은 y 좌표가 같은 상태에서, 다른 한쪽 좌표가 1만큼 차이나는 좌표

# 알고리즘
# rectangle의 각 요소 순회
# 1번 요소와 2번 요소를 오른쪽 위 꼭짓점, 3, 4 요소를 왼쪽 아래 꼭짓ㅈㅁ으로 해서 모든 좌표 배열에 담기
# 겹치는 좌표 등장시, 해당 좌표 고정하고, 다른 한쪽에서 범위 안의 좌표 모두 삭제 -> 테두리 완성
# BFS 실행

