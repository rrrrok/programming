package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_ArrayDeque {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String commands = br.readLine(); // 명령어 문자열
			int n = Integer.parseInt(br.readLine()); // 배열 크기
			String input = br.readLine(); // 배열 문자열 입력

			Deque<Integer> deque = new ArrayDeque<>();

			// 배열 파싱
			if (n > 0) {
				String nums = input.substring(1, input.length() - 1); // 괄호 제거
				String[] numArr = nums.split(",");
				for (String s : numArr) {
					deque.add(Integer.parseInt(s));
				}
			}

			boolean isReversed = false;
			boolean error = false;

			for (char c : commands.toCharArray()) {
				if (c == 'R') {
					isReversed = !isReversed;
				} else if (c == 'D') {
					if (deque.isEmpty()) {
						error = true;
						break;
					}
					if (isReversed) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}

			if (error) {
				System.out.println("error");
			} else {
				if (isReversed) {
					System.out.print("[");

					while (!deque.isEmpty()) {
						System.out.print(deque.pollLast());
						if(!deque.isEmpty()) System.out.print(",");
					}

					System.out.println("]");
				} else {
					System.out.print("[");

					while (!deque.isEmpty()) {
						System.out.print(deque.pollFirst() );
						if(!deque.isEmpty()) System.out.print(",");
					}

					System.out.println("]");
				}
			}
		}
	}

}
