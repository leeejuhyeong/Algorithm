import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2491_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int up = 0;
        int down = 0;
        int upCount = 1;
        int downCount = 1;

        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n - 1; i++){
            int num = Integer.parseInt(st.nextToken());
            if(temp == num){
                upCount++;
                downCount++;
            } else if(temp < num){
                upCount++;
                down = downCount > down ? downCount : down;
                downCount = 1;
            } else{
                downCount++;
                up = upCount > up ? upCount : up;
                upCount = 1;
            }
            temp = num;
        }
        up = upCount > up ? upCount : up;
        down = downCount > down ? downCount : down;

        int result = Math.max(up, down);
        System.out.println(result);
    }
}
