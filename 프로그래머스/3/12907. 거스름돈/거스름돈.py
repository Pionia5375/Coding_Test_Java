def solution(n, money):
    
    dp = [1] + [0] * (n)
    
    for m in money:
        for i in range(m,n+1):
            dp[i] += dp[i - m]
            
    return dp[n % 1000000007]


# 입력: 거슬러줄 돈 n, 화페 배열 money
# 구하고자 하는 것: n원을 거슬러줄 방법의 수

# 모든 경우의 수 구하기
# 그리디 x. n이 100,000이하이고, money 배열이 100종류 이ㅎ이기 때문.

# DP로 접근?
# 점화식?
# 큰 문제를 작은 문제로 해결 가능?
# money [1, 2, 5] n = 4
# 1, 1, 1, 1, 1
# 1, 2, 1, 1
# 1, 2, 2
# 5
# 순서는 상관 x

# 한 축을 money로 두고 한 축을 n으로 둔다? 