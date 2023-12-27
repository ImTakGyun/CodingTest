package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

public class Q32_정수삼각형 {

    static int n;

    public void solution(int[][] tri){
        // 다이나믹 프로그래밍을 위한 DP 테이블 초기화
        int[][] dp = new int[n][n];

        dp[0][0] = tri[0][0];

        // 다이나믹 프로그래밍으로 2번째 줄부터 내려가면서 확인
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                int up = i - 1;
                // 왼쪽 위에서 내려오는 경우
                int left = j - 1;
                // 바로 위에서(오른쪽) 내려오는 경우
                int right = j;

                // 최대 합을 저장
                if(left < 0) dp[i][j] = dp[up][right] + tri[i][j];
                else if(right == i) dp[i][j] = dp[up][left] + tri[i][j];
                else dp[i][j] = tri[i][j] + Math.max(dp[up][left], dp[up][right]);
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(dp[n-1][i], max);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[][] tri = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        new Q32_정수삼각형().solution(tri);
    }
}
