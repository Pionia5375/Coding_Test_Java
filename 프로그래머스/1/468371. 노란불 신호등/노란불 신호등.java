class Solution {
    // 최대 공약수 구하기
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 최소 공배수 구하기
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    
    public int solution(int[][] signals) {
        long limit = 1;
        
        // 탐색 제한 범위 설정
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            limit = lcm(limit, cycle);
        }
        
        for (int t = 1; t <= limit; t++) {
            boolean allYellow = true;
            
            for (int[] s : signals) {
                int g = s[0], y = s[1], r = s[2];
                int cycle = g + y + r;
                int rem = (t - 1) % cycle;
                
                // 노란불 상태인지 검사
                if (rem < g || rem >= g + y) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
        }
        
        return -1;
    }
}

// 3 ~ 5, 10 ~ 12, 17 ~ 19, 24 ~ 26
// 4, 11, 18
// 3, 7, 11, 15

// integer-integer 해시맵을 만들어서, 노란 불일 때의 수, 스트링에는 겹친 개수를 저장
// 검사하는 순서를 어떻게 가져갈 것인가?
// 