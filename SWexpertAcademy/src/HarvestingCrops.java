import java.util.Scanner;

public class HarvestingCrops {
    public static int[][] map;
    public int solution(int N, int[][] map){
        int sum = 0;
        for(int i = 0; i <= N / 2; i++){
            for(int j = N/2 - i; j <= N/2 +i; j++){
                sum += map[i][j];
            }
        }
        for(int i = 0; i < N/2; i++){
            for(int j = N/2 - i; j <= N/2 +i; j++){
                sum += map[N-i-1][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        HarvestingCrops harvestingCrops = new HarvestingCrops();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = scanner.nextInt();
            map =  new int[N][N];
            for(int i = 0; i < N; i++){
                String temp = scanner.next();
                for(int j = 0; j < N; j++){
                    map[i][j] = temp.charAt(j) - '0';
                }
            }
            int result = harvestingCrops.solution(N, map);

            System.out.println("#" + test_case +" " + result);
        }
    }
}
