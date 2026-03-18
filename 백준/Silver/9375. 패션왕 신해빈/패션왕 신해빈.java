import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            Map<String, Integer> clothMap = new HashMap<>();
            int M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                clothMap.put(type, clothMap.getOrDefault(type, 0) + 1);
            }
            
            int answer = 1;
            
            for (int count : clothMap.values())
                answer *= (count + 1);
            
            System.out.println(answer - 1);
        }
    }
}