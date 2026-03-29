import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int num = arr1[i];
            int[] numArr = new int[n];
            
            int idx = n - 1;
            while (num > 0) {
                numArr[idx] = num % 2;
                num /= 2;
                idx--;
            }
            
            list1.add(numArr);
        }
        
        for (int i = 0; i < n; i++) {
            int num = arr2[i];
            int[] numArr = new int[n];
            
            int idx = n - 1;
            while (num > 0) {
                numArr[idx] = num % 2;
                num /= 2;
                idx--;
            }
            
            list2.add(numArr);
        }
        
        for (int i = 0; i < list1.size(); i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (list1.get(i)[j] == 1 || list2.get(i)[j] == 1) str.append("#");
                else str.append(" ");
            } list3.add(str.toString());
        }
        
        String[] resultArr = list3.toArray(new String[list3.size()]);
        
        return resultArr;
    }
}
// 문자배열 타입을 제네릭으로 하는 어레이 리스트 생성
// 정수를 하나씩 순회하기
// 몫이 0이 될때까지 나누고, 나머지를 요소로 하는 배열 만들기
// 배열을 뒤집어 2진수 배열 만들기
// 문자 배열을 생성해서, 순회하면서 배열과 비교하여 1이면 '#' 추가하기

// 바꾼 두 문자배열 리스트를 동시에 비교하기
// 문자배열 리스트의 각 요소를 하나씩 순회하기
// 리스트의 해당 인덱스를 비교하기
// 같은 인덱스에 둘 중 한 요소에 '#'가 있으면 #추가하기