package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1107_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] broken = new int[m];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[i] = Integer.parseInt(st.nextToken());
            }
        }

        int range = Math.abs(n - 100);      // 목적채널 - 100(현재채널)
                                                    // upCount 목적채널: 5431, upCount =  0 = 채널 5431 / upCount = 1 채널 : 5432 // upCount = 2 채널 : 5433
        int upCount = 0;
        while (upCount < range) {
            if (goChannel(n + upCount, broken, m)) {        // 가고자하는 채널부터 증가하면서 리모컨으로 눌러서 갈 수 있으면 탈출
                int count = String.valueOf(n + upCount).length();
                if (range > upCount + count) {       // +, -로 움직이면서 가는 것보다 누르는 총 횟수(움직이고 채널누른 횟수)가 적을 경우
                    range = upCount + count;
                }
                break;
            }
            upCount++;
        }

        int downCount = 0;
        while (n - downCount >= 0 && downCount < range) {       // 반복 범위는 +, -로 움직여서 가는 횟수보다 작은만큼 반복
            if (goChannel(n - downCount, broken, m)) {      // 가고자하는 채널부터 감소하면서 리모컨으로 눌러서 갈 수 있으면 탈출
                int count = String.valueOf(n - downCount).length();
                if (range > downCount + count) {
                    range = downCount + count;
                }
                break;
            }
            downCount++;
        }
        System.out.println(range);
    }

    private static boolean goChannel(int channel, int[] broken, int m) {    // 누를 수 없는 번호가 있는 채널이라면 false 반환
        String change = String.valueOf(channel);
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            if (change.contains(Integer.toString(broken[i]))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}