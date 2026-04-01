class Solution {
    public String solution(String X, String Y) {
        // 0부터 9까지 각 숫자의 개수를 저장할 배열 2개 생성
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // X의 각 숫자 개수 카운트
        for (int i = 0; i < X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }
        
        // Y의 각 숫자 개수 카운트
        for (int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 가장 큰 조합을 찾기 위해 9부터 0까지 내림차순 순회
        for (int i = 9; i >= 0; i--) {
            // 두 배열을 비교하여 더 낮은 카운트를 선택 
            int minCount = Math.min(countX[i], countY[i]);
            
            // 해당 요소의 카운트만큼 나열하여 StringBuilder에 추가
            for (int j = 0; j < minCount; j++) {
                sb.append(i);
            }
        }
        
        // 예외 처리
        String answer = sb.toString();
        
        // 공통된 숫자가 전혀 없는 경우
        if (answer.isEmpty()) {
            return "-1";
        }
        
        // 공통된 숫자가 0으로만 구성된 경우 ("00", "000" 등으로 시작하면 "0"만 반환)
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}

// 두 정수에서 동시에 존재하는 숫자들을 조합하여 만들 수 있는 가장 큰 숫자 구하기
// 개수가 중요함. 같은 숫자라고 하더라도, 개수가 불일치하면 카운트가 적은 개수를 사용

// 어떻게 동시에 존재함을 확인할 것인가?
// 해시맵을 2개 만들기? -> X에 대한 해시맵, Y에 대한 해시맵?
// 해시맵을 하나 만들기? -> 길이가 긴 쪽으로 해시맵을 만들고, 짧은 쪽으로 확인?
// 0부터 9까지 배열 2개 만들기

// 어떻게 개수를 비교할까?
// 두 배열을 순회하며 해당 요소 카운트 증가
// 순회 끝나면 두 배열을 비교하며 더 낮은 카운트로 배열 설정
// 모든 카운트 0일 경우, "-1" 반환

// 어떻게 가장 큰 조합을 찾을 것인가?
// 가장 큰 숫자의 요소부터 내림차순 순회 -> 해당 요소의 카운트만큼 나열
// 스트링 빌더로 스트링 생성 -> 반환