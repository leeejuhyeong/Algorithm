package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1992_이주형 {
    static String[][] map;
    static String result = "";

    public static void quardTree(int r, int c, int n) {
        if(n == 1) {
            result = map[0][0];
            return;
        }
        if (n == 2) {
            String temp = "(" + map[r][c] + map[r][c + 1] + map[r + 1][c] + map[r + 1][c + 1] + ")";
            result += temp;
            return;
        }
        result += "(";
        quardTree(r, c, n / 2);
        quardTree(r, c + n / 2, n / 2);
        quardTree(r + n / 2, c, n / 2);
        quardTree(r + n / 2, c + n / 2, n / 2);
        result += ")";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.substring(j, j + 1);
            }
        }

        quardTree(0, 0, n);

        while (result.contains("(1111)") || result.contains("(0000)")) {
            if (result.contains("(1111)")) result = result.replace("(1111)", "1");
            if (result.contains("(0000)")) result = result.replace("(0000)", "0");
        }

        System.out.println(result);
    }
}

/*
((110(0101))(0010)1(0001))
 */