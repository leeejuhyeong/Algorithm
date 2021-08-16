import java.util.Arrays;

public class Combination {
    static int[] input;
    static int[] number;
    static int n = 4;
    static int m = 3;

    public static void combination(int level, int cnt) {
        if (cnt == m) {
            System.out.println(Arrays.toString(number));
            return;
        }

        for (int i = level; i < n; i++) {
            number[cnt] = input[i];
            combination(i + 1, cnt + 1);
        }
    }

    public static boolean nextCombin(int[] numbers) {
        int i = n - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) i--;
        if (i == 0) return false;

        int j = n - 1;
        while (numbers[i - 1] >= numbers[j]) j--;

        swap(numbers, i - 1, j);

        int k = n - 1;
        while(i < k){
            swap(numbers, i++, k--);
        }
        return true;
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        input = new int[]{1, 3, 5, 7};
        int[] numbers = new int[n];
        number = new int[m];

//        combination(0, 0);

        int count = 0;
        while (++count <= m) numbers[n - count] = 1;

        do {
            for (int i = 0; i < n; i++) {
                if (numbers[i] == 1) {
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
        } while (nextCombin(numbers));


    }
}
