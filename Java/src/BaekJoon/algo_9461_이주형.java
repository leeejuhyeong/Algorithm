package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_9461_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n;
        long[] pado = new long[101];
        pado[1] = pado[2] = pado[3] = 1;
        pado[4] = pado[5] = 2;

        for (int i = 6; i < 101; i++) {
            pado[i] = pado[i - 1] + pado[i - 5];
        }

        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            bw.write(pado[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
