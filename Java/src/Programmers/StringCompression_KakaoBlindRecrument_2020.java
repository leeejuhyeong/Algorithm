package Programmers;

public class StringCompression_KakaoBlindRecrument_2020 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int len = s.length();

        String result;
        String now, next, last;
        int compression, min;
        min = Integer.MAX_VALUE;
        for (int i = 1; i < len / 2 + 1; i++) {
            now = s.substring(0, i);
            result = last = "";
            compression = 1;

            for (int j = i; j < len; j += i) {
                if (i + j > len) {
                    last = s.substring(j, len);
                    continue;
                }
                next = s.substring(j, j + i);
                if (now.equals(next)) {
                    compression++;
                } else {
                    result += now;
                    if (compression > 1) {
                        result += compression;
                    }
                    compression = 1;
                }
                now = next;
            }

            result += now;
            if (compression != 1) {
                result += compression;
            }
            if (!last.equals("")) {
                result += last;
            }

            if (min > result.length()) {
                min = result.length();
            }
        }

        if(s.length() == 1) {
            min = 1;
        }
        return min;
    }
}
