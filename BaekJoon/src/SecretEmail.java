import java.io.*;

public class SecretEmail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String security = br.readLine();

        int n = security.length();
        int r = 1;          // r은 c보다 같거나 작은 r*c = N인 값이기 때문에 1부터 시작
        int c;
        for(int i = 1; i <= n/i; i++){ //r을 1씩 증가시키면서 n을 나눴을 때 나누어떨어지면서 가장 큰값 찾음
            if(n % i == 0){
                r = i;
            }
        }
        c = n / r;
        char[][] incoding = new char[r][c];

        int cnt = 0;

        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                incoding[j][i] = security.charAt(cnt++);            // 입력받은 문자열은 암호화된 것이기 때문에 배열에 행과 열을 바꿔서 넣어줌
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.append(incoding[i][j]);              // 행과 열을 원래대로 돌려주면서 디코딩한 암호 출력
            }
        }
        bw.flush();
        bw.close();
    }
}
