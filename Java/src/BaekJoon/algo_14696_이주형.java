package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_14696_이주형 {
    static BufferedReader br;

    public static class Card {
        int star, circle, square, triangle;         // 4, 3, 2, 1 순으로 별, 원, 네모, 세모

        public Card() {
            star = circle = square = triangle = 0;
        }
    }

    public static void init(int n, Card[] aCard, Card[] bCard) {        // Card배열 초기화
        for (int i = 0; i < n; i++) {
            aCard[i] = new Card();
            bCard[i] = new Card();
        }
    }

    public static void makeCard(int n, Card Card) throws Exception {    // 딱지 생성

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int j = 0; j < a; j++) {
            switch (st.nextToken()) {
                case "1":           // 1 = 세모
                    Card.triangle++;
                    break;
                case "2":           // 2 = 네모
                    Card.square++;
                    break;
                case "3":           // 3 = 원
                    Card.circle++;
                    break;
                case "4":           // 4 = 별
                    Card.star++;
                    break;
            }
        }

    }

    public static String whoIsWinner(Card aCard, Card bCard) {
        if (aCard.star > bCard.star) return "A";                // 별의 수
        else if (aCard.star < bCard.star) return "B";
        else {                                                  // 같을 때
            if (aCard.circle > bCard.circle) return "A";            // 원의 수
            else if (aCard.circle < bCard.circle) return "B";
            else {                                                  // 같을 때
                if (aCard.square > bCard.square) return "A";            // 네모의 수
                else if (aCard.square < bCard.square) return "B";
                else {                                                  // 같을 때
                    if (aCard.triangle > bCard.triangle) return "A";        // 세모의 수
                    else if (aCard.triangle < bCard.triangle) return "B";
                    else return "D";                                        // 같을 때 비김
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Card[] aCard = new Card[n];
        Card[] bCard = new Card[n];

        init(n, aCard, bCard);
        for (int i = 0; i < n; i++) {
            makeCard(n, aCard[i]);          // a딱지 생성
            makeCard(n, bCard[i]);          // b딱지 생성
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(whoIsWinner(aCard[i], bCard[i])).append("\n");
        }

        System.out.print(sb);

    }
}
