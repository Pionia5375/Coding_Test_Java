from collections import deque

def solution(maps):
    
    n = len(maps)
    m = len(maps[0])
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    def bfs(x, y):
        
        queue = deque()
        queue.append((x, y))
        
        while queue:
            x, y = queue.popleft()
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                    
                if maps[nx][ny] == 0:
                    continue
                
                if maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    queue.append((nx, ny))

        return maps[n - 1][m - 1] if maps[n - 1][m - 1] > 1 else -1
    
    return bfs(0, 0)

# 구하고자 하는 것: 2차원 배열 n, m 인덱스에 도달하기까지의 최단거리
# 예외: 범위 초과, 길이 막힐 경우 예외처리?
# 고려사항: 여러 루트가 있을 때, 최단 거리를 구해야 함 -> BFS로 접근