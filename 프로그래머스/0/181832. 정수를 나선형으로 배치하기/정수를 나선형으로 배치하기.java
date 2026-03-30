class Solution {
    public int[][] solution(int n) {
        // n x n 배열 0으로 초기화
        int[][] answer = new int[n][n];
        
        // 행 인덱스 row와, 열 인덱스 col 0으로 초기화
        int i = 0;
        int j = 0;
        
        // 정수를 2부터 카운트
        int num = 2;
        answer[i][j] = 1;
        
        boolean isContinue = true;
        
        while (isContinue && answer.length > 1) {
            // 열 인덱스를 늘려가면서 끝에 다다르거나, 앞에 방문한 요소가 있으면 행 인덱스를 늘리기 시작
            while (j < n - 1 && answer[i][j + 1] == 0) {
                j++;
                answer[i][j] = num++;
                // 첫 시도에 늘릴 수 없다면, 방문 종료
                if (answer[i + 1][j] != 0) {
                    isContinue = false;
                    break;
                }
            }
            
            // 행 인덱스를 늘려가면서 끝에 다다르거나, 앞에 방문항 요소가 있으면 열 인덱스를 줄이기 시작
            while (i < n - 1&& answer[i + 1][j] == 0) {
                i++;
                answer[i][j] = num++;
                // 첫 시도에 늘릴 수 없다면, 방문 종료
                if (answer[i][j - 1] != 0) {
                    isContinue = false;
                    break;   
                }
            }
            
            // 열 인덱스를 줄여가면서 끝에 다다르거나, 앞에 방문한 요소가 이있으면 행 인덱스를 줄이기 시작
            while (j > 0 && answer[i][j - 1] == 0) {
                j--;
                answer[i][j] = num++;
                // 첫 시도에 늘릴 수 없다면, 방문 종료
                if (answer[i - 1][j] != 0) {
                    isContinue = false;
                    break;
                }
            }
            
            // 행 인덱스를 줄어가면서 끝에 다다르거나, 앞에 방문한 요소가 있으면 열 인덱스를 늘리기 시작
            while (i > 0 && answer[i - 1][j] == 0) {
                i--;
                answer[i][j] = num++;
                // 첫 시도에 늘릴 수 없다면, 방문 종료
                if (answer[i][j + 1] != 0) {
                    isContinue = false;
                    break;   
                }
            }
        }
        return answer;
    }
}











// 방향 전환을 했을 때, 앞에 요소가 방문했다면 방문 종료. 결과 리턴