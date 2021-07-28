import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack {
    public static int N;
    public static int M;
    public static int result;
    public static int[] check;
    public static void DFS(int level, int[] Card, int sum){ // 넘으면안됌
        if(level == 3) {
            if (sum <= M) {
                int original = Math.abs(M - result);
                int newNum = Math.abs(M - sum);
                if (newNum < original) result = sum;
            }
        }
        else{
            for(int j = 0; j<N; j++){
                if(check[j] == 0){
                    check[j]++;
                    sum += Card[j];
                    DFS(level+1, Card, sum);
                    check[j]--;
                    sum -= Card[j];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        int[] Card = new int[N];
        for(int i = 0; i < N; i++){
            Card[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, Card, sum);

        System.out.println(result);
    }
}

