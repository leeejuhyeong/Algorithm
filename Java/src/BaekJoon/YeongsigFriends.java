import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class YeongsigFriends {
    public static void main(String[] args) throws IOException {
        int N, M, L;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] circle = new int[N];
        int index = 0;
        int result = 0;
        circle[index]++;

        while(true){
            if(circle[index] == M) break;
            else{
                if(circle[index] % 2 == 0){     // 짝수일 경우 반시계 -> 왼쪽
                    if(index - L < 0){
                        index += N;
                    }
                    index -= L;
                    circle[index]++;
                }
                else{                           // 홀수일 경우 시계 -> 오른쪽
                    int temp = index + L;
                    if(index + L >= N){
                        index -= N;
                    }
                    index += L;
                    circle[index]++;
                }
                result++;
            }
        }

        System.out.println(result);
    }
}
