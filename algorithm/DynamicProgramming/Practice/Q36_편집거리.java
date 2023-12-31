package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  회고 : 편집 거리 구하는 알고리즘의 경우 암기가 필요할 것 같다.
 *        간단한 이해로는 DP에 맞게 주어진 2개의 문자열을 앞에서부터 비교하고 그 뒷 부분은 앞선 계산에 기반하는 것이다.
 *        같은 문자 비교의 경우 그 순간은 해당 문자가 문자열의 끝 부분이므로 그 직전 앞까지의 비교에 대한 편집거리와 같고
 *        다른 문자 비교의 경우 교체, 삽입, 삭제의 경우에 따라 교체(i -1, j - 1), 삽입(i, j - 1 또는 i - 1, j) 에 대한 편집 거리의 최소에 + 1 한 것과 같다.
 */

public class Q36_편집거리 {

    // 최소 편집 거리(Edit Distance) 계산을 위한 다이나믹 프로그래밍
    public void solution(String A, String B){

        // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for(int i = 0; i <= A.length(); i++){
            dp[i][0] = i;
        }

        for (int j = 1; j <= B.length(); j++) {
            dp[0][j] = j;
        }

        // 최소 편집 거리 계산
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                // 문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 대입
                if(A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];

                // 문자가 다르다면, 세 가지 경우 중에서 최솟값 찾기
                // 삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 대입
                else dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i -1][j - 1]));
            }
        }

        // 최소 편집 거리 출력
        System.out.println(dp[A.length()][B.length()]);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String B = st.nextToken();

        new Q36_편집거리().solution(A, B);
    }

}
