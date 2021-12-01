package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algo_2239_이주형 {
    final public static int n = 9;

    public static class Number{
        int x, y;
        Number(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoke = new int[n][n];
        List<Number> numbers = new ArrayList<>();
        char[] input;

        for (int i = 0; i < n; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                sudoke[i][j] = input[j] - '0';
                if(sudoke[i][j] == 0) numbers.add(new Number(i, j));
            }
        }

        go(0, sudoke, numbers);

    }

    // 문제점
    // 1. 완탐시킴
    // 2. 기저조건 생성 X
    // => 백트레킹이라는 것을 눈치채지못했다는것이 가장 큰 문제점입니다아아아ㅏ아아ㅏ..

    public static void go(int level, int[][] sudoke, List<Number> numbers){
        if(level == numbers.size()) {
            StringBuilder sb = new StringBuilder();
            for(int[] a : sudoke){
                for(int num : a){
                    sb.append(num);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        int x = numbers.get(level).x;
        int y = numbers.get(level).y;

        boolean[] visited = new boolean[n + 1];
        // 가로
        for(int i = 0; i < n; i++){
            visited[sudoke[x][i]] = true;
        }
        // 세로
        for(int i = 0; i < n; i++){
            visited[sudoke[i][y]] = true;
        }
        // 3*3사각형
        for(int i = 3 * (x / 3); i < 3 * (x / 3) + 3; i++){
            for(int j = 3 * (y / 3); j < 3 * (y / 3) + 3; j++) {
                visited[sudoke[i][j]] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                sudoke[x][y] = i;
                go(level + 1, sudoke, numbers);
                sudoke[x][y] = 0;
            }
        }
    }



}
/*
103000509
002109400
000704000
300502006
060000050
700803004
000401000
009205800
804000107
 */