package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_10026_이주형 {
    public static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] rgb = new char[n][];
        int[][] nomal = new int[n][n];
        int[][] rg = new int[n][n];

        for (int i = 0; i < n; i++) {
            rgb[i] = br.readLine().toCharArray();
        }

        int nomalCount, rgCount;
        nomalCount = rgCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if(nomal[i][j] == 0) {
                    nomalCount++;
                    dfsNomal(n, i, j, nomal, nomalCount, rgb);
                }
                if(rg[i][j] == 0){
                    rgCount++;
                    dfsRGB(n, i, j, rg, rgCount, rgb);
                }
            }
        }

        System.out.println(nomalCount + " " + rgCount);
    }

    public static void dfsNomal(int n, int i, int j, int[][] nomal, int nomalCount, char[][] rgb){
        nomal[i][j] = nomalCount;
        int xMove;
        int yMove;

        for(int m = 0; m < 4; m++){
            xMove = i + move[m][0];
            yMove = j + move[m][1];

            if(xMove < 0 || xMove >= n || yMove < 0 || yMove >= n) continue;
            if(nomal[xMove][yMove] != 0) continue;
            if(rgb[i][j] == rgb[xMove][yMove]) dfsNomal(n, xMove, yMove, nomal, nomalCount, rgb);
        }
    }

    public static void dfsRGB(int n, int i, int j, int[][] rg, int rgCount, char[][] rgb){
        rg[i][j] = rgCount;
        int xMove;
        int yMove;

        for(int m = 0; m < 4; m++){
            xMove = i + move[m][0];
            yMove = j + move[m][1];

            if(xMove < 0 || xMove >= n || yMove < 0 || yMove >= n) continue;
            if(rg[xMove][yMove] != 0) continue;
            if(rgb[i][j] == rgb[xMove][yMove]) dfsRGB(n, xMove, yMove, rg, rgCount, rgb);
            else if((rgb[i][j] == 'R' && rgb[xMove][yMove] == 'G') || (rgb[i][j] == 'G' && rgb[xMove][yMove] == 'R')) dfsRGB(n, xMove, yMove, rg, rgCount, rgb);
        }
    }
}
