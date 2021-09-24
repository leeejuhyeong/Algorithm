package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_2206_이주형 {
    public static int n, m, result;
    public static char[][] map;
    public static boolean[][][] visited;
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static class Person {
        int x, y, crush;

        Person(int x, int y, int crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }

    }

    public static int bfs() {
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(0, 0, 0));
        visited[0][0][0] = true;
        Person current;
        int walk = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();

                if (current.x == n - 1 && current.y == m - 1) {
                    return walk + 1;
                }

                int nextR, nextC, ccrush;
                for (int j = 0; j < 4; j++) {
                    nextR = current.x + moveR[j];
                    nextC = current.y + moveC[j];
                    ccrush = current.crush;

                    if (isRange(nextR, nextC) && !visited[nextR][nextC][ccrush]) {
                        if (map[nextR][nextC] == '0') {
                            visited[nextR][nextC][ccrush] = true;
                            queue.offer(new Person(nextR, nextC, ccrush));
                            continue;
                        }

                        if (ccrush == 0) {
                            visited[nextR][nextC][ccrush + 1] = true;
                            queue.offer(new Person(nextR, nextC, ccrush + 1));
                        }
                    }
                }
            }
            walk++;
        }
        return -1;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }
}
