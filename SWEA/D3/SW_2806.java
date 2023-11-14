package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <주어지는 조건들을 최대한 코드상에서 편하게 사용할 수 있도록 정리한다.>
 *              <백트래킹의 종료조건을 설정하고 수행할 동작을 구현한다.>
 *              <또한 모든 경우에 대한 조사이므로 회귀 이후의 동작을 설정한다.>
 *
 *              - 진짜 머리털 빠지게 어려운 문제였다.
 *              - 백트래킹 기법을 사용하기 위한 동작들을 정리할 수 있었다.
 *              - 우선, 주어지는 조건이 많다면 최대한 줄이기 위해 논리적인 생각을 펼쳐보자.
 *              - 이 경우에는 퀸은 언제나 같은 행에 못 온다는 개념을 통해 (x, y) 좌표에 대한 생각을 행을 지정하고 열만 고려하게끔 단순화하였다.)
 *              - 또한 v1(열), v2(오른쪽 대각선), v3(왼쪽 대각선)으로 단순함으로써 코드를 최소화하였다.
 *
 *              - 아무튼 백트래킹 기법을 사용하기 위해서는
 *              - (1) 종료 조건 설정(성공 회귀) (2) 어떤 동작을 수행하고 재귀할 것인지
 *              - (3) 재귀에서 회귀하고 어떤 동작을 수행할 것인지 (4) 더 이상 재귀를 못한다면 어떤 동작을 하고 회귀할 것인지에(실패 회귀) 대해서 정해야한다.
 *
 *              이 경우에는
 *              - (1) => 행의 값이 n이 되면 result를 증가시키고 성공 회귀하도록 설정했다.
 *              - (2) => 주어진 행에서 y번째 열에 퀸을 배치할 수 있는지 확인하고(v1,v2,v3가 0) 가능하다면 배치한 후(v1, v2, v3를 1로 바꾼다.) 재귀한다.
 *              - (3) => 재귀에서 회귀하면<해당 경우가 종료 -> n-queen 만족으로 result를 증가시키거나(성공) 퀸을 배치할 곳이 더 이상 없거나(실패)>
 *  *                    다음 경우를 계산하기 위해서 x,y에서의 퀸을 걷어내고(v1,v2,v3 를 0으로 초기화) 동작을 이어서 수행한다.(for문이 끝나면 (4) 수행)
 *              - (4) => 모든 조건 종료하면 회귀한다.
 *
 */
public class SW_2806 {

    public static int n;
    public static int result;

    public static int[] v1;
    public static int[] v2;
    public static int[] v3;

    /**
     * @param x => 0번째 행부터 순차적으로 순회하며 현재의 행에서 y번째 열의 칸에 퀸을 배치하는 경우에 대한 dfs
     */
    public static void dfs(int x){

        // <종료 조건을 설정>
        // 0번째 행부터 퀸을 배치하는 동작을 수행하기 때문에 n번째 행과 같다면 n개의 퀸을 모두 배치한 경우이므로 result를 증가시킨다.
        if(x == n) {
            result++;
            return;
        }

        // x번째 행에서 y번째 열에 퀸을 배치하는 경우에 대해 백트래킹을 수행한다.
        for(int y = 0; y < n; y++){
            // (x, y) 번째 칸에 대해서 v1(y열), v2(x+y 대각선), v3((n - 1) + x - y 대각선)에 모두 퀸이 배치되어 있지 않다면
            if(v1[y] == 0 && v2[x + y] == 0 && v3[(n-1) + x - y] == 0) {
                // v1, v2, v3를 1로 바꿔준다. => (x, y)에 퀸을 배치한다는 뜻
                v1[y] = v2[x + y] = v3[(n - 1) + x - y] = 1;
                // 퀸을 배치했다면 이후의 행에 대해서 dfs를 수행한다.
                dfs(x+1);
                // 위에서 수행한 dfs가 종료하면(모든 경우를 구하는 것이므로 성공이든 실패이든 수행한다 => 백트래킹),
                // 다음 경우를 계산하기 위해서 (x, y)에서 퀸을 제거하고(v1, v2, v3를 초기화) 다음 열(y)에 대해서 조사한다.
                v1[y] = v2[x + y] = v3[(n - 1) + x - y] = 0;
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            // N x N 에 해당하는 n을 입력받는다.
            n = Integer.parseInt(st.nextToken());
            // n-queen 조건에 만족하는 경우의 수를 저장할 변수를 선언한다.
            result = 0;

            v1 = new int[n];            // 열의 개수 n개
            v2 = new int[n*2];          // 북동쪽 대각선(i + j) => 2n - 1 개 (0 ~ 2n - 2)
            v3 = new int[n*2];          // 북서쪽 대각선((n - 1) + i - j) => 2n - 1개 (0 ~ 2n - 2)

            // 0행부터 시작한다.
            dfs(0);

            System.out.println("#" + test_case + " " + result);
        }
    }
}
