class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // arr1의 모든 행을 순회하며 행렬 곱셈 수행
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int val = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    val += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = val;
            }
        }
        return answer;
    }
}
