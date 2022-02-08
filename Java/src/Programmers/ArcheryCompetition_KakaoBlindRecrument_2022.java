package Programmers;

import java.util.Arrays;

public class ArcheryCompetition_KakaoBlindRecrument_2022 {
    public static int max;
    public static int[] result;

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(solution(n, info)));
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        result = new int[11];
        result[0] = n;
        max = Integer.MIN_VALUE;

        dfs(0, 0, n, info, answer);

        if (max == Integer.MIN_VALUE) {
            return new int[]{-1};
        } else
            return result;
    }

    private static void dfs(int start, int arrow, int n, int[] info, int[] answer) {
        if (arrow == n) {
            winner(info, answer);
            return;
        }
        for (int i = start; i < 10; i++) {
            if (info[i] < n - arrow) {
                answer[i] = info[i] + 1;
                dfs(i + 1, arrow + info[i] + 1, n, info, answer);
                answer[i] = 0;
            }
        }

        answer[10] = n - arrow;
        winner(info, answer);
        answer[10] = 0;
    }

    private static void winner(int[] info, int[] answer) {
        int lion, apache;
        lion = apache = 0;
        // 점수 계산
        for (int i = 0; i <= 10; i++) {
            if (info[i] == 0 && answer[i] == 0)
                continue;
            if (info[i] < answer[i]) {
                lion += 10 - i;
            } else
                apache += 10 - i;
        }


        if (lion > apache && max <= lion - apache) {
            if (max < lion - apache) {
                max = lion - apache;
                System.arraycopy(answer, 0, result, 0, 11);
            } else {
                // 낮은 점수를 많이 맞힌 경우
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] == result[i])
                        continue;
                    if (answer[i] > result[i]) {
                        System.arraycopy(answer, 0, result, 0, 11);
                    }
                    return;
                }
            }
        }
    }

}
