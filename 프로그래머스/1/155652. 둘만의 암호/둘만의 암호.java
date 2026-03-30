class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();
        
        // 문자열 s의 각 문자를 하나씩 순회
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int step = 0; // 실제로 유효하게 이동한 횟수
            
            // index 횟수만큼 유효한 이동을 할 때까지 반복
            while (step < index) {
                c++; // 다음 알파벳으로 1칸 이동
                
                // 'z'를 넘어가면 'a'로 순환
                if (c > 'z') {
                    c = 'a';
                }
                
                // 이동한 문자가 skip에 포함되어 있지 않다면, 유효한 이동 횟수 증가
                // (포함되어 있다면 횟수를 증가시키지 않고 다음 루프에서 또 1칸 이동)
                if (!skip.contains(String.valueOf(c))) {
                    step++;
                }
            }
            
            // 이동이 완료된 문자를 정답에 추가
            sb.append(c);
        }
        
        return sb.toString();
    }
}

// 문자열의 문자 변환하기.
// cipher 암호화 문제
// 제약: 영어 소문자로만 구성, z보다 뒤면 다시 a로, skip 문자가 포함되면 해당 문자는 스킵하고 다음 문자 확인. 



