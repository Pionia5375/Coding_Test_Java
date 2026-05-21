import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // 캐시 크기가 0인 경우 예외 처리
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int time = 0;
        
        // 우선순위 큐와 해시셋 초기화 
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        
        // 모든 도시 순회
        for (int i = 0; i < cities.length; i++) {
            
            String currentWord = cities[i].toLowerCase();
            
            // 한 도시를 확인할 때마다 해시셋에 해당 도시가 있는지 확인
            if (set.contains(currentWord)) {
                // 있다면 실행시간 + 1
                time++;
            
                queue.remove(currentWord);
                queue.add(currentWord);
                
                continue;
            } else { 
                // 없다면 실행시간 + 5
                time += 5;
                
                // 셋 사이즈가 캐시 사이즈보다 작을 경우, 그냥 add
                if (queue.isEmpty() || set.size() < cacheSize) {
                    queue.add(currentWord);
                    set.add(currentWord);
                } else {
                    // 캐시가 꽉 찼다면 가장 오래된 것(큐의 맨 앞)을 뽑고 셋에서도 제거
                    String prior = queue.poll();
                    set.remove(prior);
                    
                    // 새로운 단어 큐와 셋에 추가
                    queue.add(currentWord);
                    set.add(currentWord);
                }
            }
        }
        return time;
    }
}

// 매턴 캐시 리스트에 해당 도시가 있는 경우
// 캐시 히트: 시간++ 다음 요소 확인
// 매턴 캐시 리스트에 해당 도시가 있는 경우
// 캐시 미스: 시간 + 5, 가장 오래된 캐시를 해당 도시로 변경

// 필요한 자료구조
// 매턴 모든 요소에 접근 가능해야 하며, 각 요소는 들어온 시간에 대한 우선순위를 가진다.
// 자동으로 우선순위가 관리되면 좋음.
// 우선순위 큐..? -> 전체 메모리는 어떻게 확인할 것인가? -> 해시셋도 함께 이용? 매 턴 contains와 size로 확인?



// 우선순위 큐에 값이 있다면, 가장 앞의 값을 poll하고, 새 도시를 add