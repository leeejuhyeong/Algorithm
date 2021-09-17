package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class algo_1620_이주형 {
    // #1 56848KB	616ms
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        String input;
//
//        Map<String, String> poketmon = new HashMap<>();   // 포켓몬의 이름과 인덱스를 저장
//
//        for(int i = 1; i <= n; i++){
//            input = br.readLine();
//            poketmon.put(input, String.valueOf(i));       // key : 이름, value : 인덱스
//            poketmon.put(String.valueOf(i), input);       // key : 인덱스, value : 이름
//        }
//
//        for(int i = 0; i < m; i++){
//            input = br.readLine();
//            bw.append(poketmon.get(input));
//            bw.newLine();
//        }
//        bw.flush();
//        bw.close();
//    }
//
//    // #2 49352KB	512ms
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        String input;
//
//        String[] index_poketmon = new String[n + 1];      // 해당 인덱스의 배열에 이름 저장
//        Map<String, Integer> poketmon = new HashMap<>();  // key : 이름, value : 인덱스 저장
//        StringBuilder sb = new StringBuilder();           // StringBuilder 사용
//
//        for (int i = 1; i <= n; i++) {
//            input = br.readLine();
//            poketmon.put(input, i);
//            index_poketmon[i] = input;
//        }
//
//        for(int i = 0; i < m; i++){
//            input = br.readLine();
//            if(input.charAt(0) >= 'A' && input.charAt(0) <= 'Z'){     // 포켓몬의 이름일 때
//                sb.append(poketmon.get(input));                       // Map에서 가져오기
//            } else{                                                   // 인덱스 일때
//                int k = Integer.parseInt(input);
//                sb.append(index_poketmon[k]);                         // 배열에서 가져오기
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    // #3 39376KB	560ms            위의 코드와 동일하지만 BufferedWriter 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String input;

        String[] index_poketmon = new String[n + 1];
        Map<String, Integer> poketmon = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            input = br.readLine();
            poketmon.put(input, i);
            index_poketmon[i] = input;
        }

        for(int i = 0; i < m; i++){
            input = br.readLine();
            if(input.charAt(0) >= 'A' && input.charAt(0) <= 'Z'){
                bw.append(String.valueOf(poketmon.get(input)));
            } else{
                int k = Integer.parseInt(input);
                bw.append(index_poketmon[k]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
