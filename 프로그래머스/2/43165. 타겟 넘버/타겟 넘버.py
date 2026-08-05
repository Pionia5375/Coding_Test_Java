def solution(numbers, target):
    def dfs(idx, total):
        
        if idx == len(numbers):
            return 1 if total == target else 0
        
        return dfs(idx + 1, total + numbers[idx]) + dfs(idx + 1, total - numbers[idx])
    
    return dfs(0, 0)

# 구하고자 하는 것: 주어진 숫자를 더하거나 빼서 타겟 숫자를 만들 수 있는 경우의 수 구하기
# 완전 탐색으로 접근
# 종료조건: 마지막 인덱스 방문
# 카운트 증가 조건: 마지막 인덱스까지 다 계산했을 때, 타겟 넘버가 될 경우
# 일단 마지막 인덱스까지 우선 다 더하고, 타겟이랑 다를 경우에는 그 전으로 돌아가서 빼기 시도

