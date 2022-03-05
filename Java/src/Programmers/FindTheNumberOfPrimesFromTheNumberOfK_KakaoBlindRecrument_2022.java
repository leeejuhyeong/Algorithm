package Programmers;

public class FindTheNumberOfPrimesFromTheNumberOfK_KakaoBlindRecrument_2022 {
    public static String binary;

    public static void main(String[] args) throws Exception {
        int n = 1000000;
        int k = 3;
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int result = 0;
        binary = "";
        makeBinary(n, k);

        String[] splites = binary.split("0");

        Long now;
        for (String splite : splites) {
            if (splite.equals("1") || splite.equals(""))
                continue;
            now = Long.parseLong(splite);
            if (isPrimes(now)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isPrimes(long now) {
        for (int i = 2; i <= Math.sqrt(now); i++) {
            if (now % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void makeBinary(int n, int k) {
        if (n > 0) {
            binary = n % k + binary;
            makeBinary(n / k, k);
        }
    }
}
