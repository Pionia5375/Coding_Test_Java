import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0; // 가입 가능한 날짜의 총 일수
        
        // 정답 해시맵을 생성: <원하는 물건, 수량>
        HashMap<String, Integer> answerMap = new HashMap<>();
        
        // 정답 해시맵에 값 할당
        for (int i = 0; i < want.length; i++) {
            answerMap.put(want[i], number[i]);
        }
        
        // 디스카운트 배열을 순회 (10일치 확인이 불가능한 마지막 9일은 제외)
        for (int i = 0; i <= discount.length - 10; i++) {
            
            // 매 10일 윈도우마다 임시 해시맵을 새로 생성하여 초기화
            HashMap<String, Integer> currentMap = new HashMap<>();
            
            // 10일치를 돌며, 임시 해시맵에 값 할당
            for (int j = i; j < i + 10; j++) {
                currentMap.put(discount[j], currentMap.getOrDefault(discount[j], 0) + 1);
            }
            
            // 정답 해시맵의 조건과 일치하는지 확인하기 위한 플래그
            boolean isMatch = true; // 플래그 달아놓기
            
            // 정답 해시맵의 키들을 순회
            for (String key : answerMap.keySet()) {
                // 임시 해시맵에 해당 제품이 없거나, 요구 수량보다 적게 할인한다면 조건 만족 x
                if (currentMap.getOrDefault(key, 0) < answerMap.get(key)) {
                    isMatch = false;
                    break;
                }
            }
            
            // 모든 조건을 만족했다면 정답(가능한 날짜 수) 1 증가
            if (isMatch) {
                answer++;
            }
        }
        
        return answer;
    }
}

// 일정 금액 지출 -> 회원 자격 10일동안 부여 -> 회원 대상 제품 하나 할인, 하루에 하나만 구매 가능
// 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치하는 경우에 맞춰서 회원가입