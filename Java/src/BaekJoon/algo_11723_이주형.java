package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_11723_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] set = new int[21];            // x의 범위는 1 이상 20 이하이므로 21개수의 배열 생성
        String input;
        int inputNum, s;
        s = -1;                             // S집합에 추가된 x를 음수로 표시

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();

            switch (input) {
                case "add":         // 집합 S에 x추가
                    inputNum = Integer.parseInt(st.nextToken());
                    set[inputNum] = s;      // x번째 인덱스 표시
                    break;
                case "remove":      // x 삭제
                    inputNum = Integer.parseInt(st.nextToken());
                    set[inputNum] = 0;      // x번째 인덱스에 0삽입
                    break;
                case "check":       // x가 있다면 1 없으면 0 출력
                    inputNum = Integer.parseInt(st.nextToken());    // x
                    if (set[inputNum] == s) bw.append(String.valueOf(1));   // x가 있다면 1출력
                    else bw.append(String.valueOf(0));                      // 없다면 0출력
                    bw.newLine();
                    break;
                case "toggle":      // x가있다면 제거, 없다면 추가
                    inputNum = Integer.parseInt(st.nextToken());
                    if (set[inputNum] == s) set[inputNum] = 0;          // 있을 시 0삽입해서 제거
                    else set[inputNum] = s;                             // 없다면 추가
                    break;
                case "all":         // 모두 추가
                    Arrays.fill(set, s);
                    break;
                case "empty":       // 배열을 비우기보단 s를 1작게 만들어주었음
                    s--;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}