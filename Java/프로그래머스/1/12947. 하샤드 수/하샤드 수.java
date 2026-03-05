class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String xString = Integer.toString(x) ;
        char[] xCharArr = xString.toCharArray();
        
        int sum = 0;
        
        for (int i = 0; i < xCharArr.length; i++) {
            int num = xCharArr[i] - '0';
            sum += num;
        }
        
        if (x % sum != 0)
            answer = false;
            
        return answer;
    }
}