package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_15552_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        int number;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            bw.write(number + "\n");
        }
        bw.flush();
        bw.close();
    }
}
