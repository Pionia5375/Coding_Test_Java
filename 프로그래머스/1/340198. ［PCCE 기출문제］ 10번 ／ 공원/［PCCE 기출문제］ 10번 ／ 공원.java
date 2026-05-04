import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        // DP 테이블 선언 (park와 동일한 크기)
        int[][] dp = new int[rows][cols];
        int maxSquareSize = 0; // 공원 내에서 만들 수 있는 가장 큰 정사각형의 길이

        // 1. 공원 전체를 한 번만 순회하며 DP 테이블 채우기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 현재 위치가 빈 공간(-1)인 경우에만 계산
                if (park[i][j].equals("-1")) {
                    // 맨 윗줄이거나 맨 왼쪽 줄은 더 이상 확장할 수 없으므로 무조건 크기 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 핵심 점화식: (왼쪽, 위쪽, 대각선 좌측 상단) 중 최솟값 + 1
                        int minTopLeft = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(minTopLeft, dp[i - 1][j - 1]) + 1;
                    }
                    // 여태까지 찾은 정사각형 중 가장 큰 값 갱신
                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
                }
            }
        }

        // 2. 내가 가진 돗자리(mats) 중 가능한 가장 큰 크기 찾기
        Arrays.sort(mats);
        int answer = -1;
        
        // 오름차순 정렬되었으므로 뒤에서부터(가장 큰 것부터) 확인
        for (int i = mats.length - 1; i >= 0; i--) {
            // 돗자리 크기가 공원의 최대 정사각형 크기보다 작거나 같다면 설치 가능
            if (mats[i] <= maxSquareSize) {
                answer = mats[i];
                break; // 가장 큰 걸 찾았으니 바로 종료
            }
        }

        return answer;
    }
}


