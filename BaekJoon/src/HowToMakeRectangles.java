import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowToMakeRectangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int result = 0;
        int count = (int) Math.sqrt(T);

        for(int i = 1; i <= count; i++){
            for(int j = i; j <= T; j++){
                if(i * j <= T) result++;
                else break;
            }
        }
        System.out.println(result);
    }
}
