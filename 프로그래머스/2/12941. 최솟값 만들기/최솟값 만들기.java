import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - (1 + i)];
        }
        
        return answer;
    }
}

// a, b를 순회하며 동일한 인덱스의 두 수를 곱하고 누적시킨 값이 최소가 되도록 하는 값.
// 값이 최소가 되기 위해서는, 매번 가장 큰 수와 가장 작은 수를 곱해야 함. 
// a를 오름차순 정렬, b를 내림차순 정렬해서 서로 곱해주면 됨.
