import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        List<int[]> list = getCombinations(nums, 3);
        int count = 0;
        
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = 0; j < list.get(i).length; j++) {
                sum += list.get(i)[j];
            }
            
            boolean isPrime = true; 
            
            for (int j = 2; j <= Math.sqrt(sum); j++) {
                if (sum % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                count++;
            }
        }

        return count;
    }

    public List<int[]> getCombinations(int[] arr, int r) {
        List<int[]> combinations = new ArrayList<>();
        makeCombinations(arr, new int[r], 0, 0, r, combinations);
        return combinations;
    }
    
    public void makeCombinations(int[] arr, int[] selectArr, int startIdx, int pickCnt, int r, List<int[]> combinations) {
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