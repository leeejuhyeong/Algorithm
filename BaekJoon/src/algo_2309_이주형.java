import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_2309_이주형 {
    static int n;
    static int r;
    static int[] dwarfs;
    static boolean flag;

    // 재귀
    public static void permutation(boolean[] isSeleted, int i, int max) {
        if(flag) return;
        if (max == 7) {
            int sum = 0;
            for (int j = 0; j < isSeleted.length; j++) {
                if (isSeleted[j]) sum += dwarfs[j];
            }
            if (sum == 100) {
                int[] result = new int[7];
                int count = 0;

                for (int j = 0; j < n; j++) {
                    if (isSeleted[j]) result[count++] = dwarfs[j];
                }
                Arrays.sort(result);
                for (int answer : result) {
                    System.out.println(answer);
                }
                flag = true;
            }
        }

        if (i < 9) {
            isSeleted[i] = true;
            permutation(isSeleted, i + 1, max+1);
            isSeleted[i] = false;
            permutation(isSeleted, i + 1, max);
        }
    }

    // #2 NP
    public static boolean np(int[] visited){
        int i = n - 1;
        while(i > 0 && visited[i-1] >= visited[i]) i--;
        if(i == 0) return false;

        int j = n - 1;
        while(visited[i-1] >= visited[j]) j--;

        swap(visited, i-1, j);

        int k = n - 1;
        while(i < k){
            swap(visited, i++, k--);
        }
        return true;
    }

    public static void swap(int[] visited, int i, int j){
        int temp = visited[i];
        visited[i] = visited[j];
        visited[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = 9;
        r = 7;
        dwarfs = new int[9];
        boolean[] isSeleted = new boolean[9];

        for (int i = 0; i < n; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        // #1. 재귀
//        flag = false;
//        permutation(isSeleted, 0, 0);


        // #2. NP
        int count = 9;
        int[] visited = new int[9];
        while(count > 2) visited[--count] = 1;

        do{
            int sum = 0;
            for(int i = 0 ; i < 9; i++){
                if(visited[i] == 1) sum += dwarfs[i];
            }
            if(sum == 100){
                int[] result = new int[7];
                count = 0;
                for(int i = 0; i < 9; i++){
                    if(visited[i] == 1) result[count++] = dwarfs[i];
                }
                Arrays.sort(result);
                for(int answer : result){
                    System.out.println(answer);
                }
                break;
            }
        }while(np(visited));

    }
}
