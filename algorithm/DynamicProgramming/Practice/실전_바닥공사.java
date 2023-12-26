package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 다이나믹 프로그래밍의 기초 예제인 <타일링 유형>
 *              (1) 왼쪽부터 차례대로 바닥을 덮개로 채운다고 가정하자.
 *              (2) i 길이의 바닥을 채운다고 할 때, i-1 까지 타일링이 되어있다면 i번째는 2x1짜리 타일 밖에 들어가지 못한다.
 *              (3) 그렇다면 맨 끝쪽에 1x2 또는 2x2 타일이 들어가려면 어떻게 해야할까?
 *              (4) i-2길이까지 타일링이 되었다고 가정하고 1x2 또는 2x2 타일을 추가하는 상황을 가정하면 된다.
 *              (5) 이를 정리해보면 <i-1까지의 타일링 경우의 수> + <i-2까지의 타일링 경우의 수 x 2> = <i길이의 타일링 경우의 수> 로 점화식을 세울 수 있다.
 */
public class 실전_바닥공사 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] * 2;
        }

        System.out.println(dp[n] % 796796);
    }

    public static void main(String[] args) throws IOException {
        new 실전_바닥공사().solution();
    }
}
