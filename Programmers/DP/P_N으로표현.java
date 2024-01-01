package Programmers.DP;

import java.util.*;
import java.io.*;

public class P_N으로표현 {

    static class Solution {
        public int solution(int N, int number) {
            int answer = -1;

            // 주어진 수와 구해야할 수가 같다면 1번만 사용하면 되기 때문에 return 1;
            if(N == number) return 1;

            // dp 테이블 초기화, 중복 제거를 위해 Set 사용
            Set<Integer>[] dp = new Set[8];

            int n = N;

            // dp 테이블에 주어진 수가 (i + 1)번 사용된 기본적인 경우 추가 ( Ex, 5, 55, 555, 5555, .... -> 최대 8번까지 가능(문제의 조건 참고))
            for(int i = 0; i < 8; i++){
                dp[i] = new HashSet<>();
                dp[i].add(n);
                n = n * 10 + N;
            }

            // 주어진 수를 i번 사용하는 경우, 그 앞에서부터 j번(1 이상) 사용한 경우와 (i-1-j)번 사용한 경우에 대해
            // 모든 원소 각각 사칙 연산을 수행함으로써 i번 사용한 값들을 구할 수 있다.
            for(int i = 1; i < 8; i++){
                for(int j = 0; j < i; j++){
                    for(int op1 : dp[j]){
                        for(int op2 : dp[i-j-1]){
                            dp[i].add(op1 + op2);
                            dp[i].add(op1 - op2);
                            dp[i].add(op1 * op2);
                            // 0으로 나누는 경우 제외
                            if(op2 != 0)
                                dp[i].add(op1 / op2);
                        }
                    }
                }

                // 구해야할 수(number)가 등장했다면 break
                if(dp[i].contains(number)) {
                    answer = i + 1;
                    break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());

        int answer = new P_N으로표현.Solution().solution(N, number);
        System.out.println(answer);
    }
}
