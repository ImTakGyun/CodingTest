package SWEA.동계특강;

import java.util.*;
import java.io.*;
public class AI의반란 {

    public static int n;


    // 갤럭시를 가동할 수 있는 최소 소멸 능력치 합 계산 함수
    private static int activateGalaxy(int n, int[][] abilities) {
        int[][] dp = new int[n][3];

        // dp[i][j]: i번째 요원이 j(0: 힘, 1: 지능, 2: 민첩) 능력치를 선택했을 때 최소 소멸 능력치 합
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 초기값 설정
        for (int j = 0; j < 3; j++) {
            dp[0][j] = abilities[0][j];
        }

        // 동적 프로그래밍을 통한 최적해 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + abilities[i][j]);
                    }
                }
            }
        }


        // 최종 결과 계산
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }

        // 갤럭시를 가동할 수 없는 경우 -1 반환
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 최정예 요원의 수
            int[][] abilities = new int[n][3]; // 최정예 요원들의 능력치 저장 배열

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    abilities[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = activateGalaxy(n, abilities);

            System.out.println(result);
        }
    }
}
