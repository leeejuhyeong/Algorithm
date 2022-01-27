package Programmers;

import java.util.Arrays;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int locklen = lock.length;
        int keylen = key.length;
        for (int rotation = 0; rotation < 4; rotation++) {      // key 회전 총 3번
            // 자물쇠 매칭
            answer = decoding(locklen, keylen, key, lock);

            if(answer)      // 열린다면 그만
                break;

            // 회전
            key = rotationKey(key);
        }

        return answer;
    }

    private static boolean decoding(int locklen, int keylen, int[][] key, int[][] lock) {
        boolean flag;
        int[][] newlock;
        for (int i = 0; i < keylen - 1 + locklen; i++) {
            for (int j = 0; j < keylen - 1 + locklen; j++) {
                newlock = new int[locklen + (keylen - 1) * 2][locklen + (keylen - 1) * 2];
                for (int k = 0; k < locklen; k++) {     // 자물쇠 초기화
                    for (int l = 0; l < locklen; l++) {
                        newlock[keylen - 1 + k][keylen - 1 + l] = lock[k][l];
                    }
                }

                for (int k = 0; k < keylen; k++) {      // 자물쇠 열쇠 합치기
                    for (int l = 0; l < keylen; l++) {
                        newlock[i + k][j + l] += key[k][l];
                    }
                }
                flag = true;
                for (int k = 0; k < locklen; k++) {         // 자물쇠 열쇠 일치 확인
                    for (int l = 0; l < locklen; l++) {
                        if(newlock[keylen - 1 + k][keylen - 1 + l] != 1){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] rotationKey(int[][] key) {
        int row = key.length;
        int col = key[0].length;
        int[][] rotate = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotate[j][row - 1 - i] = key[i][j];
            }
        }

        return rotate;
    }
}

