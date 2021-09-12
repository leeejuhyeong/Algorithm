package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_2527_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 4; t++) {
            String[] input = br.readLine().split(" ");

            int ax1 = Integer.parseInt(input[0]);       // a 직사각형 x 최소값
            int ay1 = Integer.parseInt(input[1]);       // a 직사각형 y 최소값
            int ax2 = Integer.parseInt(input[2]);       // a 직사각형 x 최대값
            int ay2 = Integer.parseInt(input[3]);       // a 직사각형 y 최대값

            int bx1 = Integer.parseInt(input[4]);       // b 직사각형 x 최소값
            int by1 = Integer.parseInt(input[5]);       // b 직사각형 y 최소값
            int bx2 = Integer.parseInt(input[6]);       // b 직사각형 x 최대값
            int by2 = Integer.parseInt(input[7]);       // b 직사각형 y 최대값

            boolean[] xRange = new boolean[50001];      // x범위 1 ~ 50000
            int xCount = 0;

            for (int i = ax1; i <= ax2; i++) {
                xRange[i] = true;           // a직사각형의 x범위
            }

            for (int i = bx1; i <= bx2; i++) {
                if (xRange[i]) xCount++;        // a직사각형과 b직사각형의 겹치는 x범위
            }

            boolean[] yRange = new boolean[50001];      // y범위 1 ~ 50000
            int yCount = 0;

            for (int i = ay1; i <= ay2; i++) {
                yRange[i] = true;                // a직사각형의 y범위
            }

            for (int i = by1; i <= by2; i++) {
                if (yRange[i]) yCount++;        // a직사각형과 b직사각형의 겹치는 y범위
            }

            if (xCount >= 1 && yCount >= 1) {
                if (xCount == 1 && yCount == 1) System.out.println("c");        // 겹치는 x, y범위가 각각 1일때 한점에서 만남
                else if (xCount == 1 || yCount == 1) System.out.println("b");   // 둘중 하나만 1일 때 선으로 만남
                else System.out.println("a");
            } else System.out.println("d");         // 하나도 없을 때 겹치지 않음.
        }
    }
}
