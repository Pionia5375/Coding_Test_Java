def solution(n, costs):
    visited = [0]
    answer = 0

    while len(visited) < n:
        best = None
        
        # decomposition
        for a, b, c in costs:
            
            # 둘 중 하나만 방문했을 때,
            if (a in visited) != (b in visited):
                if best is None or c < best[2]:
                    best = (a, b, c)
                    
        answer += best[2]
        visited.append(best[1] if best[0] in visited else best[0])

    return answer

# 구하고자 하는 것. 다리를 모두 놓았을 때 최소 비용
# 입력: [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
# 출력: 4
# 섬의 개수: 1 ~ 100
# cost의 최대 길이 ~~ 5000

# 모든 섬이 연결될 조건?
# 각 요소의 1번째, 2번째 요소에 모든 섬들의 숫자가 포함될 것. 예시에서는, 0, 1, 2, 3이 모두 등장한다면 
# 비용이 최소일 조건?