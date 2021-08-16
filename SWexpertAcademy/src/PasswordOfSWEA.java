import java.util.Scanner;

public class PasswordOfSWEA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = scanner.nextInt();

            int[] password = new int[N];


            String password_string = scanner.next();


            for (int n = 0; n < N; n++) {
                password[n] = password_string.charAt(n) - '0';
            }



            int same = password[N - 1];
            int same_index = N - 1;


            for (int i = N - 2; i >= 0; i--) {
                if (password[i] != -1 && same_index != i) {
                    if (password[i] != same) {
                        same = password[i];
                        same_index = i;
                    } else {
                        password[i] = -1;
                        password[same_index] = -1;

                        while (true) {
                            if (same_index + 1 == N) {
                                same_index = i - 1;
                                same = password[same_index];
                                break;
                            } else {
                                if (password[same_index + 1] == -1) same_index++;
                                else {
                                    same = password[++same_index];
                                    break;
                                }
                            }
                        }

                    }
                }
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                if (password[i] != -1) System.out.print(password[i]);
            }
            System.out.println();

        }

    }
}
