import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StarTriangle1 {

    public void choseOne(int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void choseTwo(int N) {
        for(int i = 0; i < N; i++){
            for(int j = N - i; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void chosetThree(int N) {
        for(int i = 0; i < N; i++){
            for(int j = i; j < N - 1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i*2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StarTriangle1 starTriangle1 = new StarTriangle1();

        int N = Integer.parseInt(st.nextToken());
        int select = Integer.parseInt(st.nextToken());

        if(N < 0 || N >= 100 || select < 0 || select > 3) System.out.println("INPUT ERROR!");
        else{
            if(select == 1) starTriangle1.choseOne(N);
            else if(select == 2) starTriangle1.choseTwo(N);
            else starTriangle1.chosetThree(N);
        }
    }
}
