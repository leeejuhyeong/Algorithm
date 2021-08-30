package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 14324KB, 144ms
public class algo_10158_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[1]);     // y 좌표
        int c = Integer.parseInt(input[0]);     // x 좌표

        input = br.readLine().split(" ");

        int rAnt = Integer.parseInt(input[1]);      // 개미의 y좌표
        int cAnt = Integer.parseInt(input[0]);      // 개미의 x좌표
        int time = Integer.parseInt(br.readLine());     // 시간

        // 1시간마다 r, c는 1씩 증가하거나 감소
        rAnt = (rAnt + time) % (2 * r);     // 현재 개미의 위치 + 앞으로 시간(칸이동)을 길이*2의 나머지
        cAnt = (cAnt + time) % (2 * c);

        if (rAnt > r) rAnt = 2 * r - rAnt;  // r보다 클 경우 되돌아와야함
        if (cAnt > c) cAnt = 2 * c - cAnt;


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(cAnt)).append(" ").append(String.valueOf(rAnt));
        bw.flush();
        bw.close();
    }
}

// 1. 그냥 하나씩 이동하면서 했음. -> 시간 초과
// 2. 다음 줄(행, 열)을 만날때까지 줄여주었음 -> 시간 초과
// 3. 최종적으로 그냥 나머지를 구해서 해야했음..