import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int len = (int)(right - left + 1);
        int[] arr = new int[len];
        int idx = 0;
        
        for (long i = left; i < right + 1; i++) {
            long row = i / n;
            long col = i % n;
            
            arr[idx++] = (int) Math.max(row, col) + 1;
        }
        
        return arr;
    }
}


