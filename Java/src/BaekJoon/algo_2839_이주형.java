package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_2839_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while (n % 5 != 0 && n > 0) {
            n -= 3;
            result++;
        }
        result += n / 5;

        if(n < 0) System.out.println(-1);
        else System.out.println(result);
    }
}
