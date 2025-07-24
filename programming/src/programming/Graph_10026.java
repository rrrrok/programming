package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_10026 {
	static char map[][];
	static boolean visited[][];
	static int N;

	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		// map 초기화
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		int normal = 0;
		int color_weak = 0;
		// 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char now_color = map[i][j];
				if (!visited[i][j]) {
					bfs(i, j, now_color, false);
					normal++;
				}
			}
		}

		// visited 초기화
		visited = new boolean[N][N];

		// 적록색약 기준
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j], true);
					color_weak++;
				}
			}
		}

		System.out.println(normal + " " + color_weak);
	}

	private static void bfs(int i, int j, char now_color, boolean is_weak) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int tmp_x = now[0];
			int tmp_y = now[1];

			for (int dir = 0; dir < 4; dir++) {
				int now_x = tmp_x + dx[dir];
				int now_y = tmp_y + dy[dir];
				if (now_x >= 0 && now_y >= 0 && now_x < N && now_y < N) {
					if (!visited[now_x][now_y] && isSameColor(now_color, map[now_x][now_y], is_weak)) {
						visited[now_x][now_y] = true;
						queue.add(new int[] { now_x, now_y });
					}
				}
			}
		}
	}

	private static boolean isSameColor(char now_color, char c, boolean is_weak) {
		if (is_weak) {
			if ((now_color == 'R' || now_color == 'G') && (c == 'R' || c == 'G'))
				return true;
		}
		return now_color == c;
	}

}
