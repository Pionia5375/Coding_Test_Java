import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 종류 개수, 담은 개수 변수 초기화
        int sort = 0;
        int amount = 0;
        
        // 각 크기에 대한 개수 값 카운트 해두기
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // 크기 개수 값 최대값 구하기
        List<Integer> valueList = new ArrayList<>(map.values()); // (안에는 실제로 담길 값들이 들어감.)
        valueList.sort(Collections.reverseOrder()); // sort의 () 안에는 옵션이 들어감.

        // 3. 담은 개수 < k일 때까지 반복
        for (int i = 0; i < valueList.size(); i++) {
            amount += valueList.get(i);
            sort++;
            
            // 담은 개수가 k 이상이 되면 루프 종료
            if (amount >= k) break;
        }
        
        // 종류 개수 리턴
        return sort;
    }
}


