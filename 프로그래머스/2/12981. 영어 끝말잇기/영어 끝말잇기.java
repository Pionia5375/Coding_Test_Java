import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        // 0. 중복 확인용 해시셋 생성
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        
        char lastLetter = words[0].charAt(words[0].length() - 1);
        
        // 1. words를 모두 다 돌고 이상 없으면 그대로 [0, 0] 리턴
        for (int i = 1; i < words.length; i++) {
            
            // 2. words를 순회하며, 이전 단어의 끝 문자를 기억해두고, 현재 단어의 첫 문자와 비교
            char currentLetter = words[i].charAt(0);
            
            // 4. 게임 오버 시, 해당하는 플레이어의 차례 수를 리턴
            if (set.contains(words[i]) || lastLetter != currentLetter) {
                
                // 차례 수 구하기: 인덱스를 n으로 나눈 몫 + 1: 차례, n으로 나눈 나머지 + 1: 번호
                int player = i % n + 1;
                int turn = i / n + 1;
                
                int[] res = {player, turn};
                
                return res;
                
            } else {
                // 3. 매 순회 마다, 해시셋에 해당 값이 있는지 확인하고, 없으면 추가하는 로직 추가
                set.add(words[i]);
                lastLetter = words[i].charAt(words[i].length() - 1);;
            }
        }
        
        int[] res = {0, 0};
        
        return res;
    }
}

// 주어진 변수: 사람의 수 n, 끝말잇기 단어들
// 리턴 값: 몇번째 사람이 자신의 몇번째 차례에 탈락했는지를 정수 배열로 리턴
// 리턴 케이스: 1. 모두 잘 말했을 경우, 2. 첫 문자가 이전 끝 문자와 불일치할 경우, 3. 이전에 등장했던 단어를 사용할 경우.



