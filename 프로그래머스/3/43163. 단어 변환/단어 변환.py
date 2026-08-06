from collections import deque

def solution(begin, target, words):
    def adjacent(a, b):
        return sum(x != y for x, y in zip(a, b)) == 1
    
    visited = set()
    queue = deque()
    queue.append((begin, 0))
    
    while queue:
        word, step = queue.popleft()
        if word == target:
            return step
        for w in words:
            if w not in visited and adjacent(word, w):
                visited.add(w)
                queue.append((w, step + 1))
    
    return 0

# 구하고자 하는 것: begin을 target으로 바꾸는 변환 과정의 최소값
# 입력: begin, target 문자열, 같은 글자수를 가진 문자열 배열
# 제약: 단어의 길이는 3 이상 10 이하, words의 길이는 3이상 50 이하, 중복 없음, 변환할 수 없는 경우 존재 -> 0 반환
# 접근: 최소값을 구해야 하고, 주어진 단어에서 한 단어씩 바꿔서 최종 답을 구해야 하므로, BFS로 구현 (DFS는 최소값 보장 X, 왜인지는 모름)
# 탐색을 하려면, 인접 노드가 무엇인지를 정의해야 함. 자신과 같은 글자를 하나만 가진 단어를 인접 노드라고 가정


