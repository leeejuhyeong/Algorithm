import java.util.Arrays;

public class Permutation1 {
    static int n = 3;
    static int m = 2;
    static int[] input;
    static int[] numbers;
    static boolean[] visited;

    public static void permutation(int cnt){
        if(cnt == m){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            numbers[cnt] = input[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    public static void bitPermu(int cnt, int flag){
        if(cnt == m){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 0; i < n; i++){
            if((flag & 1 << i) != 0) continue;

            numbers[cnt] = input[i];
            bitPermu(cnt + 1, flag | 1 << i);
        }
    }

    public static boolean nextPermutation(int[] input){
        int i = n - 1;
        while(i > 0 && input[i-1] >= input [i]) i--;
        if(i == 0) return false;

        int j = n - 1;
        while(input[i-1] >= input[j]) j--;

        swap(input, i - 1, j);

        int k = n - 1;
        while(i < k){
            swap(input, i++, k--);
        }

        return true;
    }

    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        input = new int[] {1, 4, 7};
        int[] input1 = new int[] {3, 7, 5};
        numbers = new int[m];
        visited = new boolean[n];

//        permutation(0);
//        bitPermu(0, 0);

        Arrays.sort(input1);

        do{
            System.out.println(Arrays.toString(input1));
        } while(nextPermutation(input1));


    }
}
