from collections import deque, Counter

def solution(game_board, table):
    n = len(game_board)

    def extract(grid, target):
        """target 값으로 이어진 덩어리들을 좌표 리스트로 뽑아낸다."""
        visited = [[False] * n for _ in range(n)]
        groups = []
        for i in range(n):
            for j in range(n):
                if grid[i][j] != target or visited[i][j]:
                    continue
                q = deque([(i, j)])
                visited[i][j] = True
                cells = []
                while q:
                    r, c = q.popleft()
                    cells.append((r, c))
                    for dr, dc in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                        nr, nc = r + dr, c + dc
                        if 0 <= nr < n and 0 <= nc < n \
                                and not visited[nr][nc] and grid[nr][nc] == target:
                            visited[nr][nc] = True
                            q.append((nr, nc))
                groups.append(cells)
        return groups

    def normalize(cells):
        """좌상단이 원점에 오도록 평행이동 + 정렬"""
        mr = min(r for r, _ in cells)
        mc = min(c for _, c in cells)
        return tuple(sorted((r - mr, c - mc) for r, c in cells))

    def canonical(cells):
        """4가지 회전 중 사전순 최소 = 회전 불변 대표값"""
        forms = []
        cur = list(cells)
        for _ in range(4):
            forms.append(normalize(cur))
            cur = [(c, -r) for r, c in cur]   # 시계 90°
        return min(forms)

    holes = extract(game_board, 0)   # 빈칸은 0
    pieces = extract(table, 1)       # 조각은 1

    stock = Counter(canonical(p) for p in pieces)

    answer = 0
    for hole in holes:
        key = canonical(hole)
        if stock[key]:
            stock[key] -= 1
            answer += len(hole)
    return answer

# 구하고자 하는 것: 가능한 퍼즐을 모두 끼워넣었을 때, 들어가는 퍼즐의 칸 개수
# 제약: 회전 가능, 뒤집을 수 없음. 공간에 딱 맞게 테이블이 부여됨, 최소 3 x 3, 최대 50 x 50
# 입출력: 빈칸 표시된 게임 보드 배열, 퍼즐이 표시된 테이블 배열

# 정답을 구하려면 - 같은 모양의 퍼즐이 있을 때, 해당 퍼즐의 칸을 추가한다.
# 필요한 것 - 퍼즐 모양의 동일성 판별, 각 퍼즐의 칸의 개수 판별
# 칸의 개수 판별 - DFS / BFS 사용 -> 완전 탐색, 매 칸 마다 카운트 + 1
# 모양의 동일성 판별
# 접근 1: 방향의 기준을 하나로 잡기: 가장 처음 이동한 방향을 위로 잡고, 매 이동 시마다 처음 좌표를 기준으로 좌표 기록 -> 완전 탐색으로 좌표 기록 후 퍼즐과 대조