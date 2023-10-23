package algorithm.implementation.practice;

import java.util.*;
import java.io.*;

public class Q10_자물쇠와열쇠 {

    boolean answer;

    // 2차원 리스트 90도 회전하기
    public int[][] rotateMatrixBy90Degree(int[][] a){

        int n = a.length;
        int m = a[0].length;

        int[][] result = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    // 자물쇠의 중간 부분이 모두 1인지 확인
    public boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {

        int n = lock.length;
        int m = key.length;

        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n*3][n*3];

        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newLock[n+i][n+j] = lock[i][j];
            }
        }

        // key를 90,180,270,360 회전시키면서 확인하기
        for(int rotate = 0; rotate < 4; rotate++) {
            key = rotateMatrixBy90Degree(key);
            // 열쇠를 이동시키면서 확인하기
            for (int i = 0; i < n * 2; i++) {
                for (int j = 0; j < n * 2; j++) {

                    // 열쇠와 자물쇠의 합 구하기
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            newLock[i + x][j + y] += key[x][y];
                        }
                    }

                    // 열쇠와 자물쇠의 합에서 자물쇠가 모두 1로 만족하는지 확인하기
                    if (check(newLock)) answer = true;

                    // 자물쇠가 풀리지 않았다면 원상태로 되돌리기(자물쇠 - 키)
                    else {
                        for (int x = 0; x < m; x++) {
                            for (int y = 0; y < m; y++) {
                                newLock[i + x][j + y] -= key[x][y];
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{

        int[][] key =  {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};

        boolean result = new Q10_자물쇠와열쇠().solution(key, lock);
        System.out.println(result);
    }
}
