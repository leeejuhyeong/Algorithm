package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_6808_이주형 {
    static int win;
    static int lose;
    static int[] kyuCard;
    static int[] innCard;
    static int[] innPermutation;
    static boolean[] innCheck;

    public static void winner() {
        int winsum = 0;
        int losesum = 0;
        for (int i = 0; i < 9; i++) {
            if (kyuCard[i] > innPermutation[i]) winsum += kyuCard[i] + innPermutation[i];
            else losesum += kyuCard[i] + innPermutation[i];
        }
        if(winsum > losesum) win++;
        else if(winsum < losesum) lose++;
    }

    public static void permutation(int level, int cnt) {
        if (cnt == 9) {
            winner();
            return;
        }

        for(int i = 0; i < 9; i++){
            if(innCheck[i]) continue;

            innCheck[i] = true;
            innPermutation[cnt] = innCard[i];
            permutation(level + 1, cnt + 1);
            innCheck[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            kyuCard = new int[9];
            boolean[] cardCheck = new boolean[19];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                kyuCard[i] = Integer.parseInt(st.nextToken());  // 규영이의 카드
                cardCheck[kyuCard[i]] = true;
            }

            innCard = new int[9];
            int count = 0;
            for (int i = 1; i <= 18; i++) {
                if (!cardCheck[i]) innCard[count++] = i;  // 인영이의 카드
            }

            innPermutation = new int[9];
            innCheck = new boolean[9];
            win = 0;
            lose = 0;
            permutation(0, 0);

            System.out.println("#" + test_case + " " + win + " " + lose);

        }
    }
}
