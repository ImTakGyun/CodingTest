package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2001 {

    public static int[][] arr;
    public static int[][] prefixSum;
    public static int n;
    public static int m;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            prefixSum = new int[n + 1][n + 1];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 누적합 구하기 -> 0 ~ n-1인 arr의 누적합을 0 ~ n의 prefixSum이라는 누적합 배열로 선언하여 1~n에 각 누적합이 들어가게 설계, x = 0 OR y = 0 라인은 x = 1 OR y = 1 라인을 만들기 위한 공간
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    prefixSum[i][j] = arr[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i -1][j - 1];
                }
            }

            int max = 0;

            for (int i = 1; i < (n + 1) - m + 1; i++) {
                for (int j = 1; j < (n + 1) - m + 1; j++) {
                    int sum = prefixSum[i + m - 1][j + m - 1] - prefixSum[i + m - 1][j - 1] - prefixSum[i - 1][j + m - 1] + prefixSum[i - 1][j - 1];
                    max = Math.max(sum, max);
                }
            }

//            # 처참한 4중 for문... 누적합을 몰랐을 때 몸으로 때우기
//            for(int i = 0; i < (n - m + 1); i++){
//                for(int p = 0; p < (n - m + 1); p++) {
//                    int sum = 0;
//                    for (int j = i; j < i + m; j++) {
//                        for (int q = p; q < p + m; q++) {
//                            sum += arr[j][q];
//                            if (max < sum) max = sum;
//                        }
//                    }
//                }
//            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
