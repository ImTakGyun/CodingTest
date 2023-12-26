package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 처음에 나는 점화식을 세우기 위해서 규칙성을 찾고 있었다.
 *              특정 수 (a)를 만들 때 (a-k)가 구성되는 최소한의 화폐 개수에 +1(K원짜리 화폐)한다는 아이디어까지는 생각해냈다.
 *              하지만 주어진 화폐의 종류에 따라 순차적으로 값에 대한 최소한의 화폐 구성을 update 하지 않고
 *              주어진 값에 모든 화폐 종류에 따른 if문을 통해 구현하려다보니 복잡해지고 어려워졌다.
 *
 *              이를 해결하기 위해서는 주어진 화폐 단위를 최소부터 이용하여 반복문을 통해 해당 화페가 마지막으로 추가되는 경우에 대한 최소 화폐의 개수를 구한다.
 *              이를 통해 주어진 화폐의 단위를 이용하여 각각의 값에 대해 최소한으로 구성하는 화폐 개수를 update 해나가야 한다.
 *              cnt을 10001로 초기화한 것은 만들어질 수 없는 값을 의미하며, 최소한으로 구성되는 조건을 만족시키기 위해 INF 값의 의미이다.
 *              2 15 2 3 을 가정할 때, 최소 화폐 단위인 2로 cnt에 값이 생성되는 최소한의 개수를 삽입하고
 *              3으로 다시 cnt를 사용하여 최소 개수를 삽입한다.
 */
public class 실전_효율적인화폐구성 {

    public void solution()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin);

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;

        // 화폐 단위를 거슬러 올라가면서 지정된 금액에서 화폐의 값을 뺐을 때, 화폐 구성이 가능하다면 비교해준다.
        for (int value : coin) {
            for (int i = value; i <= m; i++) {
                // (i-k)원을 만드는 방법이 존재하는 경우
                if (dp[i - value] != 10001) dp[i] = Integer.min(dp[i], dp[i - value] + 1);
            }
        }

        if (dp[m] == 10001) System.out.println(-1);
        else System.out.println(dp[m]);

//      방법2 -> 금액을 거슬러 올라가며 화폐 단위마다 "금액 - 화폐 단위"를 구성할 수 있다면 비교해준다.
//        int[] coins = new int[n];
//        for(int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            coins[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(coins);
//
//        int[] dp = new int[m+1];
//        Arrays.fill(dp, 10001);
//
//        dp[0] = 0;
//
//        for(int i = coins[0]; i <= m; i++){
//            for(int coin : coins){
//                if(i % coin == 0) dp[i] = Math.min(i / coin , dp[i]);
//                else if(i - coin >= 0 && dp[i - coin] != 10001) dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
//            }
//        }
//
//        if(dp[m] == 10001) System.out.println(-1);
//        else System.out.println(dp[m]);
    }

    public static void main(String[] args) throws IOException {
        new 실전_효율적인화폐구성().solution();
    }

}
