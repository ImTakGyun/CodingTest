package SWEA.D4;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <완전 탐색 + 백트래킹> : n개의 숫자들 중 조합을 통해 주어진 b보다 큰 경우의 수를 계산해야한다.
 *                                  이 때, 주어진 숫자들을 순차적으로 순회하며 해당 숫자를 더하는 경우와 더하지 않는 경우로 나누어 모든 경우를 계산한다.
 *                                  백트래킹을 통해 회귀하며 모든 경우를 계산한다.
 */
public class SW_1486 {
    public static int n;
    public static int b;
    public static int[] arr;
    public static ArrayList<Integer> height;

    public static void dfs(int index, int sum){

        if(index == n){
            if(sum >= b){
                height.add(sum);
            }
            return;
        }

        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr = new int[n];
            height = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 완전탐색 + 백트래킹 => 수어진 숫자열을 시작부터 순회하며 더할지 말지 경우를 나누어 모든 경우를 계산한다.
            dfs(0, 0);

            Collections.sort(height);

            System.out.println("#" + test_case + " " + (height.get(0) - b));
        }
    }
}
