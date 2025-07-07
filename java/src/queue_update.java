    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;

    public class queue_update {
        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            Queue<Integer> Q = new LinkedList<>();
            int last=-1;

            while( n-- > 0){
                String command = br.readLine();
                String[] parts = command.split(" ");

                if(parts[0].equals("push")){
                    last = Integer.parseInt(parts[1]);
                    Q.add(last);
                }else if(parts[0].equals("pop")){
                    System.out.println(Q.isEmpty() ? -1 : Q.poll());
                }else if(parts[0].equals("size")){
                    System.out.println(Q.size());
                }else if(parts[0].equals("empty")){
                    System.out.println(Q.isEmpty() ? 1 : 0);
                }else if (parts[0].equals("front")){
                    System.out.println(Q.isEmpty() ? -1 : Q.peek());
                }else if (parts[0].equals("back")){
                    System.out.println(Q.isEmpty() ? -1 : last);
                }
        }
    }}
