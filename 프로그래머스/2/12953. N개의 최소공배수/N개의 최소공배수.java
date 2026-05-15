class Solution {
    public int solution(int[] arr) {
        
        int lcm = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            lcm = lcm(arr[i], arr[i + 1]);
            arr[i + 1] = lcm;
        }
        
        return lcm;
        
    }
    
    public int lcm(int a, int b) {
        int A = a;
        int B = b;
        
        while (A != B) {
            if (A > B) {
                B += b;
            } else {
                A += a;
            }
        }
        
        return A;
    }
}