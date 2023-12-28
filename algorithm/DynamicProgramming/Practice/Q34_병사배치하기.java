package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  회고 : 문제를 직시하고 아무리 생각해도 해결 방안이 떠오르지 않았지만, LIS(가장 긴 증가하는 부분 수열) 알고리즘을 통해 해결할 수 있음을 알게 되었다.
 */
public class Q34_병사배치하기 {

    static int n;

    public void solution(int[] att){

        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        /**
         *
         * // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환해서 푸는 방법
         *
         *    Collections.reverse(v);
         *
         *    // 가장 긴 증가하는 부분 수열(LIS) 알고리즘
         *    for (int i = 1; i < n; i++) {
         *        for (int j = 0; j < i; j++) {
         *            if (att[j] < att[i])) {
         *                dp[i] = Math.max(dp[i], dp[j] + 1);
         *            }
         *        }
         *    }
         */

        // 가장 긴 감소하는 부분 수열(LDS) 알고리즘 수행
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(att[j] > att[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        /**
         * Stream 사용하기
         *
         * OptionalInt max = Arrays.stream(dp).max();
         * System.out.println(n - max.getAsInt());
         */
        int max = 0;

        for(int value : dp){
            max = Math.max(max, value);
        }

        // 열외해야 하는 병사의 최소 수 출력
        System.out.println(n - max);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[] att = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            att[i] = Integer.parseInt(st.nextToken());
        }

        new Q34_병사배치하기().solution(att);
    }
}
