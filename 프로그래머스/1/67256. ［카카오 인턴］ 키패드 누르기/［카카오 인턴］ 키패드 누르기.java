class Solution {
    public String solution(int[] numbers, String hand) {
        
        // 키패드 배열 4 x 3 생성
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 0, 11}};
        
        StringBuilder sb = new StringBuilder();
        
        // 시작 위치
        int currentLeftRow = 3;
        int currentLeftCol = 0;
        int currentRightRow = 3;
        int currentRightCol = 2;
        
        for (int i = 0; i < numbers.length; i++) {
            
            // 1, 4, 7인 경우
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append('L');
                // 왼쪽 손가락 위치 업데이트
                currentLeftRow = (numbers[i] - 1) / 3; 
                currentLeftCol = 0;
            }
            // 3, 6, 9인 경우
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append('R');
                // 오른쪽 손가락 위치 업데이트
                currentRightRow = (numbers[i] / 3) - 1; 
                currentRightCol = 2;
            }
            // 2, 5, 8, 0인 경우
            else {
                int numRow = 0;
                int numCol = 0;
                
                // 해당 번호의 위치(인덱스) 찾기
                Loop1:
                for (int row = 0; row < keypad.length; row++) {
                    for (int col = 0; col < keypad[row].length; col++) {
                        if (keypad[row][col] == numbers[i]) {
                            numRow = row;
                            numCol = col;
                            break Loop1;
                        }
                    }
                }
                
                // Math.abs()를 사용하여 거리 계산
                int leftDistance = Math.abs(currentLeftRow - numRow) + Math.abs(currentLeftCol - numCol);
                int rightDistance = Math.abs(currentRightRow - numRow) + Math.abs(currentRightCol - numCol);
                
                // 거리가 가까운 쪽, 같다면 주 사용 손 판별
                if (rightDistance < leftDistance) {
                    sb.append('R');
                    currentRightRow = numRow;
                    currentRightCol = numCol;
                } else if (leftDistance < rightDistance) {
                    sb.append('L');
                    currentLeftRow = numRow;
                    currentLeftCol = numCol;
                } else {
                    if (hand.equals("right")) {
                        sb.append('R');
                        currentRightRow = numRow;
                        currentRightCol = numCol;
                    } else {
                        sb.append('L');
                        currentLeftRow = numRow;
                        currentLeftCol = numCol;
                    }
                }
            }   
        }
        return sb.toString();
    }
}

// 입력: 누를 번호들, 거리가 같을 경우 우선할 손
// 출력: 누를 손 배열
// 현재 위치로부터 거리를 어떻게 구할 것인가? -> 2차원 배열을 만들어서, 행과 열 인덱스의 차를 구하기.


