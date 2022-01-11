package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class algo_5639_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> tree = new ArrayList<>();

        String input = "";
        while (true) {
            input = br.readLine();
            if (input == null || input.length() == 0)       // null이거나 길이가 0일때 중지
                break;
            tree.add(Integer.parseInt(input));
        }

        int size = tree.size();

        if (size != 0)
            divide(0, size - 1, tree, bw);
        bw.flush();
        bw.close();
    }

    private static void divide(int start, int end, List<Integer> tree, BufferedWriter bw) throws IOException {      // 루트의 왼쪽 자식과 오른쪽 자식을 나누어가면서 탐색
        int root = tree.get(start);

        int index;
        for (index = start + 1; index <= end; index++) {        // root보다 커지는 값(오른쪽 노드가 시작하는 index 찾기)
            if (root < tree.get(index)) {
                break;
            }
        }

        // 후위탐색 왼쪽 -> 오른쪽 -> 루트 순서임으로

        // 왼쪽 트리부터
        if (index != start + 1) {     // 왼쪽 트리가 있을 때만(없는 경우 = index == start + 1)
            if (start + 1 == index - 1)
                bw.write(tree.get(start + 1) + "\n");
            else
                divide(start + 1, index - 1, tree, bw);
        }

        // 오른쪽 트리
        if (index <= end) {           // 오른쪽 트리가 있을 때만(없는경우 index > end 보다 클때)
            if (index == end)
                bw.write(tree.get(index) + "\n");
            else
                divide(index, end, tree, bw);
        }

        // 루트
        bw.write(root + "\n");
    }
}
