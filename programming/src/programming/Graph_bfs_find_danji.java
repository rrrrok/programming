package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_bfs_find_danji {
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		//맵 초기화
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		List<Integer> result = new ArrayList<>();
		int count=0;
		
		for(int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j] ==1) {
					int house_count = bfs(i,j,N);
					result.add(house_count);
					count++;
				}
			}
		}
		
		//출력
		System.out.println(count);
		Collections.sort(result);
		for(int num:result) {
			System.out.println(num);
		}
	}

	private static int bfs(int i, int j,int N) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		int count =1;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int x = now[0];
			int y = now[1];
			
			for(int tmp=0;tmp<4;tmp++) {
				int nx = x + dx[tmp];
				int ny = y + dy[tmp];
				
				if(nx>=0 && ny >=0 && nx<N && ny < N) {
					if(!visited[nx][ny] && map[nx][ny] ==1) {
						queue.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
		return count;
	}

}
