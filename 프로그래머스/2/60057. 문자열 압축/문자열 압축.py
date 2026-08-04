def solution(s):
    
    # 압축하지 않은 경우
    answer = len(s)                          

    for unit in range(1, len(s) // 2 + 1):
        
        # 직전 조각
        prev = s[0:unit]
        
        # 그 조각이 연속으로 나온 횟수
        count = 1
        
        # 누적 압축 길이
        length = 0                           

        for i in range(unit, len(s), unit):
            cur = s[i:i+unit]

            if cur == prev:
                count += 1
            else:
                # 직전 조각을 여기서 확정
                length += unit + (len(str(count)) if count > 1 else 0)
                prev = cur
                count = 1

        # 마지막 조각은 반복문 안에서 확정되지 않으므로 밖에서 처리
        length += len(prev) + (len(str(count)) if count > 1 else 0)

        answer = min(answer, length)

    return answer

# 구하고자 하는 것: 압축 후 길이가 가장 짧은 문자열의 길이
# 제한: 문자열 길이 = 1000 이하, 소문자로만 이루어짐 -> O(n^2)까지 가능, 널널

# 압축 방법
# 압축을 한다면, 단위는 1 이상 (최소 압축률은 0. 패턴이 반복되지 않을 경우 존재.)
# 동일한 문자열이 반복해서 들어올 경우에 압축이 가능. 앞에 개수를 붙이고, 뒤에 중복되는 문자열을 삽입

# 동일한 문자열을 어떻게 체크할 것인가?
# 길이가 1000 이하이므로, 길이 / 2 만큼 순회 (Python 기준 연산 1000만회 ~~ 1초)
# 매 순회마다, 패턴 길이의 크기를 가지는 배열 2개 생성
# 첫번째 패턴을 그대로 배열 1에 저장
# 2번째 패턴부터 비교


