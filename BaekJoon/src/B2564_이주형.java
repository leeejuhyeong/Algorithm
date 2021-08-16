import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2564_이주형 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] block = br.readLine().split(" ");
        int h = Integer.parseInt(block[0]);         // 가로길이
        int v = Integer.parseInt(block[1]);         // 세로길이

        int store_idx = Integer.parseInt(br.readLine());    // 상점 개수
        int[][] stores = new int[store_idx][];      // 상점 인덱스 배열

        for(int i = 0; i < store_idx; i++){
            stores[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] person = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 동근이의 위치

        int result = 0;
        for(int i = 0; i < store_idx; i++) {
            if (person[0] == 1 || person[0] == 2) { // 동근이가 1(북쪽), 2(남쪽) 일때

                if(stores[i][0] == person[0]) result += Math.abs(stores[i][1] - person[1]); // 같은 라인에 있을 경우 절대값으로 더해줌
                else if(stores[i][0] == 1 || stores[i][0] == 2){                        // 반대편 라인에 있을 경우
                    int min = Math.min(person[1] + stores[i][1], h - person[1] + h - stores[i][1]); // 왼쪽으로 갔을 때와 오른쪽으로 갔을 때 중에서 작은 값 구하기
                    result += min + v;
                }

                else{                                 // 자신의 양 옆 라인에 있을 경우
                    if(person[0] == 1){     // 내가 1(북쪽)일 때
                        if(stores[i][0] == 3) result+= person[1] + stores[i][1]; // 가게가 3(서쪽)이라면 내 위치 + 가게의 위치
                        else result += h - person[1] + stores[i][1];            // 가게가 4(동쪽)이라면 (가로길이 - 내위치) + 가게의 위치
                    } else{                 // 내가 2(남쪽)일 때
                        if(stores[i][0] == 3) result += person[1] + v - stores[i][1];   // 가게가 3(서쪽)이라면 내 위치 + (세로길이 - 가게위치)
                        else result += h - person[1] + v - stores[i][1];                // 가게가 4(동쪽)이라면 (가로길이 - 내위치) + (세로길이 - 가게위치)
                    }
                }

            }

            else {            // 동근이가 3(서쪽), 4(동쪽) 일때
                if(stores[i][0] == person[0]) result += Math.abs(stores[i][1] - person[1]);
                else if(stores[i][0] == 3 || stores[i][0] == 4){
                    int min = Math.min(person[1] + stores[i][1], h - person[1] + h - stores[i][1]);
                    result += min + v;
                }

                else{
                    if(person[0] == 3){
                        if(stores[i][0] == 1) result+= person[1] + stores[i][1];
                        else result += v - person[1] + stores[i][1];
                    } else{
                        if(stores[i][0] == 1) result += person[1] + h - stores[i][1];
                        else result += v - person[1] + h - stores[i][1];
                    }
                }
            }
        }
        System.out.println(result);
    }
}
