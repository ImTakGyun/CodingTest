package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

public class Q31_금광 {

    static int n,m;

    public void solution(int[][] golds){
        int[][] dp = new int[n][m];

        // 다이나믹 프로그래밍을 위한 2차원 DP 테이블
        for(int i = 0; i < n; i++){
            dp[i][0] = golds[i][0];
        }

        // 다이나믹 프로그래밍 진행 : 현재 열까지 채굴한 금 누적하기
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                // 직전 열 지정
                int col = i - 1;

                // 현재 채굴하려는 금의 행을 기준으로 직전 열까지 누적된 채굴 금값 확인 및 update
                for(int row = j - 1; row <= j + 1; row++) {
                    // 행에 +1, +0, -1 을 했을 때 범위 내에 존재한다면 계산 진행
                    if(row >= 0 && row < n) {
                        // 현재 금을 채굴할 때, 누적된 금 값을 기준으로 최대 누적값 구하기
                        dp[j][i] = Math.max(dp[j][i], dp[row][col] + golds[j][i]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][m - 1]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        // 테스트 케이스(Test Case) 입력
        int test = Integer.parseInt(st.nextToken());

        for(int i = 0; i < test; i++) {
            // 금광 정보 입력
            st= new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int[][] golds = new int[n][m];

            st= new StringTokenizer(br.readLine());
            for(int t = 0; t < n; t++){
                for(int j = 0; j < m; j++){
                    golds[t][j] = Integer.parseInt(st.nextToken());
                }
            }

            new Q31_금광().solution(golds);
        }
    }
}

