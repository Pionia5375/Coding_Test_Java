import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);
        
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        String result = String.join("", strNumbers);
        
        if (strNumbers[0].equals("0"))
            return "0";
        
        return result;
    }
}
