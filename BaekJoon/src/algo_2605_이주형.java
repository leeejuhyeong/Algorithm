import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 14204KB, 140ms
public class algo_2605_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());        // 학생의 수

        LinkedList<Integer> student = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        // 1 2 3 4 5
        // 0 1 1 3 2 - 각자 뽑은 번호표
        // 1 -> 2 1 -> 2 3 1 -> 4 2 3 1 -> 4 2 5 3 1

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());        // 학생이 뽑은 번호표
            int sequence = student.size();
            student.add(sequence - temp, i + 1);    // index(list의 사이즈 - 학생이 뽑은 번호)번으로 링크리스트에 삽입
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(student.get(i)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
