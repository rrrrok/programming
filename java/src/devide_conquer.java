import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class devide_conquer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String line = br.readLine();
        String[] parts = line.split(" ");
        int n = Integer.parseInt(parts[0]);
        int r = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);

        int result = solve(n, r, c);

        System.out.println(result);
    }

    static int solve(int n, int r, int c) {
       if (n == 0) return 0;

       int size = pow(2,n-1);
       int total_size = size * size;
       if (r<size && c<size){
        return solve(n-1,r,c);
       }else if (r<size && c>=size){
        return total_size + solve(n-1,r,c-size);
       }else if (r>=size && c<size){
        return 2 * total_size + solve(n-1,r-size,c);
       }else if (r>=size && c>=size){
        return 3*total_size + solve(n-1,r-size,c-size);
       }
       System.out.println("오류 발생_r,c 범위 오류");
       return -1;
    }

    private static int pow(int i, int j) {
        int result = 1;
        while(j-->0){
            result *= i;
        }
        return result;
    }
}
