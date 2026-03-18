import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, List<String>> groupMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            
            for (int j = 0; j < memberCount; j++) {
                String memberName = br.readLine();
                members.add(memberName);
                memberMap.put(memberName, groupName);
            }
            Collections.sort(members);
            groupMap.put(groupName, members);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            int type = Integer.parseInt(br.readLine());
            
            if(type == 0) {
                List<String> result = groupMap.get(query);
                for (String name : result) {
                    sb.append(name).append("\n");
                }
            } else {
                sb.append(memberMap.get(query)).append("\n");
            }
        }
        System.out.print(sb);
        }
}