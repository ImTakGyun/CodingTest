package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : X가 되기 위해서는 4가지 연산의 종류가 있다.
 *              최소 횟수로 1이 된다는 것을 핵심 아이디어로 삼아서 점화식을 세운다.
 *              X는 책의 그래프처럼 나타낼 수 있다.
 *              따라서, x가 될 때까지 i를 2에서부터 늘려나가며 각각의 i가 1이 되는 최소 연산횟수를 구한다.
 *              이를 통해 메모이제이션을 진행한다면, x에 대한 최소연산 횟수를 구할 수 있다.
 */

public class 실전_1로만들기{

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int[] d = new int[30001];

    public void solution()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        System.out.println(d[x]);
    }

    public static void main(String[] args) throws IOException {
        new 실전_1로만들기().solution();
    }
}
