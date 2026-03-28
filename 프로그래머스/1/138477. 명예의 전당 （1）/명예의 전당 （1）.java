import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int[] mins = new int[score.length];
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        int minScore = 0;
        
        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            
            if (i < k) {
                minScore = queue.peek();
                mins[i] = minScore;    
            } else {
                queue.poll();
                minScore = queue.peek();
                mins[i] = minScore;
            }
        }
        return mins;
    }
}

// 목표: 최하위 점수 배열 리턴
// score와 동일한 크기의 배열을 만들어 리턴
// 오름차순 우선순위 큐를 생성
// k번째까지 모든 값을 큐에 add
// 발표 점수는 큐 peek();
// k + 1부터 발표 점수를 poll 값으로 할당하고, 새로운 값 add()