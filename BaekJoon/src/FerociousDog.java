import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FerociousDog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a_attck = Integer.parseInt(st.nextToken());
        int a_rest = Integer.parseInt(st.nextToken());
        int b_attck = Integer.parseInt(st.nextToken());
        int b_rest = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] persons = new int[3];
        for(int i =0; i < 3; i++){
            persons[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++){
            int count = 0;
            if((persons[i]%(a_attck+a_rest)) > 0 && (persons[i]%(a_attck+a_rest)) <= a_attck) count++;
            if((persons[i]%(b_attck+b_rest)) > 0 && (persons[i]%(b_attck+b_rest)) <= b_attck) count++;
            System.out.println(count);
        }
    }
}
