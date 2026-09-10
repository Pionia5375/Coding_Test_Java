def solution(numbers):
    answer = [-1] * len(numbers)
    stack = []

    for i, num in enumerate(numbers):
        while stack and numbers[stack[-1]] < num:
            answer[stack.pop()] = num
        stack.append(i)

    return answer

# 스택을 써서 처음 값 집어넣기
# enumerate 써서 인덱스랑 넘버 같이 사용하기