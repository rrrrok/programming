package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_bfs_miro {
	static int[][] graph;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		graph = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		int N_tmp = N, M_tmp = M;

		// graph 초기화
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				graph[i][j] = line.charAt(j - 1) - '0';
			}
		}

		// 1,1 초기 시작
		queue.add(new int[] { 1, 1 });
		visited[1][1] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			
			if(x==N && y==M) {
				System.out.println(graph[N][M]);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=1 && nx<=N && ny>=1 && ny<=M && visited[nx][ny] != true && graph[nx][ny] == 1) {
					queue.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					graph[nx][ny] = graph[x][y] +1;
				}
			}
		}

	}

}
