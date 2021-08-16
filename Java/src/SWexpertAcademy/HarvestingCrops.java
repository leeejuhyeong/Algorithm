import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        HarvestingCrops harvestingCrops = new HarvestingCrops();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            map =  new int[N][N];
            for(int i = 0; i < N; i++){
                String temp = br.readLine();
                for(int j = 0; j < N; j++){
                    map[i][j] = temp.charAt(j) - '0';
                }
            }
            int result = harvestingCrops.solution(N, map);

            System.out.println("#" + test_case +" " + result);
        }
    }
}
