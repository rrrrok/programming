package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_algorithm_math {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split("-");
		
		int sum=0;
		
		for (String s:tmp[0].split("\\+")) {
			sum += Integer.parseInt(s);
		}
		for (int i=1;i<tmp.length;i++) {
			int sum_tmp=0;
			for(String z: tmp[i].split("\\+")) {
				sum_tmp+=Integer.parseInt(z);
			}
			sum-=sum_tmp;
		}
		System.out.println(sum);
	}
	
}
