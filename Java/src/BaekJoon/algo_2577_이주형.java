package BaekJoon;

import java.io.*;

public class algo_2577_이주형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = 1;
        for (int i = 0; i < 3; i++) {
            number *= Integer.parseInt(br.readLine());
        }

        int[] numbers = new int[10];

        while (number > 0) {
            numbers[number % 10]++;
            number /= 10;
        }

        for (int i : numbers) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
