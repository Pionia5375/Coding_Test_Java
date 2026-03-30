import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // N의 크기를 가진 정답 배열 생성
        Stage[] failureRatios = new Stage[N];
        
        // 1부터 N 까지 반복
        for (int i = 0; i < N; i++) {
            
            int currentStage = i + 1;
            
            // 도전자 수 0으로 초기화, 실패자 수 0으로 초기화 
            int challengers = 0;
            int failures = 0;
            double failureRatio = 0.0;
            
            // 매 반복 시마다 스테이지 배열 배열 순회, 플레이어 스테이지가 현재 스테이지보다 작으면 도전 x
            for (int j = 0; j < stages.length; j++) {                
                if (stages[j] == currentStage) { // 같으면 도전자 수 + 1, 실패자 수 + 1
                    challengers++;
                    failures++;
                }
                else if (stages[j] > currentStage) challengers++; // 크면 도전자 수 + 1
            }
            // 배열 순회가 끝나면 (실패자 수 / 도전자 수)를 정답 배열에 추가
            if (challengers == 0) {
                failureRatio = 0;    
            }
            else {
                failureRatio = (double) failures / challengers;    
            }
            
            failureRatios[i] = new Stage(currentStage, failureRatio);
        }
        
        // 배열 정렬
        Arrays.sort(failureRatios, (o1, o2) -> {
            if (o1.failureRatio == o2.failureRatio) return o1.idx - o2.idx;
            return Double.compare(o2.failureRatio, o1.failureRatio);
        });
        
        int[] answer = new int[N];
        
        for (int i = 0; i < failureRatios.length; i++) {
            answer[i] = failureRatios[i].idx;
        }
        
        // 정답 배열 반환
        return answer;
    }
}


// 스테이지 객체 정의
class Stage {
    int idx;
    double failureRatio;
    
    public Stage(int idx, double failureRatio) {
        this.idx = idx;
        this.failureRatio = failureRatio;
    }
}

// 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 입력: 전체 스테이지의 수 N, 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
// 출력: 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열, 실패율이 같다면 작은 번호가 앞에











