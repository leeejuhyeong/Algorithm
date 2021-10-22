package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class algo_1932_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] triangle = new List[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            triangle[i] = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                triangle[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].size(); j++){
                int large = triangle[i + 1].get(j) >= triangle[i + 1].get(j + 1) ? triangle[i + 1].get(j) : triangle[i + 1].get(j + 1);
                triangle[i].set(j, triangle[i].get(j) + large);
            }
        }
        System.out.println(triangle[0].get(0));
    }
}
