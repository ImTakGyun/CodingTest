package Programmers.DP;

import java.util.*;
import java.io.*;

public class P_정수삼각형 {

    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int n = triangle.length;

            int[][] dp = new int[n+1][n+1];

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= i; j++){
                    dp[i][j] = triangle[i-1][j-1] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }

            for(int value : dp[n]) answer = Math.max(answer, value);

            return answer;
        }

        /** 최적의 답안
         *
         public int solution(int[][] triangle) {
            for (int i = 1; i < triangle.length; i++) {
                //모든 행의 첫번째와 마지막행은 계산식을 지정해두고
                triangle[i][0] += triangle[i-1][0];
                triangle[i][i] += triangle[i-1][i-1];

                //2번째부터 마지막 전까지에 대한 로직을 구현해준다.
                for (int j = 1; j < i; j++)
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }

            return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        }
        */

    }

    public static void main(String[] args){
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = new P_정수삼각형.Solution().solution(triangle);

        System.out.println(answer);
    }
}
