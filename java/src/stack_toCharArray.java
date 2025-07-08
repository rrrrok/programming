import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_toCharArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n;i++){
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            
            boolean isValid = true;
            for (char c: line.toCharArray()){
                if(c == '('){
                    stack.push(c);
                }else if(c ==')'){
                if (stack.isEmpty() || stack.peek() != '(') {
                    isValid = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            isValid = false;

        System.out.println(isValid ? "YES" : "NO");
    }
}}
