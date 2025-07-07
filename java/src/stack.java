import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                s.push(value);
            } else if (command.equals("pop")) {
                sb.append(s.isEmpty() ? -1 : s.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(s.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(s.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                sb.append(s.isEmpty() ? -1 : s.peek()).append("\n");
            }
            
        }
        System.out.print(sb); 
        scanner.close();
    }
}
