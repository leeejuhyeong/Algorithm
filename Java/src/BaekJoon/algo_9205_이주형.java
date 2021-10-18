package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_9205_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n;
        int[][] location;
        List<int[]> convenience;
        int[][] floyid;

        for(int test_case = 0; test_case < t; test_case++){
            n = Integer.parseInt(br.readLine());

            location = new int[n+3][2];

            for(int i = 1 ;i <= n + 2; i++){
                st = new StringTokenizer(br.readLine());
                location[i][0] = Integer.parseInt(st.nextToken());
                location[i][1] = Integer.parseInt(st.nextToken());
            }

            floyid = new int[n + 3][n + 3];

            for(int i = 1; i <= n+2; i++){
                for(int j = 1; j <= n+2; j++){
                    if(i == j) continue;
                    int distance = Math.abs(location[i][0] - location[j][0]) + Math.abs(location[i][1] - location[j][1]);
                    if(distance <= 1000) floyid[i][j] = 1;
                    else floyid[i][j] = n + 2;
                }
            }

            for(int k = 1; k <= n + 2; k++){
                for(int i = 1; i <= n + 2; i++){
                    if(i == k) continue;
                    for(int j = 1; j <= n + 2; j++){
                        if(j == k || j == i) continue;
                        if(floyid[i][j] > floyid[i][k] + floyid[k][j])
                            floyid[i][j] = floyid[i][k] + floyid[k][j];
                    }
                }
            }

            if(floyid[1][n+2] < n + 2) bw.append("happy");
            else bw.append("sad");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
