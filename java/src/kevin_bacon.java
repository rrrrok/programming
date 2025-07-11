import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kevin_bacon {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static List<Integer> result = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    // 백준 1389번
    public static void main(String[] args) throws IOException {
        String line1 = br.readLine();
        String[] part1 = line1.split(" ");
        int n = Integer.parseInt(part1[0]);
        int m = Integer.parseInt(part1[1]);

        // 그래프 초기화
        for (int i=0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        while(m-- > 0) {
            String line2 = br.readLine();
            String[] part2 = line2.split(" ");
            int tmp1 = Integer.parseInt(part2[0]);
            int tmp2 = Integer.parseInt(part2[1]);

            graph.get(tmp1).add(tmp2);
            graph.get(tmp2).add(tmp1);
        }

        // 각 노드에 대해서 BFS 수행
        for (int i=1; i <=graph.size()-1; i++){
            int sum =0;
            
            for (int k=1;k<graph.size();k++){
                if (i == k) continue; // 자기 자신은 제외
                int distance = bfs(i, k);
                if (distance == -1) continue; // 경로 없으면 무시
                sum += distance;
            }
            result.add(sum); // 각 노드의 거리 합산 결과 저장
        }
        int min = Collections.min(result);
        int answer = 0;

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == min) {
                answer = i + 1; // 인덱스 0 → 정점 1, 1 → 정점 2, ...
                break;
            }
        }
        System.out.println(answer);
    }
    static int bfs(int start, int end) {
        visited = new boolean[graph.size()];
        List<Integer> queue = new ArrayList<>();
        queue.add(start);
        visited[start] = true;

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                int current = queue.remove(0);
                if (current == end) {
                    return distance; // 목적지에 도달하면 거리 반환
                }
                
                for (int neighbor : graph.get(current)) {
                    if (!visited[neighbor]) { // 방문하지 않은 노드라면
                        visited[neighbor] = true; // 방문 처리
                        queue.add(neighbor); // 큐에 추가
                    }
                }
            }
            distance++; // 한 단계 이동
        }
        return -1; // 목적지에 도달하지 못한 경우
    }
}
