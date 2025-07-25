package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Tree_Map {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			TreeMap<Integer, Integer> map = new TreeMap<>();  
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				String str[] = br.readLine().split(" ");
				String tmp_1 = str[0];
				int tmp_2 = Integer.parseInt(str[1]);
				if (tmp_1.equals("I")) {// I일때 insert
					map.put(tmp_2, map.getOrDefault(tmp_2, 0) + 1);
				} else if(tmp_1.equals("D")&& !map.isEmpty()){// D일때
					int key = (tmp_2 == -1) ? map.firstKey() : map.lastKey();
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
				}
			}
			if(map.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(map.lastKey()+" "+map.firstKey());
		}

	}

}
