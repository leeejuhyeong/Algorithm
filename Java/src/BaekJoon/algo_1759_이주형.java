package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_1759_이주형 {
    public static boolean np(int[] check, int c) {
        int i = c - 1;
        while (i > 0 && check[i - 1] >= check[i]) i--;
        if (i == 0) return false;

        int j = c - 1;
        while (check[i - 1] >= check[j]) j--;

        swap(check, i - 1, j);

        int k = c - 1;
        while (i < k) {
            swap(check, i++, k--);
        }
        return true;
    }

    public static void swap(int[] check, int i, int j) {
        int temp = check[i];
        check[i] = check[j];
        check[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        List<char[]> answers = new ArrayList<>();

        int l = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] numbers = new char[c];
        for (int i = 0; i < c; i++) {
            numbers[i] = st.nextToken().charAt(0);
        }

        int[] check = new int[c];

        int t = 1;
        while (t <= l) check[c - t++] = 1;

        do {
            int aeiou = 0;
            int others = 0;
            char[] result = new char[l];
            int count = 0;

            for (int i = 0; i < c; i++) {
                if (check[i] == 1) {
                    result[count++] = numbers[i];
                    if (numbers[i] == 'a' || numbers[i] == 'e' || numbers[i] == 'i' || numbers[i] == 'o' || numbers[i] == 'u')
                        aeiou++;
                    else others++;
                }
            }

            if (aeiou >= 1 && others >= 2) {
                Arrays.sort(result);
                answers.add(result);
            }
        } while (np(check, c));

        Collections.sort(answers, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                for (int i = 0; i < o1.length - 1; i++) {
                    if (o1[i] == o2[i]) continue;
                    else return o1[i] - o2[i];
                }
                return o1[o1.length - 1] - o2[o1.length - 1];
            }
        });

        for (int i = 0; i < answers.size(); i++) {
            for (char a : answers.get(i)) {
                bw.append(a);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

/*
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
 */
