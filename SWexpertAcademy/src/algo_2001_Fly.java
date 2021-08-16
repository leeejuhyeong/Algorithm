import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_2001_Fly {
    static int[][] flys;
    static int[][] sum;

    public static int getMAX(int x, int y, int x_m, int y_m){
        return sum[x][y] - sum[x_m][y] - sum[x][y_m] + sum[x_m][y_m];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++){
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);       // N
            int m = Integer.parseInt(nm[1]);       // M(파리채 크기)

            flys = new int[n+1][n+1];
            sum = new int[n+1][n+1];

            for(int i = 1; i <= n; i++){
                String[] fly = br.readLine().split(" ");
                for(int j = 1; j <= n; j++){
                    flys[i][j] = Integer.parseInt(fly[j-1]);
                }
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + flys[i][j];        //  부분합 연산
                }
            }

            int MAX = Integer.MIN_VALUE;
            for(int i = m; i <= n; i++){
                for(int j = m; j <= n; j++){
                    MAX = Math.max(MAX, getMAX(i, j, i-m, j-m));     // max값 구하기
                }
            }

            System.out.println("#" + test_case + " " + MAX);
        }
    }
}

/*
#1 49
#2 159
#3 428
#4 620
#5 479
#6 941
#7 171
#8 968
#9 209
#10 1242
 */
