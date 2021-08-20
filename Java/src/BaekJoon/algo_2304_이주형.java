package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class algo_2304_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] pillar = new int[n][2];         // 0 : idx, 1 : height;
        int high = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pillar[i][0] = Integer.parseInt(input[0]);
            pillar[i][1] = Integer.parseInt(input[1]);
            if (high < pillar[i][1]) {                    // 가장 높은 기둥 높이 찾기.
                high = pillar[i][1];
            }
        }

        Arrays.sort(pillar, new Comparator<int[]>() {       // 기둥의 idx기준으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int area = 0;           // 넓이 - 결과값
        int start = 0;          // 왼쪽부터 시작
        int bstart = n - 1;     // 오른쪽부터 시작
        int temp = 1;           // 자신보다 낮은 기둥 무시

        // 가장 높은 기둥일 시 break
        while (pillar[start][1] != high) {            // 왼쪽부터 가장 높은 기둥까지 넓이 구하기
            if (pillar[start][1] >= pillar[start + temp][1]) {
                temp++;
                continue;     //다음 기둥이 자신보다 낮다면 무시
            }

            area += (pillar[start + temp][0] - pillar[start][0]) * pillar[start][1];   // 높다면 자신의 높이부터 높은 기둥가지 넓이 구하기
            start += temp;
            temp = 1;
        }


        while (pillar[bstart][1] != high) {          // 오른쪽부터 가장 높은 기둥까지 넓이 구하기
            if (pillar[bstart][1] >= pillar[bstart - temp][1]) {
                temp++;
                continue;     //다음 기둥이 자신보다 낮다면 무시
            }

            area += (pillar[bstart][0] - pillar[bstart - temp][0]) * pillar[bstart][1];// 높다면 자신의 높이부터 높은 기둥가지 넓이 구하기
            bstart -= temp;
            temp = 1;
        }

        if(start != bstart){        // 가장 높은 기둥 넓이
            area += (pillar[bstart][0] - pillar[start][0] + 1) * high;      // start ~ bstart까지이기 때문에 너비는 bstart - start + 1이다!!
        } else area += high;

        System.out.println(area);

    }
}
