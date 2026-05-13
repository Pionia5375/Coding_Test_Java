import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        // N과 number가 같으면 N을 1번 사용하여 만든 것이므로 1 리턴
        if (N == number) {
            return 1;
        }

        // dp[i]는 N을 i번 사용해서 만들 수 있는 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        
        // 인덱스를 1부터 8까지 직관적으로 쓰기 위해 9개의 Set을 추가 (0번 인덱스는 더미)
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // dp[1] 초기화
        dp.get(1).add(N);

        // N을 2번 쓰는 경우부터 8번 쓰는 경우까지 탐색
        for (int i = 2; i <= 8; i++) {
            Set<Integer> currentSet = dp.get(i);
            
            // 1. N을 연속해서 이어 붙인 수 추가 (예: 55, 555, 5555...)
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(N);
            }
            currentSet.add(Integer.parseInt(sb.toString()));

            // 2. 사칙연산 조합 추가 (dp[j] 연산 dp[i-j])
            for (int j = 1; j < i; j++) {
                int k = i - j; // i개를 만들기 위해 j개짜리 집합과 k개짜리 집합을 연산
                
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        // 0으로 나누는 경우 방지
                        if (num2 != 0) {
                            currentSet.add(num1 / num2);
                        }
                    }
                }
            }

            // 3. 현재 횟수(i)로 만든 숫자들 중에 number가 있다면 바로 i 반환
            if (currentSet.contains(number)) {
                return i;
            }
        }

        // 8번까지 해봤는데도 number를 못 만들었다면 -1 반환
        return -1;
    }
}