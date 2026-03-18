import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    Map<String, String> passwordMap = new HashMap<>();
    
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        String site = st.nextToken();
        String password = st.nextToken();
        passwordMap.put(site, password);
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
        String query = br.readLine();
        String result = passwordMap.get(query);
        sb.append(result).append("\n");
    }
    System.out.print(sb);
    }
}