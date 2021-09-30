package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분할 정복
public class algo_2630_이주형 {
    public static int[][] papers;
    public static boolean[][] papers2;
    public static int blue;
    public static int white;

    public static void cut(int startR, int startC, int size) {
        if(size == 1){
            if(papers2[startR][startC]) white++;
            else blue++;
            return;
        }
        if (!perfect(startR, startC, size)) {     // 같은 색이 아니라면 4등분
            cut(startR, startC, size / 2);
            cut(startR, startC + size / 2, size / 2);
            cut(startR + size / 2, startC, size / 2);
            cut(startR + size / 2, startC + size / 2, size / 2);
        } else {    // 같은 색이라면 해당 색 count 증가
            if (papers2[startR][startC]) white++;
            else blue++;
        }
    }

    // 모두 같은 색의 색종이이면 true, 아니면 false
    public static boolean perfect(int startR, int startC, int size) {
        boolean color = papers2[startR][startC];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(papers2[startR + i][startC + j] != color) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        papers2 = new boolean[n][n];
        StringTokenizer st;

        for(int i = 0 ;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < n; j++){
                papers2[i][j] = st.nextToken().equals("0");
            }
        }

        white = 0;
        blue = 0;
        cut(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
}
