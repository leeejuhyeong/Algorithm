package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_9375_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, result;
        Map<String, Integer> clothes;
        String kind;

        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                kind = st.nextToken();

                if(clothes.containsKey(kind)) {
                    clothes.put(kind, clothes.get(kind) + 1);
                } else {
                    clothes.put(kind, 1);
                }
            }

            result = 0;
            if(n != 0) {
                result = 1;
                for (Integer clothe : clothes.values()) {
                    result *= clothe + 1;
                }
                result--;
            }
            System.out.println(result);
        }
    }
}
