package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_14502_이주형 {
    public static int[] moveX = {-1, 1, 0, 0};
    public static int[] moveY = {0, 0, -1, 1};
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] lab = new int[n][m];

        for (int i = 0; i < n; i++) {
            lab[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();     // 배열 초기화
        }

        result = Integer.MIN_VALUE;     // 안전구역 최대 범위
        build(n, m, lab, 0);        // 벽세우기

        System.out.println(result);
    }

    public static void build(int n, int m, int[][] lab, int count) {    // 벽 세우기
        if (count == 3) {       // 벽 3개 세웠을 때
            int safezone = virus(n, m, lab);        // 바이러스 퍼뜨리기
            if(result < safezone) result = safezone;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {               // 빈공간에 벽세우기
                    lab[i][j] = 1;
                    build(n, m, lab, count + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    public static int virus(int n, int m, int[][] lab) {    // 바이러스 퍼뜨리기
        int[][] newlab = new int[n][m];                 // 배열 복사

        for (int i = 0; i < n; i++) {
            System.arraycopy(lab[i], 0, newlab[i], 0, m);
        }

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(newlab[i][j] == 2){          // 바이러스 발현지 queue에 저장
                    qu.offer(new int[]{i, j});
                }
            }
        }

        int[] current;
        int nextR, nextC;
        while(!qu.isEmpty()){
            current = qu.poll();

            for(int i = 0; i < 4; i++){
                nextR = current[0] + moveX[i];
                nextC = current[1] + moveY[i];

                if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && newlab[nextR][nextC] == 0){        // 다음 공간이 빈공간이라면 바이러스 퍼짐
                    newlab[nextR][nextC] = 2;
                    qu.offer(new int[]{nextR, nextC});
                }
            }
        }

        return safe(n, m, newlab);      // 안전구역 확인해서 반환
    }

    public static int safe(int n, int m, int[][] newlab){
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0 ;j < m; j++){
                if(newlab[i][j] == 0) count++;      // 안전구여이라면 count 증가
            }
        }

        return count;                           // 안전구역 반환
    }
}
