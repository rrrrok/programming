
import java.util.Scanner;
import java.util.LinkedList;

public class list {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> answer = new LinkedList<>();

        int n,k;
        n = scan.nextInt(); 
        k = scan.nextInt(); 
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;

         while (!list.isEmpty()) {
            index = (index + k - 1) % list.size(); 
            answer.add(list.remove(index));
        }

        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if (i != answer.size() - 1) System.out.print(", ");
        }
        System.out.println(">");

        scan.close();
    }
}
