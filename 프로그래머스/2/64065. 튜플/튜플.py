from collections import Counter

def solution(s):
    stack = []
    num_list = []

    for char in s:
        if char == '}' or char == ',':
            num_string = ""
            while stack[-1] != '{' and stack[-1] != ',':
                num_string = stack.pop() + num_string
            if num_string:
                num_list.append(int(num_string))
        else:
            stack.append(char)

    count = Counter(num_list)
    return [num for num, _ in count.most_common()]

    
# s의 길이: 1,000,000 이하 -> 전부 탐색 어려움
# 튜플을 사용해서, 중복을 제외한 모든 숫자를 배열에 담아 리턴하기

# 숫자 파싱: 뒤에 콤마가 나오거나, }가 나올 경우 -> 스택을 사용해서 숫자가 안나올 때까지 뽑아서 문자열 추가 -> int 변환
# 전체 문자열 순회 -> 스택으로 처리 -> 숫자 배열 만들기 -> set 함수로 중복 수 제거.