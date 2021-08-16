import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class permutationRecursion {
    static int n;
    static int m;
    static int count;
    static int[] numbers;
    static int[] permu;
    static boolean[] isSeleted;

    public static void permutation(int cnt){
        if(cnt == m) {
            System.out.println(Arrays.toString(permu));
            count++;
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!isSeleted[i]){
                isSeleted[i] = true;
                permu[cnt] = numbers[i];
                permutation(cnt + 1);
                isSeleted[i] = false;
            }
        }
    }

    public static void permutationall(int cnt){
        if(cnt == n){
            for(int i = 0; i < n; i++){
                System.out.print(permu[i] + " ");
            }
            System.out.println();
            count++;
        }
        for(int j = 0; j < n; j++){
            if(isSeleted[j]) continue;
            isSeleted[j] = true;
            permu[cnt] = numbers[j];
            permutationall(cnt+1);
            isSeleted[j] = false;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = 0;
        isSeleted = new boolean[n];
        permu = new int[m];

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        permutation(0);
        permutationall(0);
        System.out.println("순열 개수 : " + count);
    }
}
