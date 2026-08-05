def solution(n, computers):
    
    visited = [False] * n
    answer = 0
    
    def dfs(node):
        visited[node] = True
        for nxt in range(n):
            if computers[node][nxt] == 1 and not visited[nxt]:
                dfs(nxt)
                
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer += 1
    
    return answer

# 구하고자 하는 것: 네트워크의 개수 -> 서로 단절된 네트워크의 수
# 입력: 컴퓨터 개수만큼의 요소, 그리고 각 요소는 다시 컴퓨터 개수만큼의 요소를 가지는 배열. 자기자신은 1, 연결된 노드는 1, 연결되지 않는 노드는 0으로 처리
# 제한: 컴퓨터의 개수는 1 이상 200이하 -> 하나하나 다 훑는 완전탐색 시 O(n^2) -> 널널
# 접근
# 입력 배열의 크기를 복사한 배열 생성 -> 방문 표시용, 처음은 다 미방문으로 처리
# 방문 배열 순회 -> 미방문 인덱스마다 아래를 반복
# computer 배열의 해당 인덱스를 가지는 배열에서 DFS를 실행 -> 인접 인덱스 모두 방문처리 -> 복사한 배열에 반영
# DFS가 끝날 때마다 카운트 1증가
# 방문 배열 순회가 끝나면 카운트 반환