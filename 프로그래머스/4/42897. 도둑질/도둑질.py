def solution(money):
    def rob(houses):
        prev, curr = 0, 0  # prev = dp[i-2], curr = dp[i-1]
        for m in houses:
            prev, curr = curr, max(curr, prev + m)
        return curr

    return max(rob(money[:-1]), rob(money[1:]))


# 인접한 집은 털 수 없음
# 도둑이 훔칠 수 있는 돈의 최댓값
# 입력: 각 집마다의 보유 돈
# 출력: 돈의 최댓값

# 어떻게하면 인접한 집을 피하면서 최대한 많은 돈을 털 수 있을까?

# 돈의 최댓값 != 털 수 있는 집의 수

# 점화식
# 현재 벌 수 있는 돈의 최댓값 = 털 기 전의 돈의 최댓값 + 인접하지 않은 노드들 중의 돈의 최댓값

# 현재 인덱스 기준으로 회전 필요
# 마지막 노드 인덱스와 0은 서로 인접
