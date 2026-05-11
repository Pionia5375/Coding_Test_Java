class Solution {
    public int solution(int n) {
        
        int count = 0;
        
        // 연속한 수 2개 더해서 n이 되려면, 최대 반복 -> n / 2 + 1
        // 이차원 순회 -> 패턴 발견용
        for(int i = 1; i < n / 2 + 2; i++) {
            int tmp = i;
            // 이차원 순회 -> 더하는 용
            for (int j = i + 1; j < n / 2 + 2; j++) {
                // 두 요소를 더했을 때 > n이면 continue
                if (tmp + j > n) break;
                else if (tmp + j == n) { // 두 요소를 더했을 때 = n이면 카운트++ continue
                    count++;
                    break;
                } else tmp += j; // 두 요소를 더했을 때 < n이면 다음 요소 더하기
            }
        }
        
        return count + 1; // 본인 포함
    }
}

// 연속한 숫자끼리 더했을 때 n이 되는 경우의 수 구하기
// n은 자연수, 순회는 1부터
// 더했을 때 15가 되는 패턴 모두 더하기
// n은 10000 이하. 
