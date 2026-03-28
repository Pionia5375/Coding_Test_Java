import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        int remained = budget;
        int count = 0;
        
        for (int i = 0; i < d.length; i++) {
            if (remained - d[i] < 0) break;
            remained -= d[i];
            count++;
        }
        
        return count;
    }
}

// 최대한 많은 부서의 물품 구매
// 신청한 금액 정확히 지원.
// 전체 금액 