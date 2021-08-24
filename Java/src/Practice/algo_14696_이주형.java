package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_14696_이주형 {
    public static BufferedReader br;
    public static void makeCard(int n, int[] Card) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int j = 0; j < a; j++) {
            switch (st.nextToken()) {
                case "1":
                    Card[3]++;
                    break;
                case "2":
                    Card[2]++;
                    break;
                case "3":
                    Card[1]++;
                    break;
                case "4":
                    Card[0]++;
                    break;
            }
        }
    }
    // level = 배열의 index(0:별, 1:원, 2:네모, 3:세모
    public static String whoIsWinner(int level, int[] aCard, int[] bCard){
        if(aCard[level] > bCard[level]) return "A";             // A가 크면 승리
        else if(aCard[level] < bCard[level]) return "B";        // B가 크면 승리
        else {                                                  // 비겼을 때
            if(level == 3) return "D";                          // 마지막 세모일 시
            return whoIsWinner(level + 1, aCard, bCard);    // 다음 배열 확인
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] aCard = new int[n][4];  // 1 : 별, 2 : 원, 3 : 네모, 4: 세모
        int[][] bCard = new int[n][4];

        for(int i = 0; i < n; i++){
            makeCard(n, aCard[i]);              // 딱지 생성
            makeCard(n, bCard[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(whoIsWinner(0, aCard[i], bCard[i])).append("\n");
        }
        System.out.print(sb);
    }
}
