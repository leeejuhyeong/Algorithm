package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_5525_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();


        char[] patterns = new char[2 * n + 1];
        int[] pi = new int[2 * n + 1];
        patterns[0] = 'I';
        patterns[1] = 'O';
        for (int i = 2; i < 2 * n + 1; i++) {
            pi[i] = i - 1;
            patterns[i] = i % 2 == 0 ? 'I' : 'O';
        }

        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != patterns[j]) {
                j = pi[j - 1];
            }

            if (s[i] == patterns[j]) {
                if (j == patterns.length - 1) {
                    result++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.println(result);
    }
}
