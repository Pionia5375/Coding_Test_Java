import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        
        // moves만큼 반복
        for (int i = 0; i < moves.length; i++) {
            
            // 열을 하나 정해서 행 인덱스 0부터 행의 길이 만큼 반복
            for (int row = 0; row < board.length; row++) {
                
                //해당 요소가 0이 아니면 해당 요소를 임시로 저장하기
                if (board[row][moves[i] - 1] != 0) {
                    
                    // 스택에 넣을 임시값 생성
                    int tmp = board[row][moves[i] - 1];
                    
                    // 푸시에 넣기 전에, 스택 맨 위의 값과 비교해서 같으면 팝을 하고 카운트 + 1 해야함.
                    if (!stack.isEmpty() && stack.peek() == tmp) {
                        stack.pop();
                        count += 2;
                    } else {
                        // 집어올린 값은 푸시에 집어넣어야 함.
                        stack.push(tmp);
                    }
                    
                    // 해당 위치를 0으로 만들기
                    board[row][moves[i] - 1] = 0;
                    
                    break;
                }
            }
        }
    return count;   
    }
}

// 인형이 없을 수도 있음


// board = 2차원 배열
// moves = 집어올린 열 


