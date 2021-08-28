package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_4698_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String[] input;
        String d;
        int a, b, result; // d : 특별한 소수, 소수 범위 a이상, b이하
        boolean[] prime = new boolean[1000001];     // 에라토스테네스의 체
        prime[1] = true;                            // 1은 소수가 아님
        for(int i = 2; i < prime.length; i++){
            for(int j = 2; i * j < prime.length; j++){
                prime[i*j] = true;                      // 소수가 아닌 것들은 true로 변환.
            }
        }


        for(int test_case = 1; test_case <= t; test_case++){
            input = br.readLine().split(" ");
            d = input[0];
            a = Integer.parseInt(input[1]);
            b = Integer.parseInt(input[2]);
            result = 0;

            for(int i = a; i <= b; i++){
                if(!prime[i] && String.valueOf(i).contains(d)) result++;
            }

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}