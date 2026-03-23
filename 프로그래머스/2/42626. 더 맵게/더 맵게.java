import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // 우선순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        // 정수형 변수 턴을 0으로 초기화
        int turn = 0;
        int mix = 0;
        
        // 스코빌 배열의 요소를 모두 우선순위 큐에 넣기
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
    
        // 우선순위 큐의 맨 앞 요소가 K 이상이 될 때까지 반복
        while(queue.peek() < K) {
            turn++;
            
            // 큐의 맨 앞의 값을 조합 스코빌에 더함
            int first = queue.poll();
            
            // 첫번째 값만 존재하고, 그 값이 K미만일 경우 -1 반환
            if (mix < K && queue.isEmpty())
                return -1;
            
            // 두번째 값 * 2를 조합 스코빌에 더함
            int second = queue.poll();
            
            // mix값을 큐에 추가
            queue.add(first + second * 2);
            
            // mix값을 초기화
            mix = 0;
        }
        return turn;
    }
}