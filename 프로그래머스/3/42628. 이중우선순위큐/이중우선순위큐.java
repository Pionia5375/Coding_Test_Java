import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        // 이중 우선순위 큐 생성
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 정답 배열 생성
        int[] answer = new int[2];
        
        // 오퍼레이션에 모든 값을 처리할 때까지 반복
        for (int i = 0; i < operations.length; i++) {
            // 값을 파싱
            String[] arr = operations[i].split(" ");
            String OperationType = arr[0];
            int value = Integer.parseInt(arr[1]);
            
            // 오퍼레이션 객체의 타입이 'I'인 경우, 모든 큐에 객체 삽입
            if (OperationType.equals("I")){
                minQueue.add(value);
                maxQueue.add(value);
            }
            
            // 오퍼레이션 객체의 타입이 'D'이고, 모든 큐에 객체가 1개 이상 있을 경우, 밸류를 비교
            if (OperationType.equals("D") && !minQueue.isEmpty() && !maxQueue.isEmpty()) {
                // 밸류가 1일 경우, 큰수 우선순위 큐 poll, 작은수 우선순위 큐 remove(큰 수 우선순위 큐 poll 값)
                // 밸류가 -1일 경우, 작은수 우선순위 큐 poll, 큰수 우선순위 큐 remove(작은 수 우선순위 큐 poll 값)
                if (value == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
                else if (value == -1) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
            
        }
        
        // 반복이 끝나면, 정답 배열에 최대값과 최소값 할당 및 반환 
        if (minQueue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        
        return answer;
    }
}