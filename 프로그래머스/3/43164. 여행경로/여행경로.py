def solution(tickets):
    n = len(tickets)
    tickets.sort()
    visited = [False] * n
    answer = []
    
    def dfs(airport, path):
        if len(path) == n + 1:
            answer.append(path)
            return True
        
        for i, (a, b) in enumerate(tickets):
            if not visited[i] and a == airport:
                visited[i] = True
                if dfs(b, path + [b]):
                    return True
                visited[i] = False
        return False
    
    dfs("ICN", ["ICN"])
    
    return answer[0]

# 구하고자 하는 것: 공항을 모두 방문하는 여행 경로
# 입출력: 2차원 배열 티켓: 출발 공항 -> 도착 공항, 출력: 경유 공항을 순서대로 담은 문자열 배열
# 접근: 완전 탐색이 필요한 경우. 가능한 모든 시나리고 고려 후에, 마지막에 알파벳순으로 앞서는 배열이 최종 답. -> DFS 완전 탐색

# 알고리즘
# 티켓 배열 정렬
# 티켓 배열을 파싱해 인접 리스트 그래프를 생성
# visted 배열 생성 (불리언)
# 정답 배열을 담는 2차원 배열 생성 
# DFS 실행, ICN을 첫번째로. 모두 방문이 가능한 경우의 수 모두 2차원 배열에 넣기
# 가장 앞의 리스트 반환

