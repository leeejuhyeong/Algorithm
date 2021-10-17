package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_9095_이주형 {
    public static int result, num;
    public static int[] answer;
    public static void find(int combi){
        if(combi > num) return;     // 구하려는 숫자보다 넘을 경우 리턴
        if(combi == num){           // 구하려는 숫자일 경우
            result++;
            return;
        }
        find(combi + 1);        // 1 더하기
        find(combi + 2);        // 2 더하기
        find(combi + 3);        // 3 더하기
    }
    // 점화식
    public static void main2(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());
        answer = new int[12];
        answer[1] = 1;  // 1을 만드는 방법
        answer[2] = 2;  // 2를 만드는 방법 1 + 1 | 2
        answer[3] = 4;  // 3을 만드는 방법 (1 + 1) + 1 | ( 2 ) + 1 | 1 + ( 2 ) | 3
        answer[4] = 7;  // 4를 만드는 방법 answer[3]에서 1를 더해주는 방법 4가지, answer[2]에서 2를 더해주는 방법 2가지, answer[1]에서 3을 더해주는 방법 1가지 => 7가지

        for(int i = 5; i < 12; i++){
            answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
        }

        for(int i = 0 ;i < t; i++){
            num = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(answer[num]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    // 재귀
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ;i < t; i++){
            num = Integer.parseInt(br.readLine());
            result = 0;

            find(0);
            bw.append(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
/*
1 : 1                           - 1
2 : 1 1/ 2                      - 2
3 : 1 1 1 / 1 2 / 2 1 / 3       - 4
4 : D[1] + D[2] + D[3] = 1 2 4
5 : D(3) + D(2)/ 2*D(2) + 1 D(1)* 5

 */