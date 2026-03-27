class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 총합: 갈색 노란색 더함
        int totalLength = brown + yellow;
        
        // 정수형 변수 가로, 세로 초기화
        int width = 0;
        int height = 0;
        
        // i < 전체길이 / 2 동안
        for (int i = 3; i * i <= totalLength; i++) {
            
            // i >= 3이고, 총합 % i == 0이면 -> i = num1, 총합 / i = num2
            if (totalLength % i == 0) {
                height = i;
                width = totalLength / i;
                
                if ((width - 2) * (height - 2) == yellow) break;
            }
        }
        
        // 크기 2짜리 배열에 num2, num1 할당 및 반환.
        return new int[]{width, height};
    }
}





