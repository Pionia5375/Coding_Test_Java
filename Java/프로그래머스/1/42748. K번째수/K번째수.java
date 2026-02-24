class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int kIdx = commands[i][2] - 1;
            
            int[] newArray = new int[end - start + 1];
            for (int j = start - 1, k = 0; j < end; j++, k++) {
                newArray[k] = array[j];
            }
            
            for (int m = 0; m < newArray.length - 1; m++) {
                for (int n = newArray.length - 1; n > m; n--) {
                    if (newArray[n - 1] > newArray[n]) {
                        int tmp = newArray[n - 1];
                        newArray[n - 1] = newArray[n];
                        newArray[n] = tmp;
                    }
                }
            }  
            answer[i] = newArray[kIdx];
        }
        return answer;
    }
}