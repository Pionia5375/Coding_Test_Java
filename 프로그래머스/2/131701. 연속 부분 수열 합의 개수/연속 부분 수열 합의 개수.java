import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 모든 부분 수열의 합을 저장할 단일 HashSet 생성
        HashSet<Integer> set = new HashSet<>();
        
        int n = elements.length;
        
        for (int i = 0; i < n; i++) {
            // 부분 수열의 합
            int sum = 0; 
            
            // 부분 수열의 길이
            for (int j = 0; j < n; j++) {
                int idx = (i + j) % n;
                
                // 이전 길이까지의 합에 현재 원소만 추가로 더함
                sum += elements[idx];
                
                // 구해진 합을 set에 저장
                set.add(sum);
            }
        }
        
        return set.size();
    }
}