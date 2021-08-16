import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatiaAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String croatina = br.readLine();            //문자열 그대로 입력
        int result = 0;

        for(int i = croatina.length() - 1; i >= 0; i--){        // 문자열의 뒤부터 시작
            char ch = croatina.charAt(i);
            if(ch == '-' || ch == '=') {        // -나 =이 오면 크로아티아 한단어이기에
                if(i-2 >= 0 && croatina.charAt(i-1) == 'z' && croatina.charAt(i-2) == 'd') i--;     // dz=일경우 3문자가 한단어이기 때문에 i 한번더 감소
                i--;                            // 단어열에서 인덱스 i를 감소시켜줌 -> 두개의 문자가 한 단어이기 때문
            }
            else if(ch == 'j'){
                if(i - 1>= 0 && (croatina.charAt(i-1) == 'l' || croatina.charAt(i-1) == 'n')) { // lj, nj일경우 동일하게 두문자가 한단어이기 때문에 i 인덱스 감소
                    i--;
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
