import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String stringN = Integer.toString(n);
        char[] charArrN = stringN.toCharArray();
        
        for (int i = 0; i < charArrN.length; i++)
            answer += charArrN[i] - '0';

        return answer;
    }
}