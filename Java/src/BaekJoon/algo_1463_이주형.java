package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_1463_이주형 {
//    public static int result;
//
//    public static void findmin(int level, int t){
//        if(level >= result) return;
//        if(t == 1) {
//            result = level;
//        }
//        else{
//            if(t % 3 == 0) findmin(level + 1, t / 3);
//            if(t % 2 == 0) findmin(level + 1, t / 2);
//            findmin(level + 1, t - 1);
//        }
//    }
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int t = Integer.parseInt(br.readLine());
//        result = Integer.MAX_VALUE;
//
//        findmin(0, t);
//        bw.append(Integer.toString(result));
//        bw.flush();
//        bw.close();
//    }

    // 식으로 정확하게 떨어지기 때문에 상향식이 적합
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
            }
        }
        System.out.println(d[n]);
    }
}
