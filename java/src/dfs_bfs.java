import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dfs_bfs {
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> visited = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String[] part1 = line1.split(" ");
        int n = Integer.parseInt(part1[0]);
        int m = Integer.parseInt(part1[1]);
        int v = Integer.parseInt(part1[2]);

        // 그래프 초기화
        for (int i=0; i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        // 간선 입력 받기
        while(m-- >0){
            String line2 = br.readLine();
            String[] part2 = line2.split(" ");
            int tmp1 = Integer.parseInt(part2[0]);
            int tmp2 = Integer.parseInt(part2[1]);
            graph.get(tmp1).add(tmp2);
            graph.get(tmp2).add(tmp1);
        }
        //백준 1260번 풀이
        for (int i=0; i<=n;i++){
            graph.get(i).sort(Integer::compareTo); //오름차순 정렬
        }
        dfs(v); // DFS 호출
        sb.append("\n");
        visited = new ArrayList<>();
        bfs(v); // BFS 호출
        System.out.println(sb.toString());
    }

    static void dfs(int v) {
        visited.add(v);
        sb.append(v+" ");
        
        for (int i : graph.get(v)) { // 인접 노드 탐색
            if (!visited.contains(i)) { // 방문하지 않은 노드라면
                dfs(i); // 재귀 호출
            }
        }
    }    
    static void bfs(int v) {
        List<Integer> queue = new ArrayList<>();
        queue.add(v);
        visited.add(v);
        
        while (!queue.isEmpty()) {
            int current = queue.remove(0); // 큐에서 첫 번째 요소 제거
            sb.append(current + " ");
            
            for (int i : graph.get(current)) { // 인접 노드 탐색
                if (!visited.contains(i)) { // 방문하지 않은 노드라면
                    visited.add(i); // 방문 기록 추가
                    queue.add(i); // 큐에 추가
                }
            }
        }
    }

}
