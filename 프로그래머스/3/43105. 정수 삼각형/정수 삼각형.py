def solution(triangle):
    
    for i in range(1, len(triangle)):
        for j in range(i + 1):
            if j == 0:
                triangle[i][j] += triangle[i - 1][0]
                
            elif j == i:
                triangle[i][j] += triangle[i - 1][i - 1]
                
            else:
                triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])
                
    return max(triangle[-1])

# 구하고자 하는 것: 거쳐간 숫자의 합의 최댓값
# 점화식
# i번째 합의 가장 큰 경우의 수: i - 1번째 합의 가장 큰 경우의 수 + 현재 행의 가장 큰 수
# 예외: 첫번째는 무조건 박음