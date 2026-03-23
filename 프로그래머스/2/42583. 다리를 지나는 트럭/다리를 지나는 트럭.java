import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 중량과 진입 시간을 속성으로 하는 객체를 요소로 하는 큐 생성
        Queue<Truck> queue = new LinkedList<>();
        
        // 시간 카운트, 트럭 무게 합, 트럭 배열의 인덱스를 0으로 초기화
        int time = 0;
        int totalWeight = 0;
        int i = 0;
        
        // 대기 트럭의 배열과 큐에 아무런 요소가 없을 때까지
        while (i < truck_weights.length || !queue.isEmpty()) {
            
            // 시간 카운트 + 1    
            time += 1;
            
            // 트럭의 길이 = 현재 시간 - 진입시간이면, 큐 poll, 전체 트럭 중량 감소
            if (!queue.isEmpty() && bridge_length == time - queue.peek().enterTime) {
                totalWeight -= queue.peek().weight;
                queue.poll();
                 
            }
            
            // 대기 배열에 아직 트럭이 남아 있고, 전체 트럭 중량 + 큐에 넣고자 하는 요소가 최대중량을 넘어가는지 체크
            // 넘어가지 않는다면, 큐에 + 대기 트럭 배열의 첫번째 요소 + 1, 진입 시간을 현재 시간으로 설정 
            if (i < truck_weights.length && weight >= totalWeight + truck_weights[i]) {
                queue.add(new Truck(time, truck_weights[i]));
                totalWeight += truck_weights[i];
                i++;
            }
        }
        return time;
    }
    
    // 트럭 객체 정의
    public class Truck {
        int enterTime;
        int weight;
        
        public Truck (int enterTime, int weight) {
            this.enterTime = enterTime;
            this.weight = weight;
        }
    }
}