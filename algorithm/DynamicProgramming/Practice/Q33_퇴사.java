package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

public class Q33_퇴사 {

    static int n;

    public void solution(ArrayList<ArrayList<Integer>> list){
        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        int[] dp = new int[n+1];

        for(int i = 0; i < n; i++){

            int period = list.get(i).get(0);
            int cost = list.get(i).get(1);

            // 상담이 기간 안에 끝나는 경우, 상담 종료일에 받을 수 있는 최대값 구하기(지금까지 누적액 + 현재 상담액 VS 다른 상담을 통한 종료일의 누적액)
            if(i + period <= n) dp[i + period] = Math.max(dp[i] + cost , dp[i + period]);

            // 다음날의 상담 최대 누적액 구하기(오늘까지의 누적액이 최대라면 내일 누적액도 현재의 누적액일 것이기 때문)
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 상담 개수
        n = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            // 각 상담을 완료하는데 걸리는 기간
            list.get(i).add(Integer.parseInt(st.nextToken()));
            // 각 상담을 완료했을 때 받을 수 있는 금액
            list.get(i).add(Integer.parseInt(st.nextToken()));
        }

        new Q33_퇴사().solution(list);
    }
}
