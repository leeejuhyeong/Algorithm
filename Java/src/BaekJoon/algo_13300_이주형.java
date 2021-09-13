package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_13300_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 전체 학생 수
        int k = Integer.parseInt(st.nextToken());   // 방배정 최대 인원
        int[] man = new int[7];
        int[] woman = new int[7];

        for(int i = 0 ;i < n; i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "0":   // 여학생
                    woman[Integer.parseInt(st.nextToken())]++;
                    break;
                case "1":   // 남학생
                    man[Integer.parseInt(st.nextToken())]++;
                    break;
            }
        }
        int result = 0;
        for(int i = 1; i <= 6; i++){
            result += woman[i] / k;
            result += man[i] / k;
            if(woman[i] % k != 0) result++;
            if(man[i] % k != 0) result++;
        }
        System.out.println(result);
    }
}
