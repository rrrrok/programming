import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i=1; i<=n; i++){
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll(); // 첫 번째 요소 제거
            q.add(q.poll()); // 두 번째 요소를 큐의 뒤에 추가
        }

        System.out.println(q.poll()); // 마지막 남은 요소 출력
        scanner.close();
    }
}
