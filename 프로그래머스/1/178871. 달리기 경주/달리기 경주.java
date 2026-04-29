import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // 해시맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 해시맵에 선수 이름 - 등수 매칭
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            
            int callingIdx = map.get(callings[i]);
            int currentFrontIdx = callingIdx - 1;
            
            String tmp = players[currentFrontIdx];
            players[currentFrontIdx] = players[callingIdx];
            players[callingIdx] = tmp;
            
            map.put(players[currentFrontIdx], currentFrontIdx);
            map.put(players[callingIdx], callingIdx);
        }
    
        
        return players;
    }
}

// 추월할 때 이름 불림
// 이름 불리면 앞 선수와 자리 바꿈
// 등수순 players와 해설진이 부른 이름 배열이 주어졌을 때, 최종 순위 배열 반환

// 이름이 불렸다는 건, 기존에 앞 사람이 있었다는 것. 추월 가능할 때만 불림.
// 이름이 불렸을 때 인덱스가 나와야 함.
// 인덱스로 이름을 찾을 수 있어야 함. 
