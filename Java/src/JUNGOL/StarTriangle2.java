import java.io.*;
import java.util.StringTokenizer;

public class StarTriangle2 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void choseOne(int N) throws IOException {
        for(int i = 0; i <= N / 2; i++){
            for(int j = 0; j <= i; j++){
                bw.append("*");
            }
            bw.newLine();
        }
        for(int i = N / 2; i > 0; i--){
            for(int j = i; j > 0; j--){
                bw.append("*");
            }
            if(i != 1) bw.newLine();
        }
        bw.close();
    }

    public void choseTwo(int N) throws IOException {
        for(int i = N/2; i >= 0; i--){
            for(int j = i; j > 0; j--){
                bw.append(" ");
            }
            for(int j =  i; j <= N / 2; j++){
                bw.append("*");
            }
            bw.newLine();
        }
        for(int i = 0; i < N/2; i++){
            for(int j = 0; j <= i; j++){
                bw.append(" ");
            }
            for(int j = i; j < N/2; j++){
                bw.append("*");
            }
            if(i != N/2 - 1) bw.newLine();
        }
        bw.close();
    }

    public void chosetThree(int N) throws IOException {
        for(int i = 0; i <= N/2; i++){
            for(int j = 0; j < i; j++){
                bw.append(" ");
            }
            for(int j = 2*i; j < N; j++){
                bw.append("*");
            }
            bw.newLine();
        }
        for(int i = 0; i < N/2; i++){
            for(int j =i; j < N/2 - 1; j++){
                bw.append(" ");
            }
            for(int j = 0; j < 2*(i+1)+1; j++){
                bw.append("*");
            }
            if(i != N/2 - 1) bw.newLine();
        }
        bw.close();
    }

    public void choseFour(int N) throws IOException {
        for(int i = 0; i <= N/2; i++){
            for(int j = 0; j < i; j++){
                bw.append(" ");
            }
            for(int j = i; j <= N/2; j++){
                bw.append("*");
            }
            bw.newLine();
        }
        for(int i = 0; i < N/2; i++){
            for(int j = 0; j <N/2; j++){
                bw.append(" ");
            }
            for(int j = 0; j <= i + 1; j++){
                bw.append("*");
            }
            if(i != N/2 - 1) bw.newLine();
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StarTriangle2 starTriangle2 = new StarTriangle2();

        int N = Integer.parseInt(st.nextToken());
        int select = Integer.parseInt(st.nextToken());


        if(N <= 0 || N > 100 || select <= 0 || select >= 5 || N % 2 == 0) System.out.println("INPUT ERROR!");
        else{
            if(select == 1) starTriangle2.choseOne(N);
            else if(select == 2) starTriangle2.choseTwo(N);
            else if(select == 3) starTriangle2.chosetThree(N);
            else if(select == 4) starTriangle2.choseFour(N);
        }
    }
}


