class Solution {
    public int solution(int n, int w, int num) {  // n: 상자의 개수, w: 가로로 놓는 상자의 수, num: 꺼내려는 상자의 번호
  
        // 1. 22개를 6으로 나누면 몫이 3이고 나머지가 4. -> 총 층수는 4에 마지막 인덱스는 3
        // 2. 3의 인덱스는 arr[0][2]. 빼려면 arr[3][3], arr[2][2], arr[1][3]를 빼야 함.
        // 3. 이차원 배열에서의 key값의 위치를 알 때, 빼야 하는 상자의 개수: (최고행 - 현재 행 + 1)  
        // 4. 최고행이 현재행과 모두 같이 홀수 혹은 짝수라면, 인덱스는 동일
        // 5. 최고행과 현재행이 각각 홀수와 짝수라면, 인덱스는 (길이 - 인덱스)
        
        // 배열의 높이와 나머지 구하기
        int row;
        int remain;
        if (n % w != 0) {
            row = n / w + 1;
            remain = n % w;
        } else {
            row = n / w;
            remain = 0;
        }
        
        // 이중 배열 생성
        int[][] arr = new int[row][w];
        int k = 1;
        
        for (int i = 0; i < row && k <= n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w && k <= n; j++)
                    arr[i][j] = k++;
            }
            else {
                for (int j = w - 1; j >= 0 && k <= n; j--)
                    arr[i][j] = k++;
            }
        }
        
        // num의 인덱스 확정
        int resRow = 0;
        int resCol = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == num) {
                    resRow = i;
                    resCol = j;
                } 
            }
        }
        
        // 개수 판별
        int answer = 1;
        int cC = resCol;
        
        for (int cr = resRow; cr < row - 1; cr++) {
            if (arr[cr + 1][cC] == 0) 
                break;
            else {
                answer++;
            }
        }
        
        return answer;
    }
}