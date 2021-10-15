package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class algo_1755_이주형 {
    public static class Dictionary {    // num : 숫자, numToString : 숫자를 영어로 바꾼 문자열
        int num;
        char[] numToString;

        Dictionary(int num, String numToString) {
            this.num = num;
            this.numToString = numToString.toCharArray();    // 문자열은 char형의 배열로 저장
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Dictionary> program = new LinkedList<>();    // 사전 순으로 정렬하는 프로그램 리스트
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; // 각각 index숫자에 해당하는 문자를 배열에 저장
        String input;        // 다음 숫자
        StringBuilder sb;


        for (int i = m; i <= n; i++) {
            sb = new StringBuilder();
            input = String.valueOf(i); // M이상 N이하의 정수를 문자열로 변환

            for (int j = 0; j < input.length(); j++) {    // 문자열의 자리수만큼 반복
                int num = input.charAt(j) - '0';        // 각 자리수의 숫자를 확인해서
                sb.append(numbers[num]);                // 영어 단어로 변환
            }

            program.add(new Dictionary(i, sb.toString()));    // M이상, N이하 정수와 영어 단어로 변환한 것을 Dictionary객체에 저장해서 program리스트에 저장.

        }

        // 저장된 Dictionary 객체를 영어 단어 사전순으로 정렬
        Collections.sort(program, new Comparator<Dictionary>() {

            @Override
            public int compare(Dictionary o1, Dictionary o2) {
                // TODO Auto-generated method stub
                int o1Len = o1.numToString.length;
                int o2Len = o2.numToString.length;

                int len = o1Len >= o2Len ? o2Len : o1Len;

                for (int i = 0; i < len; i++) {        // 사전 순으로 정렬
                    if (o1.numToString[i] < o2.numToString[i]) return -1;
                    else if (o1.numToString[i] > o2.numToString[i]) return 1;
                }
                if (len == o2Len) return 1;    // 문자열이 같을 경우 길이가 짧은 것이 먼저 오도록 정렬
                else return -1;
            }
        });

        // 사전 순으로 정렬된 정수를 10개씩 출력
        for (int i = 0; i < n - m + 1; i++) {
            bw.append(String.valueOf(program.get(i).num)).append(" ");
            if ((i + 1) % 10 == 0) bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}