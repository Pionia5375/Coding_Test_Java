class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String arr = String.valueOf(n);
        char[] charArr = arr.toCharArray();
        
        for (int i = 0; i < charArr.length - 1; i++) {
            for (int j = charArr.length - 1; j > i; j--) {
                if (charArr[j] > charArr[j - 1]) {
                    char tmp = charArr[j];
                    charArr[j] = charArr[j - 1];
                    charArr[j - 1] = tmp;
                }
            }    
        }
        
        String sortedStr = new String(charArr); 
        answer = Long.parseLong(sortedStr);
        
        return answer;
    }
}