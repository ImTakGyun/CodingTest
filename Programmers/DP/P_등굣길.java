package Programmers.DP;

import java.util.*;
import java.io.*;

/**
 * 회고 : 생각해내는데 별다른 어려움은 없는 문제였다.
 *       하나의 목표 지점은 그 지점에서 상하좌우 1칸 이전의 경로들로부터의 경우가 존재한다.
 *       따라서 나는 오른쪽부터 훑으며 아래로 내려가는 방식으로
 *       1,1 에 1을 삽입하고 오른쪽으로 가면서 해당 칸의 1칸 왼쪽(left)과 위쪽(up)의 합을 구했다.
 *       이는 해당 칸까지의 경로 최소 경우의 개수이다.
 */

public class P_등굣길 {

    static class Solution{
        public int solution(int n, int m, int[][] puddles){
            int[][] dp = new int[n+1][m+1];

            for(int i = 0; i < puddles.length; i++){
                int x = puddles[i][0];
                int y = puddles[i][1];
                dp[x][y] = -1;
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(i == 1 && j == 1) dp[i][j] = 1;
                    else if(dp[i][j] == -1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    else {
                        int up = dp[i-1][j];
                        int left = dp[i][j-1];
                        dp[i][j] = (up + left) % 1000000007;
                    }
                }
            }
            return dp[n][m];
        }
    }

    public static void main(String[] args){

        int n = 3, m = 4;
        int[][] puddles = {{2, 2}};
        int answer = new P_등굣길.Solution().solution(n, m, puddles);
        System.out.println(answer);
    }
}
