package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class algo_10163_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int papers = Integer.parseInt(br.readLine());

        boolean[][] area = new boolean[1002][1002];

        List<int[]> paper = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        int x, y, width, height;            // x, y, 너비, 높이 저장
        x = y = width = height = 0;

        for (int i = 0; i < papers; i++) {
            st = new StringTokenizer(br.readLine());        // paper 리스트에 저장
            paper.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = papers - 1; i >= 0; i--) {     // 리스트 뒤에서부터
            int[] temp = paper.get(i);
            int count = 0;

            for (int row = temp[0]; row < temp[0] + temp[2]; row++) {
                for (int col = temp[1]; col < temp[1] + temp[3]; col++) {
                    if (!area[row][col]) {                  // 영역에서 ture가 아닐 때
                        area[row][col] = true;              // 체크
                        count++;                            // ture가 아님은 가리는 색종이가 없다는 의미.
                    }
                }
            }
            result.add(0, count);                   // reuslt 리스트 첫번째의 저장 -> for문이 paper리스트의 뒤에서부터 반복하기 때문에
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : result) {
            bw.append(String.valueOf(a));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
