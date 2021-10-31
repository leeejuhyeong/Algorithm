package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 19,012KB, 111ms
public class algo_4047_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[][] cards;  // 카드 개수 확인
        String input;       // 입력값
        int sCard, dCard, hCard, cCard;     // S, D, H, A 카드 개수
        StringBuilder sb;

        for (int test_case = 1; test_case <= t; test_case++) {
            cards = new boolean[4][14];
            sCard = dCard = hCard = cCard = 13;     // 필요카드 13장
            input = br.readLine();
            sb = new StringBuilder();
            boolean flag = true;

            for (int i = 0; i < input.length(); i += 3) {
                char kind = input.charAt(i);                    // 카드 종류
                int ten = (input.charAt(i + 1) - '0') * 10;     // 10의 자리수
                int one = input.charAt(i + 2) - '0';            // 1의 자리수

                if(kind == 'S' && !cards[0][ten+one]) {     // 해당 카드 숫자가 true가 아니면서 S일때
                    cards[0][ten+one] = true;
                    sCard--;
                }
                else if(kind == 'D' && !cards[1][ten+one]) {     // D일때
                    cards[1][ten+one] = true;
                    dCard--;
                }
                else if(kind == 'H' && !cards[2][ten+one]) {     // H일때
                    cards[2][ten+one] = true;
                    hCard--;
                }
                else if(kind == 'C' && !cards[3][ten+one]) {     // C일때
                    cards[3][ten+one] = true;
                    cCard--;
                }
                else{
                    sb.append("#").append(test_case).append(" ").append("ERROR");
                    System.out.println(sb);
                    flag = false;
                    break;
                }
            }

            if(flag) {
                sb.append("#").append(test_case).append(" ");
                sb.append(sCard).append(" ").append(dCard).append(" ").append(hCard).append(" ").append(cCard);
                System.out.println(sb);
            }
        }
    }
}