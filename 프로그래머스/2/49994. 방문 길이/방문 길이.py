def solution(dirs):
    moves = {'U': (0, 1), 'D': (0, -1), 'R': (1, 0), 'L': (-1, 0)}
    x, y = 0, 0
    visited = set()

    for d in dirs:
        dx, dy = moves[d]
        nx, ny = x + dx, y + dy

        if not (-5 <= nx <= 5 and -5 <= ny <= 5):
            continue

        visited.add(((x, y), (nx, ny)))
        visited.add(((nx, ny), (x, y)))
        x, y = nx, ny

    return len(visited) // 2

# 구하고자 하는 것: 캐릭터가 처음 걸어본 길의 길이
# 입력: 방향 문자열, 출력: 처음 걸어본 길 개수
# 2차원 평면을 만들고, 카운트 추가 -> 지나갈 때마다 방문 표시
# 방문 시 이동은 함, 카운트 추가 X
# 지나온 길 -> 에지. (해당 좌표가 아님) -> 이전 좌표와 현재 좌표를 저장?

# 해시로 좌표 저장 및 체크?