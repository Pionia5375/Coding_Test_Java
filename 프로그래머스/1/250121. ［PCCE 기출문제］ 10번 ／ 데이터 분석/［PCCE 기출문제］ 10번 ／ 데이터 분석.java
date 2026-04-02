import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        List<String> columns = Arrays.asList("code", "date", "maximum", "remain");
        int extIdx = columns.indexOf(ext);
        int sortIdx = columns.indexOf(sort_by);
        
        List<int[]> filteredList = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIdx] < val_ext) {
                filteredList.add(data[i]);
            }
        }
        
        filteredList.sort((a, b) -> a[sortIdx] - b[sortIdx]);
        
        int[][] answer = new int[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            answer[i] = filteredList.get(i);
        }
        
        return answer;
    }
}
