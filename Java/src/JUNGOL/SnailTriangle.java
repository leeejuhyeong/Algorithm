import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailTriangle {
    public static int count = 0;
    public static int[][] move = {{1, 1}, {0, -1}, {-1, 0}};

    public static int input(){
        if(count == 10) {
            count = 0;
            return count++;
        }
        return count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] Snail = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            Snail[i][i] = input();
        }

        int x = N;
        int y = N;
        int moveway = 1;
        for(int i = N - 1; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                x = x + move[moveway][0];
                y = y + move[moveway][1];
                Snail[x][y] = input();
            }
            moveway++;
            if(moveway == 3) moveway = 0;
        }

        for(int i = 1; i <=N; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(Snail[i][j] + " ");
            }
            System.out.println();
        }

    }
}
