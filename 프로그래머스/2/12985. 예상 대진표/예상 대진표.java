class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer;
        
        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}

// 만나는 조건을 어떻게 확인할 것인가?
// 이진 트리
// 총 인원 -> N
// N개의 배열로 인식 -> 점차 줄여가기
// 왼쪽 자식의 부모 노드