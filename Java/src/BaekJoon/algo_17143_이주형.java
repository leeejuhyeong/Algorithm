package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_17143_이주형 {
    public static int[] moveR = {0, -1, 1, 0, 0};
    public static int[] moveC = {0, 0, 0, 1, -1};

    public static class Shark {
        int r, c, s, d, z;      // 행, 열, 이동속도, 이동방향, 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r, c, m;
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Shark>[] sharks = new List[c + 1];
        for (int i = 0; i <= c; i++) {
            sharks[i] = new ArrayList<>();

        }

        int[] input;
        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sharks[input[1]].add(new Shark(input[0], input[1], input[2], input[3], input[4]));
        }

        int result = 0;
        for (int i = 1; i <= c; i++) {
            result += fishing(i, sharks[i]);

//            System.out.println("낚시 하고");
//            for(List a : sharks){
//                System.out.println(a.toString());
//            }
//            System.out.println(result);

            sharks = move(sharks, r, c);
        }
        System.out.println(result);
    }

    private static int fishing(int c, List<Shark> sharks) {
        int minIdx = -1;
        int weight = 0;
        int minRow = Integer.MAX_VALUE;
        Shark current;

        for (int i = 0; i < sharks.size(); i++) {
            current = sharks.get(i);
            if (current.r < minRow) {
                minIdx = i;
                minRow = current.r;
                weight = current.z;
            }
        }
        if (minIdx != -1) sharks.remove(minIdx);
        return weight;
    }

    private static List<Shark>[] move(List<Shark>[] sharks, int r, int c) {
        List<Shark>[] newSharks = new List[c + 1];
        for (int i = 0; i <= c; i++) {
            newSharks[i] = new LinkedList<>();
        }

        Shark current;
        for (int i = 1; i <= c; i++) {
            int size = sharks[i].size();
            for (int j = 0; j < size; j++) {
                current = sharks[i].get(j);
                int temp = current.s;

                if(current.d == 1 || current.d == 2){
                    temp %= (r - 1) * 2;
                } else if(current.d == 3 || current.d == 4){
                    temp %= (c - 1) * 2;
                }

                int t = 0;
                while (t++ < temp) {
                    if (current.r + moveR[current.d] > r || current.c + moveC[current.d] > c || current.r + moveR[current.d] < 1 || current.c + moveC[current.d] < 1){
                        switch(current.d){
                            case 1:
                                current.d = 2;
                                break;
                            case 2:
                                current.d = 1;
                                break;
                            case 3:
                                current.d = 4;
                                break;
                            case 4:
                                current.d = 3;
                                break;
                        }
                    }

                    current.r += moveR[current.d];
                    current.c += moveC[current.d];
                }

                if (newSharks[current.c].size() == 0) {
                    newSharks[current.c].add(current);
                    continue;
                }
                boolean flag = true;
                for (int eat = 0; eat < newSharks[current.c].size(); eat++) {
                    if (newSharks[current.c].get(eat).r == current.r) {
                        if (newSharks[current.c].get(eat).z < current.z) {
                            newSharks[current.c].remove(eat);
                            newSharks[current.c].add(current);
                        }
                        flag = false;
                    }
                }
                if(flag) newSharks[current.c].add(current);
            }
        }
        return newSharks;
    }

}
/*
2 2 4
1 1 99 1 5
1 2 98 2 6
2 1 1 3 4
2 2 0 4 3
 */

