import java.util.Scanner;
import java.io.FileInputStream;

class Counselor_of_love{
    long result = 80000000000L;

    public long solution(int[][] worms) {
        int plus = worms.length / 2;
        int minus = worms.length / 2;
        int[] save = new int[]{0, 0};

        DFS(save, plus, minus, worms, 0);
        return result;
    }

    public void DFS(int[] save, int plus, int minus, int[][] worms, int level) {
        if (level == worms.length) {
            result = (long) Math.min(result, Math.pow(save[0], 2) + Math.pow(save[1], 2));
        } else {
            if (plus == 0) {
                save[0] -= worms[level][0];
                save[1] -= worms[level][1];
                DFS(save, plus, minus - 1, worms, level+1);
                save[0] += worms[level][0];
                save[1] += worms[level][1];
            }
            else if(minus == 0){
                save[0] += worms[level][0];
                save[1] += worms[level][1];
                DFS(save, plus - 1, minus, worms, level+1);
                save[0] -= worms[level][0];
                save[1] -= worms[level][1];
            }
            else {
                save[0] += worms[level][0];
                save[1] += worms[level][1];
                DFS(save, plus - 1, minus, worms, level+1);
                save[0] -= 2*worms[level][0];
                save[1] -= 2*worms[level][1];
                DFS(save, plus, minus - 1, worms, level+1);
                save[0] += worms[level][0];
                save[1] += worms[level][1];
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Counselor_of_love counselor_of_love = new Counselor_of_love();

            int N = sc.nextInt();
            int[][] worms = new int[N][2];

            for(int i = 0; i<N; i++){
                worms[i][0] = sc.nextInt();
                worms[i][1] = sc.nextInt();
            }

            long solution = counselor_of_love.solution(worms);
            System.out.print("#" + test_case + " ");
            System.out.println(solution);

        }
    }
}