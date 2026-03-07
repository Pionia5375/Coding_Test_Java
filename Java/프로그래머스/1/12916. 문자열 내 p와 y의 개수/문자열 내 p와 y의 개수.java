class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        int cntP = 0;
        int cntY = 0;
        
        String refinedString = s.toLowerCase();
        char[] charArray = refinedString.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'p')
                cntP++;
            else if (charArray[i] == 'y')
                cntY++;
        }
        
        if (cntP == cntY)
            answer = true;
        
        return answer;
    }
}