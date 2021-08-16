import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
    static int n;
    static int m;
    static int count;
    static int[] numbers;
    static boolean[] isSeleted;
    static int[] permunums;

    public static void permutation(int level, int cnt){
        if(cnt == m) {
            for(int i = 0; i < n; i++){
                if(isSeleted[i]) System.out.print(numbers[i] + " ");
            }
            System.out.println();
            count++;
            return;
        }
        if(level < n) {
            isSeleted[level] = true;
            permutation(level + 1, cnt + 1);
            isSeleted[level] = false;
            permutation(level + 1, cnt);
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = 0;
        permunums = new int[m];
        isSeleted = new boolean[n];

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        permutation(0, 0);
        System.out.println("순열 개수 : " + count);
    }

}