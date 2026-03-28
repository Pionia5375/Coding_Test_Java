import java.util.*;

class Solution {
    public int solution(int[] number) {
        int r = 3;
        int count = 0;
        int tmp = 0;
        List<int[]> result = getCombinations(number, r);
        
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length; j++) {
                tmp += result.get(i)[j];
            }
            if (tmp == 0) {
                count++;
            }
            tmp = 0;
        }
        
        return count;
        
    }
    
    public static List<int[]> getCombinations(int[] arr, int r) {
        List<int[]> combinations = new ArrayList<>();
        makeCombinations(arr, new int[r], 0, 0, r, combinations);
        return combinations;
    }
    
    public static void makeCombinations(int[] arr, int[] selectArr, int startIdx, int pickCnt, int r, List<int[]> combinations) {
        if (pickCnt == r) {
            combinations.add(selectArr.clone());
            return;
        }
        for (int i = startIdx; i < arr.length; i++) {
            selectArr[pickCnt] = arr[i];
            makeCombinations(arr, selectArr, i + 1, pickCnt + 1, r, combinations);
        }
    }  
}
