package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_11401_이주형 {
    private static void pre(long[] fArray, long mod) {
        fArray[0] = fArray[1] = 1;

        for (int i = 2; i < fArray.length; i++) {
            fArray[i] = (fArray[i - 1] * i) % mod;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long mod = 1_000_000_007;
        long[] fArray = new long[4000001];
        pre(fArray, mod);
        System.out.println(solve(n, k, mod, fArray));
    }

    private static long solve(int n, int k, long mod, long[] fArray) {
        long a1 = fArray[n];
        long a2 = pow(fArray[n - k], mod - 2, mod);
        long a3 = pow(fArray[k], mod - 2, mod);

        return (((a1 * a2) % mod) * (a3 % mod)) % mod;
    }

    private static long pow(long a, long b, long mod) {
        if (b == 1L)
            return a;

        long half = pow(a, b / 2, mod);
        if (b % 2 == 0) return (half * half) % mod;
        else return (((half * half) % mod) * (a % mod)) % mod;
    }
}
