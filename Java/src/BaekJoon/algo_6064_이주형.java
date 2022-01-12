package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_6064_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int m, n, x, y;

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int lcm = m * n / gcd(m, n);        // 유클리드 호제법
            int multi = 0;
            int ans = -1;
            while (multi * m < lcm) {
                if ((multi * m + x - y) % n == 0) {
                    ans = multi * m + x;
                    break;
                }
                multi++;
            }
            bw.append(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int gcd(int m, int n) {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }
}
