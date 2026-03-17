import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        
        // 해시 맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 배열의 두번째 요소를 키값으로 해서 해시맵 + 1
        for (String[] item : clothes)
            map.put(item[1], map.getOrDefault(item[1], 0) + 1);
        
        // 해시맵의 모든 밸류 + 1을 다 곱하고 - 1
        for (String key : map.keySet())
            answer = answer * (map.get(key) + 1);
            
        return answer - 1;
    }
}