package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 14316KB, 128ms
public class algo_2628_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[0]);

        boolean[] row = new boolean[r];             // 행 자른 위치 확인
        boolean[] col = new boolean[c];             // 열 자른 위치 확인

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            input = br.readLine().split(" ");

            if (Integer.parseInt(input[0]) == 0) {      // 행
                row[Integer.parseInt(input[1])] = true;             // 잘랐을 때 true
            } else {                                    // 열
                col[Integer.parseInt(input[1])] = true;
            }
        }

        List<Integer> rowList = new ArrayList<>();          // row의 잘린 길이 저장
        List<Integer> colList = new ArrayList<>();          // col의 잘린 길이 저장
        int rCount = 0;
        int cCount = 0;

        for (int i = 0; i < r; i++) {
            if (row[i]) {
                rowList.add(rCount);        // 자른 종이의 높이를 rowList에 저장
                rCount = 0;
            }
            rCount++;               // 자른 곳(ture)를 만날때까지 증가
        }
        rowList.add(rCount);        // 마지막 조각 저장

        for (int i = 0; i < c; i++) {
            if (col[i]) {
                colList.add(cCount);       // 자른 종이의 너비를 colList에 저장
                cCount = 0;
            }
            cCount++;               // 자른 곳(ture)를 만날때까지 증가
        }
        colList.add(cCount);       // 마지막 조각 저장

        int area = 0;
        for(int rowlist : rowList){
            for(int collist : colList){
                area = Math.max(area, rowlist * collist);   // 가장 큰 넓이 찾기
            }
        }

        System.out.println(area);
    }
}
