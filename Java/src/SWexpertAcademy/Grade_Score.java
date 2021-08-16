import java.util.*;

public class Grade_Score {
    static String[] score = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            double K_score = 0.0;
            Double[] grade_point = new Double[N];

            for(int i = 0; i < N; i++) {
                int middle_socre = sc.nextInt();
                int final_score = sc.nextInt();
                int sub_score = sc.nextInt();

                double sum = 0.35*middle_socre + 0.45*final_score + 0.2*sub_score;
                grade_point[i] = sum;

                if(K == i + 1) K_score = sum;
            }

            Arrays.sort(grade_point, Collections.reverseOrder());

            int index = 0;
            for(int j =  0; j < N; j++) {
                if(grade_point[j] == K_score) index = j;
            }

            index = index / (N/10);

            System.out.printf("#%d %s\n", test_case, score[index]);
        }
    }
}

