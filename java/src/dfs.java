import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dfs {
    static boolean[][] field;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        

        while (n-- > 0){
            int count =0;
            String line = br.readLine();
            String[] part = line.split(" ");
            int[] parts = new int[part.length];
            for (int i = 0; i < part.length; i++) {
                parts[i] = Integer.parseInt(part[i]);
            }

            field = new boolean[parts[1]][parts[0]];
            visited = new boolean[parts[1]][parts[0]];

            while(parts[2]-- > 0){
                String line1 = br.readLine();
                String[] part1 = line1.split(" ");
                int[] parts1 = new int[part1.length];
                for (int i = 0; i < part1.length; i++) {
                    parts1[i] = Integer.parseInt(part1[i]);
                }
                field[parts1[1]][parts1[0]] = true; //배추가 있는 field true로 설정
                
                
            }
            for (int i=0; i<parts[1];i++){
                    for (int j=0; j<parts[0];j++){
                        if (field[i][j] && !visited[i][j]){ //배추가 있고 방문하지 않은 곳이면
                            count++; //카운트 증가
                            dfs(i, j); //dfs 호출
                        }
                    }
                }
            System.out.println(count);
        }

    }

    static void dfs(int i, int j) {
        visited[i][j] = true; //현재 위치 방문 처리
        
        for(int d = 0; d < 4; d++) { //상하좌우 탐색
            int ni = i + dy[d];
            int nj = j + dx[d];
            
            if (ni >= 0 && ni < field.length && nj >= 0 && nj < field[0].length) { //범위 체크
                if (field[ni][nj] && !visited[ni][nj]) { //배추가 있고 방문하지 않은 곳이면
                    dfs(ni, nj); //재귀 호출
                }
            }
        }
    }
    
}
