import java.util.Arrays;

public class subSet {
    static int n;
    static int[] input;
    static int[] number;

    public static void subset(int size, int level,  int cnt){
        if(size == cnt){
            System.out.println(Arrays.toString(number));
            return;
        }

        for(int i = level; i < n; i++){
            number[cnt] = input[i];
            subset(size, i + 1, cnt + 1);
        }
    }
    public static void main(String[] args) {
        n = 5;
        input = new int[]{1, 2, 3, 4, 5};

        for(int size = 1; size <= n; size++){
            number = new int[size];
            subset(size, 0, 0);
        }
    }
}
