package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_1244_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] switches = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());
        int gender, index;

        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            index = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = 1; j * index <= n; j++) {
                    switches[j * index] = (switches[j * index] + 1) % 2;
                }
            } else {
                switches[index] = (switches[index] + 1) % 2;
                int j = 1;
                while (index - j > 0 && index + j <= n && switches[index - j] == switches[index + j]) {
                    switches[index - j] = switches[index + j] = (switches[index - j] + 1) % 2;
                    j++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.append(String.valueOf(switches[i])).append(" ");
            if (i % 20 == 0) bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
