import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int deletedZeros = 0;
        int binaryCount = 0;
        
        // 아래 과정을 결과가 "1"이 될 때까지 반복
        while (!s.equals("1")) {
            int originalLength = s.length();
            int replacedLength = s.replace("0", "").length();
            
            deletedZeros += originalLength - replacedLength;
            s = Integer.toBinaryString(replacedLength);
            
            binaryCount++;
        }
        
        int[] answer = {binaryCount, deletedZeros};
        return answer;
    }
}



