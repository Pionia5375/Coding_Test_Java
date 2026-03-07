class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] numTable = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int i = 0; i < numbers.length; i++) {
            if (numTable[numbers[i]] == numbers[i])
                numTable[numbers[i]] = 0;
        }
        
        for (int i = 0; i < numTable.length; i++) {
            answer += numTable[i];
        }
        
        return answer;
    }
}