import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int pokemon : nums)
            map.put(pokemon, map.getOrDefault(pokemon, 0) + 1);
        
        int num = 0;
        
        for (int pokemon : map.keySet())
            num += 1;
        
        if (num < nums.length / 2)
            return num;
        else
            return nums.length / 2;
    }
}