package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_1463_이주형 {
    public static int result;

    public static void findmin(int level, int t){
        if(level > result) return;
        if(t == 1) {
            result = level;
        }
        else{
            if(t % 3 == 0) findmin(level + 1, t / 3);
            if(t % 2 == 0) findmin(level + 1, t / 2);
            findmin(level + 1, t - 1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;

        findmin(0, t);
        bw.append(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
