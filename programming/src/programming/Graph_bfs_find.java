package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_bfs_find {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int count=0;
		
		boolean visited[] = new boolean[100001];
		int result[] = new int[100001];
		
		queue.add(N);
		visited[N]=true;
		result[N]=0;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			if (tmp==K) {
				System.out.println(result[tmp]);
				return;
			}
			
			for(int i=0;i<3;i++) {
				int next;
				if(i==0) {
					next=tmp-1;
					if (next >= 0 && next < 100001 && !visited[next]) {
	                    queue.add(next);
	                    visited[next] = true;
	                    result[next] = result[tmp] + 1;
	                }
				}
				if(i==1) {
					next=tmp+1;
					if (next >= 0 && next < 100001 && !visited[next]) {
	                    queue.add(next);
	                    visited[next] = true;
	                    result[next] = result[tmp] + 1;
	                }
				}
				if(i==2) {
					next=2*tmp;
					if (next >= 0 && next < 100001 && !visited[next]) {
	                    queue.add(next);
	                    visited[next] = true;
	                    result[next] = result[tmp] + 1;
	                }
				}
			}
		}
	
	
	}
}
